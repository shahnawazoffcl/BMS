package org.example.bms_book_ticket.repository;

import org.example.bms_book_ticket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}