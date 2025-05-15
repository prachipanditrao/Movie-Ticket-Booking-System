package com.projects.ticket.booking.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@Document(collection = "theatres")
public class Theatre {
    @Id private String id;
    private String name;
    private String city;
    private List<Screen> screens;
}

