package com.springboot.librarymanagementsystem.exception;

import lombok.*;

import java.util.Date;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {



        private Date Timestamp;
        private String message;
        private String details;


    }
