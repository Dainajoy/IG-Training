package com.springboot.librarymanagementsystem.controller;

import com.springboot.librarymanagementsystem.exception.ResourceNotFoundException;
import com.springboot.librarymanagementsystem.model.BookIssuedTransaction_Info;
import com.springboot.librarymanagementsystem.service.BookIssuedTransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookIssuedTransactionController {
    private static final Logger log = LoggerFactory.getLogger(BookIssuedTransactionController.class);

    @Autowired
    private BookIssuedTransactionService bookissuedservice;

    @PostMapping("/Transaction/{bookId}/{userId}/{libId}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String saveTransaction(@RequestBody BookIssuedTransaction_Info transaction,
                                  @PathVariable("userId")Long userId, @PathVariable("bookId")Long bookId, @PathVariable("userId")Long libId)  {
        log.info("Book issued controller called for save transaction.");
        bookissuedservice.saveTransaction(transaction,userId,bookId,libId);
        return "Transaction Occur Successfully";
    }

    @GetMapping("/getAllTransaction")
    public List<BookIssuedTransaction_Info> findAllTransaction() {
        log.info("Book issued controller called for fetching all transaction.");
        return bookissuedservice.findAllBookIssue();
    }

    @GetMapping("/getTransactionByTransactionId/{id}")
    public Optional<BookIssuedTransaction_Info> getTransactionByTransactionId(@PathVariable Long id) {
        log.info("Book issued controller called for fetching tranaction by transaction id.");
        Optional<BookIssuedTransaction_Info>bookIssue=bookissuedservice.findTransactionByTransactionId(id);
        if(bookIssue.isPresent()){
            return bookIssue;
        }else{
            throw new ResourceNotFoundException("BookIssue not found with given Id: "+id);
        }

    }

    @GetMapping("/getTransactionByStatus/{name}")
    public List<BookIssuedTransaction_Info> getTransactionByStatus(@PathVariable String name) {
        log.info("Book issued controller called for fetching transaction by status.");
        return bookissuedservice.findTransactionByStatus(name);
    }

    @PutMapping("/updateTransaction")
    public BookIssuedTransaction_Info updateTransaction(@RequestBody BookIssuedTransaction_Info book) {
        log.info("Book issued controller called for updating transaction ");
        return bookissuedservice.updateTransaction(book);

    }
}
