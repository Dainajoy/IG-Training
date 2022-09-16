package com.springboot.librarymanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "BookInfo")
public class Books_Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String bookName;

    private String author;

    private float price;

    private Long totalPages;

    private Long noOfCopies;

    private String bookPublication;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "createdBy",referencedColumnName = "userId")
    private User createdBy;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
    private Date createdOn;
    @ManyToOne
    @JoinColumn(name = "modifiedBy")
    private User modifiedBy;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
    private Date modifiedOn;
    private int activeFlag;

}
