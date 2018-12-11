package com.qa.thain.alex.springboot.database.app.application.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "person")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "creationDate", "lastModified" }, allowGetters = true)
public class MySpringBootDatabaseModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String address;
	
	private Integer age;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date creationDate;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date lastModified;
	
	public Long getId() {
		return this.id;
	}	
	public void setId(Long id)	{
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public String getAddress() {
		return this.address;
	}		
	public void setAddress(String address) {	
		this.address = address;
	}	
	public Integer getAge() {
		return this.age;
	}	
	public void setAge(Integer age)	{
		this.age = age;
	}	
	public Date getCreationDate() {
		return this.creationDate;
	}	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}	
	public Date getLastModified() {	
		return this.lastModified;
	}
	public void setLastModified(Date lastModified) {	
		this.lastModified = lastModified;
	}
}
