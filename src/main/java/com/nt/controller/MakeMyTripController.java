package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.request.Passenger;
import com.nt.response.Ticket;
import com.nt.service.MakeMyTripService;

@Controller
public class MakeMyTripController {
	@Autowired
	private MakeMyTripService service;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("req", new Passenger());
		return "index";
	}
	@GetMapping("/book")
	public String bookPage(Model model) {
		model.addAttribute("req", new Passenger());
		return "book";
	}
	@GetMapping("/check")
	public String checkPage(Model model) {
		model.addAttribute("id", new Ticket());
		return "check";
	}
	@GetMapping("/status")
	public String statusPage(Model model) {
		model.addAttribute("req", new Passenger());
		return "status";
	}
	@PostMapping("/booking")
	public String bookTkt(@ModelAttribute("req") Passenger request,Model model) {
		
		
		Ticket tktInfo=service.bookTicket(request);
		model.addAttribute("msg", "your ticket book Id : "+tktInfo.getTktId());
		
		return "book";
	}
	@PostMapping("/checking")
	public String checkStatus(@ModelAttribute("id") Ticket tkt,Model model) {
		Ticket tktInfo=service.getTicket(tkt);
		model.addAttribute("tkt", tktInfo);
		model.addAttribute("msg", "Enjoy your happy journey "+tktInfo.getName());
		
		return "status";
	}
	
	@GetMapping("/history")
	
	public String viewTickets(Model model) {
		List<Ticket> allTicket=service.getAllTickets();
		model.addAttribute("tickets", allTicket);
		return "history";
	}
}
