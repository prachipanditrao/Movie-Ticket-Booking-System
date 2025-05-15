package com.projects.ticket.booking.model;

import lombok.Data;
import java.util.Map;

@Data
public class Screen {
    private String screenId;
    private String name;
    private int totalSeats;
    private Map<String, Boolean> seatMap;
}

