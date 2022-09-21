package com.springboot.librarymanagementsystem.service;

import com.springboot.librarymanagementsystem.model.Books_Info;
import org.springframework.stereotype.Service;

import java.util.List;



    @Service
    public interface BooksInfoService {


        public Books_Info saveBook(Long libId, Books_Info book) ;

        public List<Books_Info> getAllBook();

        public Books_Info getBookById(Long id);

        public List<Books_Info> findBookByBook_Name(String name);

        public List<Books_Info> getsBookByAuthorName(String author);
        public List<Books_Info> getsBookByPublication(String name);


        public Books_Info saveBookInfo(Books_Info book) ;
        public Books_Info deleteBook(String name, Long id);

        public Books_Info updateBook(Books_Info book);
        public Books_Info deleteBookById( Long bookId) ;

    }
