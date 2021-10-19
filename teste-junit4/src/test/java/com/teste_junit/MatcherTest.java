package com.teste_junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.hamcrest.beans.HasProperty;
import org.hamcrest.object.HasToString;
import org.junit.Test;

	/* 
	* Foi usado o @@Deprecated no código 
	* porque os métodos utilizamtermos depreciados.
	*/

@Deprecated
public class MatcherTest {

	@Test
	public void givenBean_checkToString() {
		Person person = new Person("Barrack", "Obama");
		String str = person.toString();
		assertThat(person, HasToString.hasToString(str)); // assertThat está depreciado
	}

	@Test
	public void givenBean_checkPropertyExists() {
		Person person = new Person("Barrack", "Obama");
		assertThat(person, HasProperty.hasProperty("name")); // assertThat está depreciado
	}

	@Test
	public void givenCollection_checkEmpty() {
		List<String> emptyList = new ArrayList<String>();
		assertThat(emptyList, Matchers.empty()); // assertThat está depreciado
	}

	@Test
	public void givenAnInteger_checkGreater() {
		assertThat(1, Matchers.greaterThan(0)); // assertThat está depreciado
	}

	@Test
	public void givenString_checkNull() {
		String str = null;
		assertThat(str, Matchers.isEmptyOrNullString()); // assertThat está depreciado
	}
}
