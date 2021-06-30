package com.learning.jpaexample.JPARepoExample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learning.jpaexample.JPARepoExample.dao.BookRepository;
import com.learning.jpaexample.JPARepoExample.model.Book;

import ch.qos.logback.classic.Logger;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;
	
	private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

	
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList();
		try {
			books = bookRepo.findAll();

		} catch (Exception e) {
			logger.error("error retreiving books");
		}
		return books;
	}


	public Book getBookById(Integer id) {
		try
		{
			Optional<Book> book = bookRepo.findById(id);

		    if (book.isPresent()) 
		      return book.get();
		    
		    }
		catch (Exception e) {
			logger.error("error occured while getting book by id {}",id);
		}
		return null;
	}


	public boolean addBook(@Valid Book book) {
		Boolean bookAdd = false;
		try {
			bookRepo.save(book);
			bookAdd = true;
			return bookAdd;
		} catch (Exception e) {
			logger.error("error adding book ");
		}
		return bookAdd;
	}





	public List<Book> getBookByTitleLike(String title) {
		List<Book> list = new  ArrayList();
		try {
			list = bookRepo.findByTitleLike(title);
			return list;
		} catch (Exception e) {
			logger.error("error retreiving book by title {}",title);
			
		}
		return list;
	}

	
	public List<Book> getBookByAuthorLike(String author) {
		List<Book> list = new  ArrayList();
		try {
			list = bookRepo.findByAuthorLike(author);
			return list;
		} catch (Exception e) {
			logger.error("error retreiving book by author {}",author);
			
		}
		return list;
	}


	public List<Book> getBookByTitleOrAuthor(String title, String author) {
		List<Book> list = new  ArrayList();
		try {
			list = bookRepo.findByTitleOrAuthor(title, author);
			return list;
		} catch (Exception e) {
			logger.error("error retreiving book by author or title {}",author+" "+title);
			
		}
		return list;
	}


	public List<Book> getDistinctBookByAuthor(String author) {
		List<Book> list = new  ArrayList();
		try {
			list = bookRepo.findDistinctByAuthor(author);
			return list;
		} catch (Exception e) {
			logger.error("error retreiving book by author {}",author);
			
		}
		return list;
	}


	public List<Book> getBookByPublication(String publication) {
		List<Book> list = new  ArrayList();
		try {
			list = bookRepo.findByPublication(publication);
			return list;
		} catch (Exception e) {
			logger.error("error retreiving book by publication {}",publication);
			
		}
		return list;
	}


	public List<Book> getBookByPriceLessThan(Float price) {
		List<Book> list = new  ArrayList();
		try {
			list = bookRepo.findByPriceLessThan(price);
			return list;
		} catch (Exception e) {
			logger.error("error retreiving book by price {}",price);
			
		}
		return list;
	}
	
	public List<Book> getBookByPriceGreaterThan(Float price) {
		List<Book> list = new  ArrayList();
		try {
			list = bookRepo.findByPriceGreaterThan(price);
			return list;
		} catch (Exception e) {
			logger.error("error retreiving book by price {}",price);
			
		}
		return list;
	}
	
	public List<Book> getBookByIdGreaterThan(Integer id) {
		List<Book> list = new  ArrayList();
		try {
			list = bookRepo.findByIdGreaterThan(id);
			return list;
		} catch (Exception e) {
			logger.error("error retreiving book by price {}",id);
			
		}
		return list;
	}
	
	
	
	public List<Book> getBookInPriceBetween(Float p1, Float p2) {
		List<Book> list = new  ArrayList();
		try {
			list = bookRepo.findByPriceBetween(p1, p2);
			return list;
		} catch (Exception e) {
			logger.error("error retreiving book");
			
		}
		return list;
	}

}
