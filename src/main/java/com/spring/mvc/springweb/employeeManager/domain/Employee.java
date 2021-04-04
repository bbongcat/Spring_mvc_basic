package com.spring.mvc.springweb.employeeManager.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@AllArgsConstructor
@ToString
public class Employee {

    private int empNo;      //사원 번호
    private String name;    //사원 이름
    private int age;        //사원 나이
    private String dept;    //사원 부서

}
