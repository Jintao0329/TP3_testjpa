package com.isep.controller;

/**
 * @program: TP3_testjpa
 * @description:
 * @author: Jintao
 * @create: 2024-04-01 02:47
 **/

import com.isep.model.Emp;
import com.isep.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmpRepository empRepository;

    // Get by ID
    @GetMapping("/employees/{id}")
    public ResponseEntity<Emp> getEmployeeById(@PathVariable(value = "id") Long empId) {
        Optional<Emp> emp = empRepository.findById(empId);
        return emp.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get All
    @GetMapping("/employees")
    public List<Emp> getAllEmployees() {
        return empRepository.findAll();
    }

    // Update by ID
    @PutMapping("/employees/{id}")
    public ResponseEntity<Emp> updateEmployee(@PathVariable(value = "id") Long empId, @RequestBody Emp employeeDetails) {
        Emp emp = empRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found for this id :: " + empId));
        emp.setEname(employeeDetails.getEname());
        emp.setEfirst(employeeDetails.getEfirst());
        emp.setJob(employeeDetails.getJob());
        emp.setMgr(employeeDetails.getMgr());
        emp.setSal(employeeDetails.getSal());
        final Emp updatedEmp = empRepository.save(emp);
        return ResponseEntity.ok(updatedEmp);
    }

    // Delete by ID
    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long empId) {
        Emp emp = empRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found for this id :: " + empId));
        empRepository.delete(emp);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
