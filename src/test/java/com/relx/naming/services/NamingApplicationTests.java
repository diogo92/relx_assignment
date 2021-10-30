package com.relx.naming.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

/**
 * Unit testing class
 */
@SpringBootTest
class NamingServiceTests {

	private static final String JOHN_DOE_STRING = "First name: John, Last name: Doe";
	private static final String HANS_CHRISTIAN_STRING = "First name: Hans-Christian, Last name: Jensen";
	private static final String HC_STRING = "First name: H-C, Last name: Jensen";
	private static final String P_H_KRISTENSEN_STRING = "First name: P. H., Last name: Kristensen";
	private static final String PETER_HANS_STRING = "First name: Peter Hans, Last name: Kristensen";
	private static final String PETER_H_STRING = "First name: Peter H., Last name: Kristensen";

	@Autowired
	private NamingService service;

	@Test
	void parseSingleName() {

		//Test exception for single white space character as input
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> service.parseName(" "));

		String name = "John Doe";
		String result = service.parseName(name);
		assertNotNull(result);
		assertEquals(JOHN_DOE_STRING,result);

		name = "Doe, John";
		result = service.parseName(name);
		assertNotNull(result);
		assertEquals(JOHN_DOE_STRING,result);

		name = "Hans-Christian Jensen";
		result = service.parseName(name);
		assertNotNull(result);
		assertEquals(HANS_CHRISTIAN_STRING,result);

		name = "H-C Jensen";
		result = service.parseName(name);
		assertNotNull(result);
		assertEquals(HC_STRING,result);

		name = "P. H. Kristensen";
		result = service.parseName(name);
		assertNotNull(result);
		assertEquals(P_H_KRISTENSEN_STRING,result);

		name = "Kristensen, P. H.";
		result = service.parseName(name);
		assertNotNull(result);
		assertEquals(P_H_KRISTENSEN_STRING,result);

		name = "Peter Hans Kristensen";
		result = service.parseName(name);
		assertNotNull(result);
		assertEquals(PETER_HANS_STRING,result);

		name = "Peter H. Kristensen";
		result = service.parseName(name);
		assertNotNull(result);
		assertEquals(PETER_H_STRING,result);
	}

	@Test
	void parseJoinedNames() {
		//Test exception for single white space character as input
		assertThrows(ArrayIndexOutOfBoundsException.class, () ->  service.parseJoinedNames(" "));

		//Text exception for when one of the comma separated names is a single white space character
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> service.parseJoinedNames("John, "));

		String joinedNames = "H-C Jensen, Peter Hans Kristensen, John Doe";
		ArrayList<String> result = service.parseJoinedNames(joinedNames);
		assertNotNull(result);
		assertTrue(result.size()>0);
		assertEquals(HC_STRING,result.get(0));
		assertEquals(PETER_HANS_STRING,result.get(1));
		assertEquals(JOHN_DOE_STRING,result.get(2));
	}
}
