package com.springboot.librarymanagementsystem.repository;

import com.springboot.librarymanagementsystem.model.BookIssuedTransaction_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookIssueRepository extends JpaRepository<BookIssuedTransaction_Info,Long> {
    List<BookIssuedTransaction_Info> findByUserId(Long userId);
    List<BookIssuedTransaction_Info> findBytransactionStatus(String transactionStatus);
}
