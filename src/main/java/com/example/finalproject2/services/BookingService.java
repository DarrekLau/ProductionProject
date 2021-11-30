package com.example.finalproject2.services;

import com.example.finalproject2.models.Booking;
import com.example.finalproject2.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings(Model model){
        return bookingRepository.findAll();
    }

    public List<Booking> getBookingByKeyword (String keyword){
        return bookingRepository.findByKeyword(keyword);
    }

    public void addBooking(Booking booking){
        bookingRepository.save(booking);
    }

    public void deleteBooking(Long id){
        bookingRepository.deleteById(id);
    }


}
