package com.projects.ticket.booking.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.time.LocalDateTime;

@Data
@Document(collection = "bookings")
public class Booking {
    @Id private String id;
    private String userId;
    private String showId;
    private List<String> seatNumbers;
    private BookingStatus status;
    private LocalDateTime bookingTime;
}

