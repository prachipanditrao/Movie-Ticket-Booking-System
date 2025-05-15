package com.projects.ticket.booking.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.projects.ticket.booking.model.Booking;
import com.projects.ticket.booking.model.BookingStatus;
import com.projects.ticket.booking.repository.BookingRepository;
import com.projects.ticket.booking.repository.ShowRepository;

import reactor.core.publisher.Mono;

@Service
public class BookingServiceImpl {
    private final BookingRepository bookingRepo;
    private final ShowRepository showRepo;

    public BookingServiceImpl(BookingRepository bookingRepo, ShowRepository showRepo) {
        this.bookingRepo = bookingRepo;
        this.showRepo = showRepo;
    }

    public Mono<Booking> bookTickets(String showId, List<String> seats, String userId) {
        return showRepo.findById(showId)
            .flatMap(show -> {
                
                boolean allAvailable = seats.stream().allMatch(seat -> show.getSeatAvailability().getOrDefault(seat, false));

                if (!allAvailable) {
                    return Mono.error(new RuntimeException("Some seats are already booked"));
                }

                seats.forEach(seat -> show.getSeatAvailability().put(seat, false));

                return showRepo.save(show).flatMap(savedShow -> {
                    Booking booking = new Booking();
                    booking.setShowId(showId);
                    booking.setUserId(userId);
                    booking.setSeatNumbers(seats);
                    booking.setBookingTime(LocalDateTime.now());
                    booking.setStatus(BookingStatus.CONFIRMED);
                    return bookingRepo.save(booking);
                });
            });
    }
}

