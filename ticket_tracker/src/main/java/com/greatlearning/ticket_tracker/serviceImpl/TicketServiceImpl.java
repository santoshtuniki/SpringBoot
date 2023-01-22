package com.greatlearning.ticket_tracker.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greatlearning.ticket_tracker.entity.Ticket;
import com.greatlearning.ticket_tracker.repository.TicketRepository;
import com.greatlearning.ticket_tracker.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepository;

	@Override
	public List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public void saveTicket(Ticket ticket) {
		ticketRepository.save(ticket);
		ticketRepository.flush();
	}

	@Override
	public void deleteTicketById(int id) {
		ticketRepository.deleteById(id);
	}

	@Override
	public Ticket getTicketById(int id) {
		Optional<Ticket> result = ticketRepository.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new RuntimeException("Ticket does not exist for Id: " + id);
		}
	}

	@Override
	public List<Ticket> searchTickets(String str) {
		Ticket ticket = new Ticket();
		ticket.setTitle(str);
		ticket.setDescription(str);
		ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
				.withMatcher("title", ExampleMatcher.GenericPropertyMatchers.contains())
				.withMatcher("description", ExampleMatcher.GenericPropertyMatchers.contains())
				.withIgnorePaths("id","content","createdDate");
		Example<Ticket> example = Example.of(ticket,exampleMatcher);
		return ticketRepository.findAll(example, Sort.by("title"));
	}

}
