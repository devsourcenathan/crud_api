package com.nathan.spring_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nathan.spring_api.entity.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Integer>{

}
