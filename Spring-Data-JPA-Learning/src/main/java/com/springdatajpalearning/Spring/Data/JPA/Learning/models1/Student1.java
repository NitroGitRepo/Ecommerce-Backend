package com.springdatajpalearning.Spring.Data.JPA.Learning.models1;

import com.springdatajpalearning.Spring.Data.JPA.Learning.models.Laptop;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Student_Table")
public class Student1 {
    @Id
    private int studentId;
    private String studentName;
    private String about;



    @OneToMany(mappedBy = "student1", cascade = CascadeType.ALL)
    private List<Address> address;

    @Override
    public String toString() {
        return "Student1{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", about='" + about + '\'' +
                ", address=" + address +
                '}';
    }
}
