package net.javaproject.ems.service.implement;

import lombok.AllArgsConstructor;
import net.javaproject.ems.dto.EmployeeDto;
import net.javaproject.ems.entity.Employee;
import net.javaproject.ems.exception.ResourceNotFound;
import net.javaproject.ems.mapper.EmployeeMapper;
import net.javaproject.ems.repository.EmployeeRepository;
import net.javaproject.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeebyId(Long employeeId) {

        Employee employee =  employeeRepository.findById(employeeId)
                .orElseThrow(
                        ()-> new ResourceNotFound("Employee is not exist with given id"+employeeId)
                );
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
       Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFound("Employee is not exist with given id"+employeeId)
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }


}
