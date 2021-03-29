package com.xiangen.assignment.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new Date();
		SimpleDateFormat dt = new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, YYYY");
		model.addAttribute("currentDate", dt.format(date));
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		Date date = new Date();
		SimpleDateFormat dt = new SimpleDateFormat("h:mma");
		model.addAttribute("currentTime", dt.format(date));
		return "time.jsp";
	}
}
