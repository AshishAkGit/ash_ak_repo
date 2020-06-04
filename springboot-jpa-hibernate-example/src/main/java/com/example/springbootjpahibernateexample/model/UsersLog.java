package com.example.springbootjpahibernateexample.model;

import javax.persistence.*;

@Entity
@Table(name="users_log")
public class UsersLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="log_id")
    private Integer id;
    private String log;
    @Column(name="user_id")
    private Integer userId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id",referencedColumnName = "user_id")
    private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }
}
