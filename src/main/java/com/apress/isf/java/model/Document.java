/**
 * 
 */
package com.apress.isf.java.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * @author dirkseActive
 * @since 9/28/2017
 *
 */

@org.springframework.data.mongodb.core.mapping.Document(collection="docs")
public class Document {
	@Id
	private String documentId;
	private String name;
	@DBRef
	private Type type;
	private String location;
	private String description;
	private Date created;
	private Date modified;
	
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Document [documentId=");
		builder.append(documentId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", type=");
		builder.append(type);
		builder.append(", location=");
		builder.append(location);
		builder.append(", description=");
		builder.append(description);
		builder.append(", created=");
		builder.append(created);
		builder.append(", modified=");
		builder.append(modified);
		builder.append("]");
		return builder.toString();
	}
}
