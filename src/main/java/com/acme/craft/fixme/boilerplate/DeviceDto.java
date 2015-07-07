package com.acme.craft.fixme.boilerplate;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DeviceDto implements Serializable {
	private static final long serialVersionUID = -8984798902681813138L;

	private String id;
	private String externalId;
	private String type;
	private UUID uuid;
	private String thingId;
	private String name;
	private String description;
	private String status;
	private String registrationKey;
	private String ownerId;
	private Map<String, String> properties;

	
	public DeviceDto(String id, String externalId, String type, UUID uuid, String thingId, String name,
			String description, String status, String registrationKey, String ownerId, Map<String, String> properties) {
		this.id = id;
		this.externalId = externalId;
		this.type = type;
		this.uuid = uuid;
		this.thingId = thingId;
		this.name = name;
		this.description = description;
		this.status = status;
		this.registrationKey = registrationKey;
		this.ownerId = ownerId;
		this.properties = properties;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		DeviceDto deviceDto = (DeviceDto) o;

		if (id != null ? !id.equals(deviceDto.id) : deviceDto.id != null)
			return false;
		if (externalId != null ? !externalId.equals(deviceDto.externalId) : deviceDto.externalId != null)
			return false;
		if (type != null ? !type.equals(deviceDto.type) : deviceDto.type != null)
			return false;
		if (uuid != null ? !uuid.equals(deviceDto.uuid) : deviceDto.uuid != null)
			return false;
		if (thingId != null ? !thingId.equals(deviceDto.thingId) : deviceDto.thingId != null)
			return false;
		if (name != null ? !name.equals(deviceDto.name) : deviceDto.name != null)
			return false;
		if (description != null ? !description.equals(deviceDto.description) : deviceDto.description != null)
			return false;
		if (status != null ? !status.equals(deviceDto.status) : deviceDto.status != null)
			return false;
		if (registrationKey != null ? !registrationKey.equals(deviceDto.registrationKey)
				: deviceDto.registrationKey != null)
			return false;
		if (ownerId != null ? !ownerId.equals(deviceDto.ownerId) : deviceDto.ownerId != null)
			return false;
		return !(properties != null ? !properties.equals(deviceDto.properties) : deviceDto.properties != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (externalId != null ? externalId.hashCode() : 0);
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
		result = 31 * result + (thingId != null ? thingId.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (status != null ? status.hashCode() : 0);
		result = 31 * result + (registrationKey != null ? registrationKey.hashCode() : 0);
		result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
		result = 31 * result + (properties != null ? properties.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "DeviceDto{" + "id='" + id + '\'' + ", externalId='" + externalId + '\'' + ", type='" + type + '\''
				+ ", uuid=" + uuid + ", thingId='" + thingId + '\'' + ", name='" + name + '\'' + ", description='"
				+ description + '\'' + ", status='" + status + '\'' + ", registrationKey='" + registrationKey + '\''
				+ ", ownerId='" + ownerId + '\'' + ", properties=" + properties + '}';
	}
}
