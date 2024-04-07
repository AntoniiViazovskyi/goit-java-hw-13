package com.goit.dao;

import com.goit.entity.Ticket;

import java.util.List;

public interface TicketDao {
    boolean createTicket(Ticket ticket);

    Ticket getTicketById(Long id);

    boolean deleteTicketById(Long id);

    boolean updateTicket(Ticket ticket);

    List<Ticket> getAllTickets();
}
