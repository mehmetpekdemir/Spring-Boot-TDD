package com.mehmetpekldemir.tdd.dto.response;

import com.mehmetpekldemir.tdd.model.Todo;

import lombok.Builder;
import lombok.Getter;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Getter
@Builder
public class TodoResponse {

	private final String text;

	private final Boolean completed;

	private TodoResponse(String text, Boolean completed) {
		this.text = text;
		this.completed = completed;
	}

	public static TodoResponse of(Todo todo) {
		return TodoResponse.builder()//
				.text(todo.getText())//
				.completed(todo.getCompleted())//
				.build();//
	}

}
