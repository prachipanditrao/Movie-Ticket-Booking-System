package com.projects.ticket.booking.repository;

import com.projects.ticket.booking.model.Show;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends ReactiveMongoRepository<Show, String> {}


