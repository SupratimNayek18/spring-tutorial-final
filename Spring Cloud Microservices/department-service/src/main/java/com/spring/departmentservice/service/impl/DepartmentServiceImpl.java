package com.spring.departmentservice.service.impl;

import com.spring.departmentservice.dto.DepartmentDto;
import com.spring.departmentservice.entity.Department;
import com.spring.departmentservice.repository.DepartmentRepository;
import com.spring.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        //convert dept dto to entity

        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );

        Department department1 = departmentRepository.save(department);

        DepartmentDto departmentDto1 = new DepartmentDto(
                department1.getId(),
                department1.getDepartmentName(),
                department1.getDepartmentDescription(),
                department1.getDepartmentCode()
        );

        return departmentDto1;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {

        Department department = departmentRepository.findByDepartmentCode(code);

        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );

        return departmentDto;
    }

}
