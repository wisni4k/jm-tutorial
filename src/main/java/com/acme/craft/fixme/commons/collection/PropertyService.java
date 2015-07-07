package com.acme.craft.fixme.commons.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.google.common.collect.Lists;

public class PropertyService {

	
	//inicjalizacja inline
	public List<String> defaultProperties() {
		List<String> properties = Arrays.asList("a","b");
		properties = Lists.newArrayList("e","c");
		return properties;
	}

	//fix null check
	public boolean valid(List<String> properties) {
		if (CollectionUtils.isEmpty(properties)) {
			boolean isValid = true;
			for (String property : properties) {
				isValid = isValid && valid(property);
			}
		}
		return false;
	}

	private boolean valid(String property) {
		return property != null && !property.isEmpty();
	}
}
