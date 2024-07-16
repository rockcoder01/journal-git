package com.basicpractice.basic.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basicpractice.basic.dto.EmployeeDTO;
import com.basicpractice.basic.service.EmployeeService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable("id") Long EmployeeId) {
        return employeeService.getEmployeeById(EmployeeId);
    }

    // @GetMapping("/employee")
    // public String getEmployeeByName(@PathParam("name") String name) {
    // return "Hello world" + name;
    // // return new EmployeeDTO(EmployeeId, "Anuj", LocalDate.of(1998, 12, 10),
    // true);
    // }

    @GetMapping("/list")
    public List<EmployeeDTO> getEmployeeList() {
        return employeeService.getAllEmployee();
        // return new EmployeeDTO(EmployeeId, "Anuj", LocalDate.of(1998, 12, 10), true);
    }

    @PostMapping("/save")
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEmployeeById(@PathVariable("id") Long id) {
        return employeeService.deleteEmployeeById(id);
    }
}
