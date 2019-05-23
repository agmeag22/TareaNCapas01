package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.BookDAO;
import com.uca.capas.domain.Book;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller //manda a llamar a los metodos
public class MainController {
	
	static Logger log = Logger.getLogger(MainController.class.getName());
	
	@Autowired
	private BookDAO bookDAO;

	@RequestMapping("/")
	public ModelAndView initMain() {
		log.info("Entrando a funcion init-min" + log.getName());
		ModelAndView mav = new ModelAndView();
		List<Book> books = null;
		try {
			books = bookDAO.findAll(); //llamando metodo
			log.info("Termino de buscar en la base de datos");
		}catch(Exception e){
			log.log(Level.SEVERE, "Exception Ocurr", e);
		}
		mav.addObject("books",books);
		mav.setViewName("main");
		return mav;
	}
	

	//Buscar estudiante por codigo
	@RequestMapping(value = "/formSearch", method = RequestMethod.POST)
	public ModelAndView formSearch(@RequestParam String booktext, @RequestParam String selectorx) {
		ModelAndView mav = new ModelAndView();
		List<Book> rbook = null;
		String message="";
		int counting=0;
		try {
			rbook = bookDAO.findOne(booktext,selectorx);
			counting=bookDAO.countfilter(booktext,selectorx);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(rbook == null) {
			/*mav.addObject("message","El libro no existe en la base");*/
		}else {
			if(selectorx.equals("0")) {
				message="No se ingreso ningun filtro, se mostraron todos los registros";
			}
			if(selectorx.equals("1")) {
				message="Se encontraron "+counting+" resultados para "+booktext+" en Autor";}
			if(selectorx.equals("2")) {
				message="Se encontraron "+counting+" resultados para "+booktext+" en ISBN";
			}
			mav.addObject("message",message);
			mav.addObject("books",rbook);
		
		}
		mav.setViewName("searchresult");

		return mav;
	}
	@RequestMapping(value = "/formcount", method = RequestMethod.POST)
	public ModelAndView formCount(@RequestParam String booktext, @RequestParam String selectorx) {
		ModelAndView mav = new ModelAndView();
		List<Book> books = null;
		int bookscount=0;
		int authorscount=0;
		try {
			books = bookDAO.findAll(); //llamando metodo
			bookscount=bookDAO.countAllBooks();
			authorscount=bookDAO.countAllAuthors();
			log.info("Termino de buscar en la base de datos");
		}catch(Exception e){
			log.log(Level.SEVERE, "Exception Ocurr", e);
		}
		String message="Hay "+ bookscount+" libros en existencia, de "+authorscount+" autores diferentes";
		mav.addObject("message",message);
		mav.addObject("books",books);
		mav.setViewName("main");
		return mav;
	}
	
	
	
}