package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor  // Default constructor
@AllArgsConstructor // All args constructor generated by Lombok
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "user_id",unique = true)
    private long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "email_id", unique = true)
    private String emailId;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "designation")
    private String designation;

//    @Column(name = "department_id")
//    private long departmentId;
//
//    @Column(name = "project_id")
//    private long projectId;
//
//    @Column(name = "password")
//    private String passWord;

//    @Column(name = "roles")
//    private String roles;



    // Override equals and hashCode if needed
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(id);
    }
}
