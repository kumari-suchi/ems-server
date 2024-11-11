package com.ex.emp.service;

import com.ex.emp.dto.EmployeeDto;

import java.util.List;

public interface EmpService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long employeeId,EmployeeDto updatedEmployee);
    void deleteEmployee(Long employeeId);

}
