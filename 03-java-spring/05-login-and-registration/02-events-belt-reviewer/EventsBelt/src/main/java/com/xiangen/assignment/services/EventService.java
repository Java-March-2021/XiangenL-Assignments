package com.xiangen.assignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiangen.assignment.models.Event;
import com.xiangen.assignment.models.User;
import com.xiangen.assignment.repositories.EventRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository eRepo;
	
	// get all
	public List<Event> getALLEvents(){
		return this.eRepo.findAll();
	}
	
	// get one
	public Event getOneEvent(Long id) {
		return this.eRepo.findById(id).orElse(null);
	}
	
	// create
	public Event createEvent(Event event) {
		return this.eRepo.save(event);
	}
	
	// update
	public Event updateEvent(Event updatedEvent) {
		return this.eRepo.save(updatedEvent);
	}
	
	// delete
	public void deleteEvent(Long id) {
		this.eRepo.deleteById(id);
	}
	
	// user state
	public List<Event> allEventsWithState(String state) {
		return this.eRepo.findByState(state);
	}
	
	// other state
	public List<Event> allEventsNotState(String state) {
		return this.eRepo.findByStateIsNot(state);
	}
	
	// join
	public void joinEvent(User user, Event event) {
		List<User> joinedUsers = event.getJoinedUsers();
		joinedUsers.add(user);
		this.eRepo.save(event);
	}
	
	// cancel
	public void cancelEvent(User user, Event event) {
		List<User> joinedUsers = event.getJoinedUsers();
		joinedUsers.remove(user);
		this.eRepo.save(event);
	}
}
