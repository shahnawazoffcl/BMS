package org.example.bms_book_ticket.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Setter
@ToString
@Getter
@Entity
public class Ticket extends BaseModel{
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    private String show;
    private String userId;
    @ManyToMany
//    private List<ShowSeat> showSeats;
//    @OneToMany
//    private List<Payment> payments;
    private Date bookingDate;
    private double amount;
}
