package com.acme.craft.fixme.nullscheck;

import java.util.Optional;

public class PropertyService {

	private PropertyRepository repository = new PropertyRepository();

	private void update(String propertyId, String value) {
		Optional<Property> property = repository.get(propertyId);
		if (property.isPresent()) {
			property.get().setValue(value);
			repository.save(property);
		} else {
            throw new RuntimeException("Property not found:" + propertyId);
        }
	}
}
