package com.projects.ticket.booking.model;

import java.util.Map;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "shows")
public class Show {
    @Id private String id;
    private String movieId;
    private String theatreId;
    private LocalDateTime showTime;
    private Map<String, Boolean> seatAvailability;
}

