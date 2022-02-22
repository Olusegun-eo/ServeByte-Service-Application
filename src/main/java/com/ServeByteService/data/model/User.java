package com.ServeByteService.data.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String email;
    @Column(unique = true, nullable = false)
    private String phoneNumber;
    @Column(length = 500)
    private String address;
}
