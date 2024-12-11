package com.practices.perfect;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class DepartmentService {
    public List<DepartmentEntity> getAllocationDepartmentJpa() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mahi");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();


        Query query = entityManager.createQuery("select p from DepartmentEntity as p right join fetch p.employeeList as e where e.departmentEntity.DepartmentID = p.DepartmentID");


      //  select p from DepartmentEntity p join fetch p.employeeList e where e.department.id = p.id

        List<DepartmentEntity> resultList = query.getResultList();
        System.out.println("Result list size: " + resultList.size());

        entityManager.getTransaction().commit();

        return resultList;
    }

}
