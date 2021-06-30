package com.learning.jpaexample.JPARepoExample.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.learning.jpaexample.JPARepoExample.exception.BookNotFoundException;
import com.learning.jpaexample.JPARepoExample.model.Book;
import com.learning.jpaexample.JPARepoExample.service.BookService;

@RestController
@RequestMapping(value="/book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	
	@GetMapping(value="/")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") Integer id) {
	Book book = bookService.getBookById(id);
		if(book == null) {
			throw new BookNotFoundException("id-" + id);
		}
	return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	@PostMapping(value="/")
	public ResponseEntity<Void> addBook(@RequestBody @Valid Book book, UriComponentsBuilder builder){
		Boolean flag = bookService.addBook(book);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/{id}").buildAndExpand(book.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	
	@GetMapping(value="/title/{title}")
	public List<Book> getBookByTitleLike(@PathVariable String title){
		return bookService.getBookByTitleLike(title);
	}
	
	@GetMapping(value="/author/{author}")
	public List<Book> getBookByAuthorLike(@PathVariable String author){
		return bookService.getBookByAuthorLike(author);
	}
	
	@GetMapping(value="/{title}/{author}")
	public List<Book> getBookByTitleOrAuthor(@PathVariable String title,@PathVariable String author){
		return bookService.getBookByTitleOrAuthor(title,author);
	}
	
	@GetMapping(value="/distinct/author/{author}")
	public List<Book> getDistinctBookByAuthor(@PathVariable String author){
		return bookService.getDistinctBookByAuthor(author);
	}
	
	@GetMapping(value="/publication/{publication}")
	public List<Book> getBookByPublication(@PathVariable String publication){
		return bookService.getBookByPublication(publication);
	}
	
	@GetMapping(value="/price/less/{price}")
	public List<Book> getBookByPriceLessThan(@PathVariable Float price){
		return bookService.getBookByPriceLessThan(price);
	}
	
	@GetMapping(value="/price/greater/{price}")
	public List<Book> getBookByPriceGreaterThan(@PathVariable Float price){
		return bookService.getBookByPriceGreaterThan(price);
	}
	
	@GetMapping(value="/id/{id}")
	public List<Book> getBookByIdGreaterThan(@PathVariable Integer id){
		return bookService.getBookByIdGreaterThan(id);
	}
	
	@GetMapping(value="/price/{price1}/{price2}")
	public List<Book> getBookByPriceBetween(@PathVariable Float price1,@PathVariable Float price2){
		return bookService.getBookInPriceBetween(price1,price2);
	}
}