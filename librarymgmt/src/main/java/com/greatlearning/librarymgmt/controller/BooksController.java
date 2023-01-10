package com.greatlearning.librarymgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.librarymgmt.model.Book;
import com.greatlearning.librarymgmt.service.BookService;

@Controller
@RequestMapping("/books")
public class BooksController {

	@Autowired
	BookService bookService;

	@GetMapping("/list")
	public String getBooks(Model model) {
		List<Book> books = bookService.getAllBooks();
		model.addAttribute("books", books);
		return "books/list-books";
	}

	@GetMapping("/showFormForAdd")
	public String showAddForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "books/book-form";
	}

	@PostMapping("/showFormForUpdate")
	public String showUpdateForm(Model model, @RequestParam("bookId") int bookId) {
		Book book = bookService.getBookById(bookId);
		model.addAttribute("book", book);
		return "books/book-form";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("bookId") int bookId) {
		bookService.deleteBookById(bookId);
		return "redirect:/books/list";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("book") Book book) {
		bookService.saveOrUpdateBook(book);
		return "redirect:/books/list";
	}
}
