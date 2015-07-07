package com.acme.craft.fixme.commons.string;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NameValidator {

	public boolean valid(String name) {
		if (StringUtils.isNotBlank(name)) {
			return true;
		}
		return false;
	}

	public boolean isJohn(String name) {
		String johnName = "John";
		return johnName.equals(name);
	}

	public String validationMessage(String firstName, String lastName, String nick) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Provided name is not valid. First name: " + firstName + ", lastName: " + lastName + " nick:" + nick);
		log.info();
		return String.format("Provided name is not valid. First name:  %s  lastName:  %s  nick: %s", firstName,lastName,nick);
		//return "Provided name is not valid. First name: " + firstName + ", lastName: " + lastName + " nick:" + nick;
	}

}
