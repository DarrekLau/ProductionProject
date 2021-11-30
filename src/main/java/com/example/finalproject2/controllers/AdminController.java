package com.example.finalproject2.controllers;

import com.example.finalproject2.models.Booking;
import com.example.finalproject2.repository.BookingRepository;
import com.example.finalproject2.services.BookingService;
import com.example.finalproject2.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private EmailService emailService;


    @GetMapping("/admin")
    public String adminPage(Model model, String keyword){
        List<Booking> list;
        if(keyword != null){
            list = bookingService.getBookingByKeyword(keyword);
        }
        else{
            list = bookingService.getAllBookings(model);
        }
        model.addAttribute("booking", list);
        return "adminview";
    }

    @GetMapping("admin/update")
    public ModelAndView showUpdateForm(@RequestParam Long id){
        ModelAndView bookingMav = new ModelAndView("updatebooking");
        Booking booking = bookingRepository.findById(id).get();
        bookingMav.addObject("booking", booking);
        return bookingMav;
    }

    @PostMapping("/admin/saveupdate")
    public String saveUpdate(Booking booking) throws MessagingException {
        bookingService.addBooking(booking);
        emailService.sendMail(booking);
        return "redirect:/admin";
    }

    @GetMapping("admin/delete")
    public String deleteBooking(@RequestParam Long id){
        bookingService.deleteBooking(id);
        return "redirect:/admin";
    }
}
