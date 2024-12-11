package com.practices.perfect;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "departments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DepartmentEntity {

    @Id
    @Column(name = "DepartmentID")
    private int DepartmentID;

    @Column(name = "DepartmentName")
    private String DepartmentName;

    @Column(name = "location")
    private String location;

    @Column(name = "managerID")
    private int managerID;

    @OneToMany(mappedBy = "departmentEntity",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<EmployeeEntity> employeeList = new ArrayList<>() ;

}

