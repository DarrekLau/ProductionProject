package com.example.finalproject2.controllers;

import com.example.finalproject2.models.Booking;
import com.example.finalproject2.services.BookingService;
import com.example.finalproject2.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private EmailService emailService;

    @GetMapping("/booking")
    public ModelAndView addBooking() {

        ModelAndView bookingMav = new ModelAndView("booking");
        Booking newBooking = new Booking();
        bookingMav.addObject("booking", newBooking);
        return bookingMav;
    }

    @PostMapping("/saveBooking")
    public String saveBooking(Booking booking) throws MessagingException {
        bookingService.addBooking(booking);
        emailService.sendMail(booking);
        return "confirmation"; // to be amended to homepage.etc after booking is submitted
    }
}

