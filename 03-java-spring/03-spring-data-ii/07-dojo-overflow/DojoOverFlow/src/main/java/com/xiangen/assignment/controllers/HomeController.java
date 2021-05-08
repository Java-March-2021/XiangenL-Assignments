package com.xiangen.assignment.controllers;


import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.xiangen.assignment.models.Answer;
import com.xiangen.assignment.models.Question;
import com.xiangen.assignment.models.Tag;
import com.xiangen.assignment.services.HomeService;

@Controller
public class HomeController {
	@Autowired
	private HomeService hService;
	
	// index
	@GetMapping("/questions")
	public String index(Model model) {
		model.addAttribute("questions", this.hService.getAllQuestions());
		return "index.jsp";
	}
	
	// new
	@GetMapping("/questions/new")
	public String addQuestion(@ModelAttribute("quest") Question question) {
		return "new.jsp";
	}
	
	@PostMapping("/questions/new")
	public String addQuestion(@Valid @ModelAttribute("quest") Question question, BindingResult result, Model model){
		if(result.hasErrors()) {
			return "new.jsp";
		}
//		System.out.println(question.getsTags());
//		String[] tags = question.getsTags().split(",");
//		ArrayList<Tag> questionTags = new ArrayList<Tag>();
//		for(String subject: tags) {
//			Tag newTag = new Tag();
//			newTag.setSubject(subject);
//			this.hService.addTag(newTag);
//			questionTags.add(newTag);
//			
//		}
//		question.setTags(questionTags);
//		model.addAttribute("question", this.hService.addQuestion(question));
		this.hService.addQuestion(question);
		return "redirect:/questions";
	}
	
	// show
	@GetMapping("/questions/{id}")
	public String showQuestioin(@PathVariable("id") Long id, @ModelAttribute("answer") Answer answer, Model model) {
		Long questionId = id;
		model.addAttribute("question", this.hService.getOneQuestion(questionId));
		model.addAttribute("answers", this.hService.getAllAnswers());
		return "show.jsp";
	}
	
	@PostMapping("/answers")
	public String addAnswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "show.jsp";
		}
		Answer newAnswer = this.hService.addAnswer(answer);
		return "redirect:/questions/" + newAnswer.getQuestion().getId();
	}
	

	
}
