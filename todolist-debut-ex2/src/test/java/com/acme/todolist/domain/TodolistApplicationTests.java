package com.acme.todolist.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

class TodolistApplicationTests {

	@Test
	void isLate_itemCreationDate24Hours_afterCurrentTime_returnsFalse() {
		TodoItem item = new TodoItem("1", Instant.now().minus(20, ChronoUnit.HOURS), "mycontent");
		assertFalse(item.isLate());
	}

	@Test
	void isLate_itemCreationDate24Hours_beforeCurrentTime_returnsFalse() {
		TodoItem item = new TodoItem("1", Instant.now().plus(20, ChronoUnit.HOURS), "mycontent");
		assertFalse(item.isLate());
	}

}
