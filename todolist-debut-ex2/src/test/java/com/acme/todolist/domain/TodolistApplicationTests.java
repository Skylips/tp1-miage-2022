package com.acme.todolist.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

class TodolistApplicationTests {

	@Test
	void isLate_itemCreationDate24Hours_beforeCurrentTime_returnsFalse() {
		TodoItem item = new TodoItem("1", Instant.now().minus(24, ChronoUnit.HOURS), "mycontent");

		item.setContent(item.finalContent());
		System.out.println(item.isLate());
		System.out.println(item.getContent());

		assertTrue(item.getContent().contains("LATE"));
	}

	@Test
	void isLate_itemCreationDate24Hours_afterCurrentTime_returnsFalse() {
		TodoItem item = new TodoItem("1", Instant.now().plus(24, ChronoUnit.HOURS), "mycontent");
		item.finalContent();
		assertFalse(item.isLate());
	}

}
