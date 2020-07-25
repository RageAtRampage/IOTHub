package com.projectdata.IOTHub.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.projectdata.IOTHub.exception.InvalidException;

@ControllerAdvice
public class InvalidExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<Object> handleInvalidException(InvalidException e) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.createObjectNode();
		((ObjectNode) rootNode).put("Message", e.getMessage());
		return new ResponseEntity<Object>(rootNode, HttpStatus.BAD_REQUEST);
	}

}
