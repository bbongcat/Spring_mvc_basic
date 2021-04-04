package com.spring.mvc.springweb.employeeManager.repository;

import com.spring.mvc.springweb.employeeManager.domain.Employee;

import java.util.*;

public interface EmpRepository {

    //전체 사원 정보 가져오기
    List<Employee> getEmps();

    //사원 정보 입력
    void insertEmp(Employee emp);

    //사원 정보 삭제
    void deleteEmp(int empNo);

    //사원 정보 수정
    void modifyEmp(Employee emp);

    //사원 정보 가져오기
    Employee getEmp(int empNo);

}
