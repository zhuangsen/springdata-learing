package com.zs.repository;

import com.zs.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeJpaRepostory extends JpaRepository<Employee, Integer> {
}
