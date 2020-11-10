package com.mehmetpekldemir.tdd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mehmetpekldemir.tdd.dto.request.TodoRequest;
import com.mehmetpekldemir.tdd.dto.response.TodoResponse;
import com.mehmetpekldemir.tdd.model.Todo;
import com.mehmetpekldemir.tdd.service.TodoService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest
class TodoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TodoService todoService;

	@Test
	void test_get_all_todos() throws Exception {
		List<TodoResponse> todoList = new ArrayList<>();
		todoList.add(TodoResponse.of(new Todo("Do something 1", true)));
		todoList.add(TodoResponse.of(new Todo("Do something 2", true)));

		when(todoService.getAllTodos()).thenReturn(todoList);

		mockMvc.perform(MockMvcRequestBuilders//
				.get("/api/v1/todo")//
				.contentType(MediaType.APPLICATION_JSON))//
				.andExpect(jsonPath("$", hasSize(2)))//
				.andDo(print());//
	}

	@Test
	void test_create_todo() throws Exception {
		TodoResponse todoResponse = TodoResponse.builder().text("Do Something").completed(true).build();
		when(todoService.createTodo((TodoRequest) any(TodoRequest.class))).thenReturn(todoResponse);

		ObjectMapper objectMapper = new ObjectMapper();
		Todo todo = new Todo("Do Something", true);
		String todoJson = objectMapper.writeValueAsString(todo);

		ResultActions result = mockMvc
				.perform(post("/api/v1/todo").contentType(MediaType.APPLICATION_JSON).content(todoJson));

		result.andExpect(status().isOk()).andExpect(jsonPath("$.text").value("Do Something"))
				.andExpect(jsonPath("$.completed").value(true));
	}

}
