package com.isep.controller;

/**
 * @program: TP3_testjpa
 * @description:
 * @author: Jintao
 * @create: 2024-03-31 22:14
 **/

import com.isep.repository.EmpRepository;
import com.isep.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SimpleController {

    @Autowired
    private EmpRepository empRepository;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String hello(@Param("name") String name) {
        return "Hello " + name;
    }

    @RequestMapping(value="/employees", method= RequestMethod.GET)
    public List<Emp> getEmployees() {
        return empRepository.findAll();
    }
    @PostMapping(value="/employees")
    public Emp addEmployee(@RequestBody Emp emp) {
        return empRepository.save(emp);
    }


}

