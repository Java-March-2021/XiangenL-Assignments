package com.xiangen.assignment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.xiangen.assignment.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{
	List<Message> findAll();
}
