package com.example.springbootjpahibernateexample.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users_tbl")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="salary")
    private Integer salary;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id",referencedColumnName = "user_id")
    private List<UsersLog> usersLogs;

    public List<UsersLog> getUsersLogs() {
        return usersLogs;
    }

    public void setUsersLogs(List<UsersLog> usersLogs) {
        this.usersLogs = usersLogs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
