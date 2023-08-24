package com.spring.employeeservice.service.impl;

import com.spring.employeeservice.dto.APIResponseDto;
import com.spring.employeeservice.dto.DepartmentDto;
import com.spring.employeeservice.dto.EmployeeDto;
import com.spring.employeeservice.entity.Employee;
import com.spring.employeeservice.repository.EmployeeRepository;
import com.spring.employeeservice.service.APIClient;
import com.spring.employeeservice.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

//    @Autowired
//    private APIClient apiClient;


    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = modelMapper.map(employeeDto, Employee.class);

        Employee savedEmployee = employeeRepository.save(employee);

        return modelMapper.map(savedEmployee, EmployeeDto.class);

    }

    @Override
    @CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    public APIResponseDto getEmployeeById(Long id) {

        //Fetching the employee from the DB
        Employee employee = employeeRepository.findById(id).get();


        //Fetching the department info from department microservice using REST TEMPLATE
//        ResponseEntity<DepartmentDto> responseEntity =
//              restTemplate.getForEntity("http://localhost:8080/api/departments/getDepartmentByCode/"+employee.getDepartmentCode(),
//              DepartmentDto.class);


//        Fetching the department info from department microservice using WEB CLIENT
        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/getDepartmentByCode/"+employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();


        //Fetching the department info from department microservice using Feign CLIENT
//        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());

        //Converting into DTO Objects
//        DepartmentDto departmentDto = responseEntity.getBody();

        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

        //Setting a new response for containing both EmployeeDto and DepartmentDto
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;

    }

    public APIResponseDto getDefaultDepartment(Long id,Exception e){
        DepartmentDto departmentDto = new DepartmentDto(
                1L,
                "sampleDepartmentName",
                "sampleDepartmentDescription",
                "sampleDepartmentCode"
        );

        EmployeeDto employeeDto = new EmployeeDto(
                1L,
                "sampleFirstName",
                "sampleFirstName",
                "sampleEmail",
                "sampleDepartmentCode"
        );

        return new APIResponseDto(employeeDto,departmentDto);
    }
}
