package com.projects.ticket.booking.repository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.projects.ticket.booking.model.Theatre;

@Repository
public interface TheatreRepository extends ReactiveMongoRepository<Theatre, String> {}
