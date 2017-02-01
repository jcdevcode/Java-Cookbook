package com.blue.code.app.model.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO Class for ToDo Objects.
 * @author devcode
 *
 */
public class TodoDto implements Serializable{	
	private static final long serialVersionUID = 3766883765867462155L;
	private Long id;
	private String title;
	private String description;
	private Date created;
	private Date expireDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	
	
	

}
