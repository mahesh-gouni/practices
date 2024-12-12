package com.practices.perfect;
import jakarta.persistence.EntityManager;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class JpaService {
    public List<EmployeeEntity> getAllocationEmployeesJpa() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mahi");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        //  select * from departments inner join employees on departments.departmentid=employees.forkey_dep; departmentEntity
       // Query query = entityManager.createQuery("select p from EmployeeEntity as p inner join departmentEntity as e where p.forkey_dep=e.DepartmentID");
       // Query query = entityManager.createQuery("select p from EmployeeEntity as p");
       Query query = entityManager.createQuery("select p from EmployeeEntity as p inner join fetch p.departmentEntity as e where e.DepartmentID = p. .DepartmentID");
       // select p from EmployeeEntity as p inner join departmentEntity as e where p.forkey_dep=e.DepartmentID

        //  Query query = entityManager.createQuery("SELECT d FROM EmployeeEntity d JOIN d.employeeList e WHERE e.DepartmentID = d.forkey_dep");




        List<EmployeeEntity> resultList = query.getResultList();
        System.out.println("Result list size: " + resultList.size());

        entityManager.getTransaction().commit();

        return resultList;
    }

}