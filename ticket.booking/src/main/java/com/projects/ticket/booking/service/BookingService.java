package com.projects.ticket.booking.service;

import java.util.List;

import com.projects.ticket.booking.model.Booking;

import reactor.core.publisher.Mono;

public interface BookingService {
    public Mono<Booking> bookTickets(String showId, List<String> seats, String userId);
}
