package com.lynn.meta;

import javax.persistence.*;
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "userName")
    private String username;
    private String password;
    @Column(name = "nickName")
    private String nickname;
    @Column(name = "userType")
    private Integer usertype;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String userName) {
        this.username = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickName) {
        this.nickname = nickName;
    }
    public Integer getUsertype() {
        return usertype;
    }
    public void setUsertype(Integer userType) {
        this.usertype = userType;
    }
}