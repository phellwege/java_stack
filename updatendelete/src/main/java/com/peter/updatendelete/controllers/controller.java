package com.peter.updatendelete.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.peter.updatendelete.models.Book;
import com.peter.updatendelete.services.BookService;

@Controller
public class controller {
	private final BookService bookService;
	public controller(BookService bookService) {
        this.bookService = bookService;
    }
		@RequestMapping("books")
		public String home(Model model) {
			List<Book> books = bookService.allBooks(); 
			model.addAttribute("books", books);
			return "index.jsp";
		}
		@RequestMapping("/api/books/{id}")
		public String delete(@PathVariable("id") Long id) {
			bookService.deleteBook(id); 
			return "redirect:/books";
		}
		@RequestMapping("/books/new")
		public String newbook(@ModelAttribute("book") Book book) {
			return "newbook.jsp";
		}
		@RequestMapping(value="/books", method=RequestMethod.POST)
		public String createBook(@Valid @ModelAttribute("book") Book b, BindingResult result) {
			if (result.hasErrors()) {
				return "/book/new";
			}
			else {
				bookService.createBook(b);
			return "redirect:/books";
			}
			
		}
		@RequestMapping("/books/{id}")
		public String showinfo(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
			return "showinfo.jsp";
		}
		@RequestMapping("/books/{id}/edit")
		public String edit(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
			model.addAttribute("book", book);
			return "edit.jsp";
		}
		@RequestMapping(value="/book/{id}", method=RequestMethod.PUT)
		public String editBook(@Valid @ModelAttribute("book") Book b, BindingResult result) {
			if (result.hasErrors()) {
				return "edit.jsp";
			}
			else {
				bookService.updateBook(b.getId(), b.getTitle(), b.getDescription(), b.getLanguage(), b.getNumberOfPages());
			return "redirect:/books";
			}
		}
	}

