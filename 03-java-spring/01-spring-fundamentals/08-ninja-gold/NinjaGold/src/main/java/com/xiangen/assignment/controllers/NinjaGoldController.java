package com.xiangen.assignment.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldController {
	
	@GetMapping("/")
	public String gold(HttpSession session, Model model) {
		ArrayList<String> activity = new ArrayList<String>();
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		} 
		if(session.getAttribute("activity") == null) {
			session.setAttribute("activity", activity);
		}
		model.addAttribute("totalGold", session.getAttribute("gold"));
		model.addAttribute("activity", session.getAttribute("activity"));
		return "index.jsp";
	}
	
	@PostMapping("/findGold")
	public String findGold(HttpSession session, @RequestParam("building") String building) {
//		System.out.println(building);
		Random r = new Random();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd YYYY h:mma");
		String formatted = now.format(formatter);
		ArrayList<String> activity = (ArrayList<String>)session.getAttribute("activity");
		int gold = (int)session.getAttribute("gold");
		int goldThisTurn;
		if(building.equals("farm")) {
			//do farm stuff
			goldThisTurn = r.nextInt((20 -10) + 1) + 10;
			activity.add(String.format("You entered a %s and earned %d gold %s \n", building, goldThisTurn, formatted));
		} else if(building.equals("cave")) {
			//do cave stuff
			goldThisTurn = r.nextInt((10 -5) + 1) + 5;
			activity.add(String.format("You entered a %s and earned %d gold %s \n", building, goldThisTurn, formatted));
		} else if(building.equals("house")) {
			//do house stuff
			goldThisTurn = r.nextInt((5 -2) + 1) + 2;
			activity.add(String.format("You entered a %s and earned %d gold %s \n", building, goldThisTurn, formatted));
		} else if(building.equals("spa")) {
			//do spa stuff
			goldThisTurn = r.nextInt((-5 + 20) + 1) -20;
			activity.add(String.format("You entered a %s and lost %d gold. ouch! %s \n", building, goldThisTurn, formatted));
		} else {
			//do casino stuff
			goldThisTurn = r.nextInt((50 + 50) + 1) - 50;
			if(goldThisTurn < 0) {
				activity.add(String.format("You entered a %s and lost %d gold. ouch! %s \n", building, goldThisTurn, formatted));
			} else {
				activity.add(String.format("You entered a %s and won! %d gold %s \n", building, goldThisTurn, formatted));
			}
			
		}
		int totalGold = gold += goldThisTurn;
		session.setAttribute("gold", totalGold);
		session.setAttribute("activity", activity);
		return "redirect:/";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
