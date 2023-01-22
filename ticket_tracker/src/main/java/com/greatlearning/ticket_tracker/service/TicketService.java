package com.greatlearning.ticket_tracker.service;

import java.util.List;

import com.greatlearning.ticket_tracker.entity.Ticket;

public interface TicketService {

	public List<Ticket> getAllTickets();

	public void saveTicket(Ticket ticket);

	public void deleteTicketById(int id);

	public Ticket getTicketById(int id);
	
	public List<Ticket> searchTickets(String str);
}
