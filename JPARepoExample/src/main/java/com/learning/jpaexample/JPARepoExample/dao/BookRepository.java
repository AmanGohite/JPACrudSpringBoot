package com.learning.jpaexample.JPARepoExample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.jpaexample.JPARepoExample.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>  {

	List<Book> findByTitleLike(String title);

	List<Book> findByAuthorLike(String author);
	
	List<Book> findDistinctByAuthor(String author);
	
	List<Book> findByTitleOrAuthor(String title, String author);
	
	List<Book> findByPublication(String publication);
	
	List<Book> findByPriceGreaterThan(Float price);
	
	List<Book> findByPriceLessThan(Float Price);
	
	List<Book> findByIdGreaterThan(Integer id);
	
	
	List<Book> findByPriceBetween(Float price1, Float price2);

	


}
