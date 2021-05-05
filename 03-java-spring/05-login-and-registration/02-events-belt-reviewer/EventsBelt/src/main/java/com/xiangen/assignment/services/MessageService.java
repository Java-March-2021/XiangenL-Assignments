package com.xiangen.assignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiangen.assignment.models.Message;
import com.xiangen.assignment.repositories.MessageRepository;

@Service
public class MessageService {
	@Autowired
	private MessageRepository mRepo;
	
	// all
	public List<Message> getAllMessages(){
		return this.mRepo.findAll();
	}
	
	// create
	public Message addMessage(Message message) {
		return this.mRepo.save(message);
	}
}
