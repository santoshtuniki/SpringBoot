package com.greatlearning.ticket_tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.ticket_tracker.entity.Ticket;
import com.greatlearning.ticket_tracker.service.TicketService;

@Controller
@RequestMapping("/admin")
public class TicketController {
	
	@Autowired
	TicketService ticketService;

	@GetMapping("/tickets")
	public String getTickets(Model model) {
		List<Ticket> tickets = ticketService.getAllTickets();
		model.addAttribute("tickets", tickets);
		return "tickets";
	}
	
	@GetMapping("/tickets/newTicket")
	public String createTicket(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "create_ticket";
	}
	
	@GetMapping("/tickets/edit/{id}")
	public String editTicket(Model model,@PathVariable("id") int id) {
		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "edit_ticket";
	}
	
	@GetMapping("/tickets/delete/{id}")
	public String deleteTicket(@PathVariable("id") int id) {
		ticketService.deleteTicketById(id);
		return "redirect:/admin/tickets";
	}
	
	@GetMapping("/tickets/view/{id}")
	public String viewTicket(Model model,@PathVariable("id") int id) {
		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "view_ticket";
	}
	
	@PostMapping("/tickets")
	public String addTicket(@ModelAttribute(name="ticket") Ticket ticket) {
		ticketService.saveTicket(ticket);
		return "redirect:/admin/tickets";
	}
	
	@PostMapping("/tickets/{id}")
	public String updateTicket(@ModelAttribute(name="ticket") Ticket ticket, @PathVariable("id") int id) {
		Ticket existingTicket = ticketService.getTicketById(id);
		if(existingTicket.getId()==ticket.getId()) {
			existingTicket.setTitle(ticket.getTitle());
			existingTicket.setDescription(ticket.getDescription());
			existingTicket.setCreatedDate(ticket.getCreatedDate());
			existingTicket.setContent(ticket.getContent());
		}
		ticketService.saveTicket(existingTicket);
		return "redirect:/admin/tickets";
	}
	
	@PostMapping("/tickets/search")
	public String getSearchResults(Model model,@RequestParam("search") String search) {
		List<Ticket> ticket = ticketService.searchTickets(search);
		model.addAttribute("value", search);
		model.addAttribute("tickets",ticket);
		return "tickets";
	}
}
