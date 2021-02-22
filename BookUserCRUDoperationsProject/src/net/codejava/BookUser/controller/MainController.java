package net.codejava.BookUser.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.BookUser.dao.BookDAO;
import net.codejava.BookUser.model.Book;

@Controller
public class MainController {
	
	@Autowired
	private BookDAO bookDAO;
	
	@RequestMapping(value="/")
    public ModelAndView listBook(ModelAndView model) {
		List<Book> listBook= bookDAO.list();
		model.addObject("listBook",listBook);
		model.setViewName("index");
    	 return model;
    }
	
	@RequestMapping(value="/newBook", method=RequestMethod.GET)
    public ModelAndView newBook(ModelAndView model) {
		Book newBook=new Book();
		
		model.addObject("book",newBook);
		model.setViewName("book_page");
    	 return model;
    }
	
	@RequestMapping(value="/showBooks", method=RequestMethod.GET)
	 public ModelAndView showBook(ModelAndView model) {
		
		List<Book> listBook= bookDAO.list();
		model.addObject("listBook",listBook);
		model.setViewName("index");
    	 return model;
  }
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	 public ModelAndView saveBook(@ModelAttribute Book book) {
		if(book.getBookId()==null) {
		bookDAO.save(book);
		}else {
			bookDAO.update(book);
		}
		return new ModelAndView("redirect:/");
    }
	
	
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	 public ModelAndView editBook(HttpServletRequest request) {
		Integer id= Integer.parseInt(request.getParameter("id"));
		Book book= bookDAO.get(id);
		
		ModelAndView model=new ModelAndView("book_page");
		model.addObject("book",book);
		
		return model;
    }
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	 public ModelAndView deleteBook(@RequestParam Integer id) {
		bookDAO.delete(id);
		
		return new ModelAndView("redirect:/");
	}
}