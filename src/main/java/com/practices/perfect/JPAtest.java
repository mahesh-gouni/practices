package com.practices.perfect;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JPAtest {
    public static void main(String[] args) {
        JpaService jpaService = new JpaService();
//        List<EmployeeEntity> employeeEntities = jpaService.getAllocationEmployeesJpa();
     List<DepartmentEntity> departmentEntities = new ArrayList<>();
//        for (EmployeeEntity department:employeeEntities){
//
//            System.out.println(department);
//        }
//        for (EmployeeEntity employee:employeeEntityList)
//        System.out.println(employeeEntityList);
//        //employeeEntities.stream().collect(Collectors.toCollection())

        DepartmentService departmentService=new DepartmentService();
       departmentEntities=  departmentService.getAllocationDepartmentJpa();
       for (DepartmentEntity department:departmentEntities) System.out.println(department);
   }
}