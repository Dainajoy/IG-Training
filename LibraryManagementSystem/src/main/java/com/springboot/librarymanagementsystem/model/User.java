package com.springboot.librarymanagementsystem.model;

import lombok.*;

import javax.persistence.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "usersInfo")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;

    private String userEmailId;

    private String userMobileNo;

    private String userAddress;

    private String userType;

    private String userStatus;

    }
