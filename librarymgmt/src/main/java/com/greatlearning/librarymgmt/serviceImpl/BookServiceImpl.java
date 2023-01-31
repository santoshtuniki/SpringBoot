package com.greatlearning.librarymgmt.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.librarymgmt.model.Book;
import com.greatlearning.librarymgmt.repository.BookRepository;
import com.greatlearning.librarymgmt.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public void saveOrUpdateBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void deleteBookById(int id) {
		bookRepository.deleteById(id);
	}

	@Override
	public Book getBookById(int id) {
		Optional<Book> result = bookRepository.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new RuntimeException("Book does not exists for the Id: " + id);
		}
	}

}
