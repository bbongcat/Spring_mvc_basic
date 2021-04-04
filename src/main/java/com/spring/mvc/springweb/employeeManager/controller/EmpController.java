package com.spring.mvc.springweb.employeeManager.controller;

import com.spring.mvc.springweb.employeeManager.domain.Employee;
import com.spring.mvc.springweb.employeeManager.repository.EmpRepository;
import com.spring.mvc.springweb.employeeManager.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpController {

    private final EmpService empService;
    private final EmpRepository empRepository;

    public EmpController(EmpService empService, EmpRepository empRepository) {
        this.empService = empService;
        this.empRepository = empRepository;
    }

    //사원 등록 화면 요청
    @GetMapping("/empManager/write.jsp")
    public String write() {
        return "empManager/write.jsp";
    }

    //사원 등록 처리 요청
    @PostMapping("/empManager/write.jsp")
    public String write(Employee emp) {
        empRepository.insertEmp(emp);
        return "redirect:/empManager/list";
    }

    //사원 목록 조회 요청
    @GetMapping("/empManager/list")
    public String list(Model model) {
        model.addAttribute("emp", empRepository);
        return "empManager/list";
    }

    //사원 정보 삭제 요청
    @GetMapping("/empManager/delete")
    public String delete(int empNo) {
        empRepository.deleteEmp(empNo);
        return "redirect:/empManager/list";
    }

    //사원 정보 수정 화면 요청
    @GetMapping("/empManager/modify")
    public String modify(int empNo, Model model) {
        model.addAttribute("emp", empRepository);
        return "empManager/modify";
    }

    //사원 정보 수정 처리 요청
    @PostMapping("/empManager/modify")
    public String modify(Employee employee) {
        Employee emp = empRepository.getEmp(employee.getEmpNo());
        emp.setName(employee.getName());
        emp.setAge(employee.getAge());
        emp.setDept(employee.getDept());
        empRepository.modifyEmp(emp);
        return "redirect:/empManager/content?empNo="+employee.getEmpNo();
    }



}
