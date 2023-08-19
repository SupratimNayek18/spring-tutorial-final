package com.spring.departmentservice.controller;

import com.spring.departmentservice.dto.DepartmentDto;
import com.spring.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/saveDepartment")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(departmentService.saveDepartment(departmentDto), HttpStatus.CREATED);
    }

    @GetMapping("/getDepartmentByCode/{code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable String code){
        return new ResponseEntity<>(departmentService.getDepartmentByCode(code),HttpStatus.FOUND);
    }


}
