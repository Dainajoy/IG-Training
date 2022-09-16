package com.springboot.librarymanagementsystem.batch;


import com.springboot.librarymanagementsystem.model.Books_Info;
import com.springboot.librarymanagementsystem.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BookItemProcessor implements ItemProcessor<Books_Info,Books_Info> {
    public static final Logger log =  LoggerFactory.getLogger(BookItemProcessor.class);

    private User user;

    @SuppressWarnings("static-access")
    @Override
    public Books_Info process(Books_Info books) throws Exception {
        log.info("Book Process start");
        books.setModifiedOn(new Date());
        books.setCreatedOn(new Date());
        books.setActiveFlag(1);
        log.info("--------------------"+books);
        log.info("Book Process stop");
        return books;
    }
}
