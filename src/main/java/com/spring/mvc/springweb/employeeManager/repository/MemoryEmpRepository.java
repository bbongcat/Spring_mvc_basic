package com.spring.mvc.springweb.employeeManager.repository;

import com.spring.mvc.springweb.employeeManager.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("memoryEmpRepo")
public class MemoryEmpRepository implements EmpRepository {

    private static Map<Integer, Employee> empMap = new HashMap<>();

    @Override
    public List<Employee> getEmps() {
        List<Employee> emp = new ArrayList<>();
        for (int empNo : empMap.keySet()) {
            Employee employee = empMap.get(empNo);
            emp.add(employee);
        }
        return emp;
    }

    @Override
    public void insertEmp(Employee emp) {
        empMap.put(emp.getEmpNo(), emp);
    }

    @Override
    public void deleteEmp(int empNo) {
        empMap.remove(empNo);
    }

    @Override
    public void modifyEmp(Employee emp) {
        empMap.put(emp.getEmpNo(), emp);
    }

    @Override
    public Employee getEmp(int empNo) {
        return empMap.get(empNo);
    }
}
