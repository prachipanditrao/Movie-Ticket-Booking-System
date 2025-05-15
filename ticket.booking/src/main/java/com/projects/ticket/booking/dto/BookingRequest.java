package com.projects.ticket.booking.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookingRequest {
    private String userId;
    private String showId;
    private List<String> seatNumbers;
}

