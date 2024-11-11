package com.ex.emp.controller;

import com.ex.emp.dto.EmployeeDto;
import com.ex.emp.entity.Employee;
import com.ex.emp.service.EmpService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmpController {

    private EmpService empService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee=empService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto=empService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees=empService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto updatedEmp){
        EmployeeDto employeeDto=empService.updateEmployee(employeeId,updatedEmp);
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
         empService.deleteEmployee(employeeId);
         return ResponseEntity.ok("Employee deleted successfully!");
    }
}
