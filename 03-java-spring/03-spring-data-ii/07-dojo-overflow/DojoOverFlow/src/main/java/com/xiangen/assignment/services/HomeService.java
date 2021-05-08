package com.xiangen.assignment.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiangen.assignment.models.Answer;
import com.xiangen.assignment.models.Question;
import com.xiangen.assignment.models.Tag;
import com.xiangen.assignment.repositories.AnswerRepository;
import com.xiangen.assignment.repositories.QuestionRepository;
import com.xiangen.assignment.repositories.TagRepository;

@Service
public class HomeService {
	@Autowired
	private QuestionRepository qRepo;
	@Autowired
	private AnswerRepository aRepo;
	@Autowired
	private TagRepository tRepo;
	
	// get all
	public List<Question> getAllQuestions(){
		return this.qRepo.findAll();
	}
	
	public List<Answer> getAllAnswers(){
		return this.aRepo.findAll();
	}
	
	public List<Tag> getAllTags(){
		return this.tRepo.findAll();
	}
	
	// get one
	public Question getOneQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
	
	public Answer getOneAnswer(Long id) {
		return this.aRepo.findById(id).orElse(null);
	}
	
	public Tag getOneTag(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}
	
	// create
	public Question addQuestion(Question question) {
		ArrayList<Tag> questionsTags = new ArrayList<Tag>();
		String tags = question.getsTags();

		String[] qTags = tags.split(",");

		for(String subject: qTags) {
			System.out.println(subject);
			Tag tag = this.tRepo.findBySubject(subject.toLowerCase().trim());
			if(tag == null) {
				tag = new Tag(subject);
				tag.setSubject(subject);
				this.tRepo.save(tag);
			}
			if(!questionsTags.contains(tag)) {
				questionsTags.add(tag);
			}
		}
		Question newQuestion = new Question(question.getQuestion(), questionsTags);
		return this.qRepo.save(newQuestion);
	}
	
	public Answer addAnswer(Answer answer) {
		return this.aRepo.save(answer);
	}
	
	public Tag addTag(Tag tag) {
		return this.tRepo.save(tag);
	}

}