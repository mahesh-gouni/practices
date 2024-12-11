package com.practices.perfect;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
@ToString
public class EmployeeEntity {


    @Id
    @Column(name = "EmployeeID")
    private Long EmployeeID;
    @Column(name = "name")
    private String name;

    @Column(name = "Age")
    private int Age;



    @Column(name = "HireDate")
    private LocalDateTime HireDate;

    @Column(name = "Salary")
    private double Salary;

    @Column(name = "Location")
    private String  Location;


    @Column(name = "Email")
    private String  Email;

    @JoinColumn(name = "DepartmentID")
    @ManyToOne
    @ToString.Exclude
    private DepartmentEntity departmentEntity;




}

