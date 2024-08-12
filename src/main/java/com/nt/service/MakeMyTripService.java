package com.nt.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nt.request.Passenger;
import com.nt.response.Ticket;

@Service
public class MakeMyTripService {

	public Ticket bookTicket(Passenger p) {
		String apiUrl="http://localhost:8080/ticket";
		
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Ticket> forEntity=rt.postForEntity(apiUrl, p, Ticket.class);
		
		Ticket body=forEntity.getBody();
		
		return body;
	}
	
	public List<Ticket> getAllTickets(){
		
		String apiUrl="http://localhost:8080/tickets";
		
		RestTemplate rt=new RestTemplate();
		
		ResponseEntity<Ticket[]> forEntity=rt.getForEntity(apiUrl,Ticket[].class);
		
		Ticket[] body=forEntity.getBody();
		
		List<Ticket> tickets=Arrays.asList(body);
		
		return tickets;
	}
	
	public Ticket getTicket(Ticket t) {
		
		String apiUrl="http://localhost:8080/ticket/"+t.getTktId();
		System.out.println(apiUrl);
		
		RestTemplate rt=new RestTemplate();
		
		ResponseEntity<Ticket> forEntity=rt.getForEntity(apiUrl, Ticket.class);
		
		Ticket body=forEntity.getBody();
		System.out.println(body);
		
		return body;
	}
	
}
