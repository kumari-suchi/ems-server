package com.ex.emp.repository;

import com.ex.emp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Employee,Long> {

}
