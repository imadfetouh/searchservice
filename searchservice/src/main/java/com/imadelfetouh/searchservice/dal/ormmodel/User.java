package com.imadelfetouh.searchservice.dal.ormmodel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {

    public User() {

    }

    public User(String userId, String username, String photo) {
        this.userId = userId;
        this.username = username;
        this.photo = photo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "userId")
    private String userId;

    @Column(name = "username")
    private String username;

    @Column(name = "userphoto")
    private String photo;

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPhoto() {
        return photo;
    }
}