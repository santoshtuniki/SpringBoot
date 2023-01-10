package com.greatlearning.librarymgmt.service;

import java.util.List;

import com.greatlearning.librarymgmt.model.Book;

public interface BookService {

	public List<Book> getAllBooks();
	public void saveOrUpdateBook(Book book);
	public void deleteBookById(int id);
	public Book getBookById(int id);
}
