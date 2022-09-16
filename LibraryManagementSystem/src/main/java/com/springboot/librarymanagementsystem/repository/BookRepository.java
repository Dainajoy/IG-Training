package com.springboot.librarymanagementsystem.repository;

import com.springboot.librarymanagementsystem.model.Books_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Books_Info, Long> {
    

    public List<Books_Info> findBybookName(String bookName);
    public List<Books_Info> findByAuthor(String author);
    public List<Books_Info> findByBookPublication(String BookPublication);

}
