package com.xiangen.assignment.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xiangen.assignment.models.Event;
import com.xiangen.assignment.models.Message;
import com.xiangen.assignment.models.User;
import com.xiangen.assignment.services.EventService;
import com.xiangen.assignment.services.MessageService;
import com.xiangen.assignment.services.UserService;
import com.xiangen.assignment.validators.UserValidator;

@Controller
public class HomeController {
	@Autowired
	private UserService uService;
	@Autowired
	private EventService eService;
	@Autowired
	private UserValidator uValidator;
	@Autowired
	private MessageService mService;
	
	// register, login, logout
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}
	
	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		this.uValidator.validate(user, result);
		if(result.hasErrors()) {
			return "index.jsp";
		}
		User newUser = this.uService.registration(user);
		session.setAttribute("user__id", newUser.getId());
		return "redirect:/events";
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam("loginEmail") String email, @RequestParam("loginPassword") String password, RedirectAttributes redirectAttrs, Model model, HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		User user = this.uService.findByEmail(email);
		session.setAttribute("user__id", user.getId());
		return "redirect:/events";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// session
	public Long userSessionId(HttpSession session) {
		if(session.getAttribute("userId") == null)
			return null;
		return (Long)session.getAttribute("userId");
	}
	
	// format date
	private String now() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date());
	}
			
	// 	events
	@GetMapping("/events")
	public String events(@ModelAttribute("event") Event event, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("user__id");
		User user = this.uService.getOneUser(userId);
		if(userId == null) {
			return "redirect:/";
		}
		List<Event> userEvents = this.eService.allEventsWithState(user.getState());
		List<Event> otherEvents = this.eService.allEventsNotState(user.getState());
		model.addAttribute("userEvents", userEvents);
		model.addAttribute("otherEvents", otherEvents);
		model.addAttribute("user", user);
		return "events.jsp";
	}	
	
	@PostMapping("/events/new")
	public String events(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("user__id");
		User user = this.uService.getOneUser(userId);
		if(userId == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			List<Event> userEvents = this.eService.allEventsWithState(user.getState());
			List<Event> otherEvents = this.eService.allEventsNotState(user.getState());
			model.addAttribute("userEvents", userEvents);
			model.addAttribute("otherEvents", otherEvents);
			model.addAttribute("user", user);
			model.addAttribute("eventDate", now());
			return "events.jsp";
		}
		event.setHost(user);
		this.eService.createEvent(event);
		return "redirect:/events";
	}
	
	// join event
	@GetMapping("/events/join/{id}")
	public String joinEvents(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("user__id");
		Long eventId = id;
		User joinedUser = this.uService.getOneUser(userId);
		Event joinedEvent = this.eService.getOneEvent(eventId);
		this.eService.joinEvent(joinedUser, joinedEvent);
		return "redirect:/events";
	}
	
	// cancel event
	@GetMapping("/events/cancel/{id}")
	public String cancelEvents(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("user__id");
		Long eventId = id;
		User joinedUser = this.uService.getOneUser(userId);
		Event joinedEvent = this.eService.getOneEvent(eventId);
		this.eService.cancelEvent(joinedUser, joinedEvent);
		return "redirect:/events";
	}
	
	// delete
	@GetMapping("/events/delete/{id}")
	public String deleteEvents(@PathVariable("id") Long id) {
		this.eService.deleteEvent(id);
		return "redirect:/events";	
	}
	
	// update
	@GetMapping("/events/edit/{id}")
	public String events(@ModelAttribute("updateEvent") Event event, @PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("user__id");
		Event thisevent = this.eService.getOneEvent(id);
		if(userId == null) {
			return "redirect:/";
		}
		if(!thisevent.getHost().getId().equals(userId)) {
			return "redirect:/events";
		}
		User user = this.uService.getOneUser(userId);
		model.addAttribute("thisevent", thisevent);
		model.addAttribute("user",user);
		return "edit.jsp";
	}
	
	@PostMapping("/events/edit/{id}")
	public String events(@Valid @ModelAttribute("updateEvent") Event event, BindingResult result, @PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("user__id");
		User user = this.uService.getOneUser(userId);
		Event thisevent = this.eService.getOneEvent(userId);
		if(result.hasErrors()) {
			model.addAttribute("updateEvent", this.eService.getOneEvent(id));
			return "edit.jsp";
		}
		model.addAttribute("user", user);
		model.addAttribute("updateEvent", thisevent);
		event.setHost(user);
		this.eService.updateEvent(thisevent);
		return "redirect:/events";
	}
	
	// show event
		@GetMapping("/events/{id}")
		public String showEvent(@ModelAttribute("message") Message message, @PathVariable("id") Long id, HttpSession session, Model model) {
			Long userId = (Long) session.getAttribute("user__id");
			User user = this.uService.findById(userId);
			Event event = this.eService.getOneEvent(id);
			if(session.getAttribute("user__id") == null) {
				return "redirect:/";
			}
			if(event == null) {
				return "redirect:/events";
			}
			model.addAttribute("user", user);
			model.addAttribute("event", event);
			return "show.jsp";
		}
		
		@PostMapping("/events/{id}/messages")
		public String postMessage(@Valid @ModelAttribute("message") Message message, BindingResult result, @PathVariable("id") Long id, HttpSession session) {
			Long userId = (Long) session.getAttribute("user__id");
			User thisuser = this.uService.getOneUser(userId);
			Event event = this.eService.getOneEvent(id);
			if(result.hasErrors()) {
				return "redirect:/events/" + id;
			}
			message.setAuthor(thisuser);
			message.setCommentEvent(event);
			Message newMessage = this.mService.addMessage(message);
			return "redirect:/events/" + newMessage.getCommentEvent().getId();
		}
}
