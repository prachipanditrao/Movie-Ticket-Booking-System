package com.projects.ticket.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.ticket.booking.dto.BookingRequest;
import com.projects.ticket.booking.model.Booking;
import com.projects.ticket.booking.model.Show;
import com.projects.ticket.booking.repository.ShowRepository;
import com.projects.ticket.booking.service.impl.BookingServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingServiceImpl bookingService;

    @Autowired
    private ShowRepository showRepository;

    public BookingController(BookingServiceImpl bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public Mono<ResponseEntity<Booking>> book(@RequestBody BookingRequest request) {
        return bookingService
        .bookTickets(request.getShowId(), request.getSeatNumbers(), request.getUserId())
        .map(ResponseEntity::ok)
        .onErrorResume(e -> Mono.just(ResponseEntity.badRequest().build()));
    }

    @GetMapping("/shows")
    public Flux<Show> getAllShows() {
        return showRepository.findAll();
    }

    @GetMapping("/shows/{movieId}")
    public Flux<Show> getShowsByMovie(@PathVariable String movieId) {
        return showRepository.findAll()
            .filter(show -> show.getMovieId().equals(movieId));
    }
}

