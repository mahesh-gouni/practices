package com.practices.perfect;

import jakarta.persistence.*;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class CriteriaQueryExample  {
    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mahi");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<EmployeeEntity> cq = cb.createQuery(EmployeeEntity.class);
        Root<EmployeeEntity> employeeEntityRoot=cq.from(EmployeeEntity.class);


        cq.multiselect(employeeEntityRoot.get("EmployeeID"),employeeEntityRoot.get("name"),employeeEntityRoot.get("Age"),employeeEntityRoot.get("Email") );
        CriteriaQuery<EmployeeEntity> select = cq.select(employeeEntityRoot);
        TypedQuery<EmployeeEntity> q = em.createQuery(select);
        List<EmployeeEntity> list = q.getResultList();

        System.out.print("emp_id");
        System.out.print("\t emp_name");
        System.out.println("\t emp_age");
    //    System.out.println("\t emp_gmail");

        for(EmployeeEntity s:list)
        {
            System.out.print(s.getEmployeeID()+"    ");
            System.out.print("\t"+s.getName()+"      ");
            System.out.println("\t"+s.getAge());
        //    System.out.println("\t"+s.getEmail());
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }}

