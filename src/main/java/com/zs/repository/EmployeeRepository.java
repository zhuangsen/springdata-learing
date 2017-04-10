package com.zs.repository;


import com.zs.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;

@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeRepository {//extends Repository<Employee,Integer> {

    Employee findByName(String name);

    // where name like ?% and age <?
    List<Employee> findByNameStartingWithAndAgeLessThan(String name, Integer age);

    // where name like %? and age <?
    List<Employee> findByNameEndingWithAndAgeLessThan(String name, Integer age);

    // where name in (?,?....) or age <?
    List<Employee> findByNameInOrAgeLessThan(List<String> names, Integer age);

    @Query("select o from Employee o where id = (select max(id) from Employee t1)")
    Employee getEmployeeByMaxId();

    @Query("select o from Employee o where o.name=?1 and o.age=?2")
    List<Employee> queryParams1(String name, Integer age);

    @Query("select o from Employee o where o.name=:name and o.age=:age")
    List<Employee> queryParams2(@Param("name") String name, @Param("age") Integer age);

    @Query("select o from Employee o where o.name like %?1%")
    List<Employee> queryLike1(String name);

    @Query("select o from Employee o where o.name like %:name%")
    List<Employee> queryLike2(@Param("name") String name);

    @Query(value = "select count(1) from employee", nativeQuery = true)
    long getCount();

    @Modifying
    @Query("update Employee o set o.age = :age where o.id = :id")
    void update(@Param("id") Integer id, @Param("age") Integer age);
}
