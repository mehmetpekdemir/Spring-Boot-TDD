package com.mehmetpekldemir.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mehmetpekldemir.tdd.dto.request.TodoRequest;
import com.mehmetpekldemir.tdd.dto.response.TodoResponse;
import com.mehmetpekldemir.tdd.model.Todo;
import com.mehmetpekldemir.tdd.repository.TodoRepository;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@SpringBootTest
class TodoServiceTest {

	@Autowired
	private TodoRepository todoRepository;

	@Autowired
	private TodoService todoService;

	@AfterEach
	void tearDown() {
		todoRepository.deleteAll();
	}

	@Test
	void test_get_all_todos() {
		Todo todo = new Todo("Do something 1", true);
		todoRepository.save(todo);

		List<TodoResponse> todoList = todoService.getAllTodos();
		TodoResponse lastTodo = todoList.get(todoList.size() - 1);

		assertEquals(todo.getText(), lastTodo.getText());
		assertEquals(todo.getCompleted(), lastTodo.getCompleted());

	}

	@Test
	void test_create_todo() {
		TodoRequest todoRequest = new TodoRequest("Do Something 1", false);

		todoService.createTodo(todoRequest);

		assertEquals(1.0, todoRepository.count());
	}

}
