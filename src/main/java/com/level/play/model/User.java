package com.level.play.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_id_seq")
    @SequenceGenerator(name="user_id_seq", sequenceName = "user_id_seq", allocationSize=1)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "profile_picture")
    private String profilePicture;
}
