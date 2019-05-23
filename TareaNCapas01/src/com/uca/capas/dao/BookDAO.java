package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Book;

public interface BookDAO {

	public List<Book> findAll() throws DataAccessException;
	public List<Book> findfilter(String  name,String selector) throws DataAccessException;
	public int countfilter(String booktext, String selector) throws DataAccessException;
	public int countAllBooks()throws DataAccessException;
	public int countAllAuthors()throws DataAccessException;
	
	
}