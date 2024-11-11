package com.ex.emp.service.impl;

import com.ex.emp.dto.EmployeeDto;
import com.ex.emp.entity.Employee;
import com.ex.emp.exception.ResourceNotFoundException;
import com.ex.emp.mapper.EmpMapper;
import com.ex.emp.repository.EmpRepository;
import com.ex.emp.service.EmpService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmpServiceImpl implements EmpService {

    private EmpRepository empRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee= EmpMapper.mapToEmployee(employeeDto);
        Employee savedEmployee=empRepository.save(employee);
        return EmpMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
       Employee employee= empRepository.findById(employeeId).
                orElseThrow(()->new ResourceNotFoundException("Employee is not exist with given id:"+employeeId));
        return EmpMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees=empRepository.findAll();
        return employees.stream().map((employee) -> EmpMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

        Employee employee= empRepository.findById(employeeId).
                orElseThrow(()->new ResourceNotFoundException("Employee is not exist with given id:"+employeeId));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setJobRole(updatedEmployee.getJobRole());
        Employee updatedEmp= empRepository.save(employee);
        return EmpMapper.mapToEmployeeDto(updatedEmp);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee= empRepository.findById(employeeId).
                orElseThrow(()->new ResourceNotFoundException("Employee is not exist with given id:"+employeeId));
        empRepository.deleteById(employeeId);
    }
}
