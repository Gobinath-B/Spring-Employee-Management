package net.javaproject.ems.controller;

import lombok.AllArgsConstructor;
import net.javaproject.ems.dto.EmployeeDto;
import net.javaproject.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

@RequestMapping("/api/employees")

public class EmpoyeeController {
     private EmployeeService employeeService;

     //POST request
     @PostMapping

     public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
         EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
         return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
     }

     //GET REQUEST
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeebyId(@PathVariable("id") Long employeeId){
         EmployeeDto employeeDto = employeeService.getEmployeebyId(employeeId);
         return ResponseEntity.ok(employeeDto);
    }

    @GetMapping

    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
         List<EmployeeDto> employee = employeeService.getAllEmployee();
         return ResponseEntity.ok(employee);
    }
}
