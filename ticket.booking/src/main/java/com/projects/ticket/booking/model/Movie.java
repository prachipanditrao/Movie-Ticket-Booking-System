package com.projects.ticket.booking.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Duration;

@Data
@Document(collection = "movies")
public class Movie {
    @Id
    private String id;
    private String name;
    private String genre;
    private Duration duration;
}
