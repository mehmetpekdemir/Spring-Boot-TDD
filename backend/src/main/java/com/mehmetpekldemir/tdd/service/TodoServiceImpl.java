package com.mehmetpekldemir.tdd.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mehmetpekldemir.tdd.dto.request.TodoRequest;
import com.mehmetpekldemir.tdd.dto.response.TodoResponse;
import com.mehmetpekldemir.tdd.model.Todo;
import com.mehmetpekldemir.tdd.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor // Constructor injection with lombok
public class TodoServiceImpl implements TodoService {

	private final TodoRepository todoRepository;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<TodoResponse> getAllTodos() {
		return todoRepository.findAll().stream().map(TodoResponse::of).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public TodoResponse createTodo(TodoRequest todoRequest) {
		final Todo todo = todoRepository.save(new Todo(todoRequest.getText(), todoRequest.getCompleted()));
		return TodoResponse.of(todo);
	}

}
