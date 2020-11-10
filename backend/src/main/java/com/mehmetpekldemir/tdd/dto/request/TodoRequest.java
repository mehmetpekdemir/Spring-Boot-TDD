package com.mehmetpekldemir.tdd.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author MEHMET PEKDEMIR
 * @since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoRequest {

	private String text;

	private Boolean completed;

}
