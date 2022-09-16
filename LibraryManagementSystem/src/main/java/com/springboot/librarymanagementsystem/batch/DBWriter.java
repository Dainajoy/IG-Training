package com.springboot.librarymanagementsystem.batch;



import com.springboot.librarymanagementsystem.model.Books_Info;
import com.springboot.librarymanagementsystem.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DBWriter implements ItemWriter<Books_Info> {
    @Autowired
    private BookRepository bookRepository;

    private static final Logger log = LoggerFactory.getLogger(DBWriter.class);
    @Override
    public void write(List<? extends Books_Info> books) throws Exception {
        log.info("Data saved for :"+books);
        bookRepository.saveAll(books);
    }
}
