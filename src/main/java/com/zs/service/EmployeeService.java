package com.zs.service;


import com.zs.domain.Employee;
import com.zs.repository.EmployeeCrudRepository;
import com.zs.repository.EmployeePagingAndSortingRepository;
import com.zs.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Autowired
    private EmployeePagingAndSortingRepository employeePagingAndSortingRepository;

    @Transactional
    public void update(Integer id, Integer age){
        employeeRepository.update(id,age);
    }

    @Transactional
    public void save(List<Employee> employees){
        employeeCrudRepository.save(employees);
    }
}
