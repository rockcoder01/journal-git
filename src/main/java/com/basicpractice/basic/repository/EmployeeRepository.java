package com.basicpractice.basic.repository;

import org.springframework.stereotype.Repository;

import com.basicpractice.basic.entities.EmployeeEntities;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntities, Long>
{

}
