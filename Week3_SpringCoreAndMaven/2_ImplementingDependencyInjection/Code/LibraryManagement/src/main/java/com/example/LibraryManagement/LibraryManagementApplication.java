package com.example.LibraryManagement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.repository.BookRepository;
import com.library.service.BookService;


public class LibraryManagementApplication
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        BookService bookService = (BookService) context.getBean("bookService");
        BookRepository bookRepo = (BookRepository) context.getBean("bookRepository");
        
        bookService.setBookRepository(bookRepo);
        bookService.printService();
        
        ((ConfigurableApplicationContext) context).close();
    }
}
