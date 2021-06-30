package com.learning.jpaexample.JPARepoExample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="book_data")
@ApiModel(description="All Details about Book API")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@ApiModelProperty(notes="id is autoGenerated")
	private Integer id;
	
	@Size(min=2,max=25,message="title size should be between 2 to 25 chars")
	@NotBlank(message="title cannot be blank")
	@ApiModelProperty(notes="Title field should be min 2 chars and Max 25 chars")

	private String title;
	
	@Size(min=2,max=25,message="author size should be between 2 to 25 chars")
	@NotBlank(message="author cannot be blank")
	@ApiModelProperty(notes="Author field should be min 2 chars and Max 25 chars")

	private String author;
	
	@Column(name="publication")
	private String publication;
	
	@Column(name="publication_email")
	@Email
	@ApiModelProperty(notes="Email field should be in proper format")

	private String publicationEmail;
	
	@NotNull(message="price cannot be null")
	@ApiModelProperty(notes="While adding book price field cannot be null")

	private Float price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getPublicationEmail() {
		return publicationEmail;
	}

	public void setPublicationEmail(String publicationEmail) {
		this.publicationEmail = publicationEmail;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	

}
