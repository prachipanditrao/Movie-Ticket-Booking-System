package com.projects.ticket.booking.repository;

import com.projects.ticket.booking.model.Booking;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends ReactiveMongoRepository<Booking, String> {}


