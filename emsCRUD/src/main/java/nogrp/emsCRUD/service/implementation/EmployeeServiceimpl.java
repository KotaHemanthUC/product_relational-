package nogrp.emsCRUD.service.implementation;

import lombok.AllArgsConstructor;
import nogrp.emsCRUD.dto.EmployeeDto;
import nogrp.emsCRUD.entity.Employee;
import nogrp.emsCRUD.exception.ResourceNotFoundException;
import nogrp.emsCRUD.mapper.EmployeeMapper;
import nogrp.emsCRUD.repository.EmployeeRepository;
import nogrp.emsCRUD.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceimpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return (EmployeeMapper.mapToEmployeeDto(savedEmployee));
    }

    @Override
    public EmployeeDto getEmployeeId(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee dosen't exist with given ID"+employeeId));
        return (EmployeeMapper.mapToEmployeeDto(employee));
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employee -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee dosent exist with given ID:"+employeeId)
        );
        employee.setFirstname(updatedEmployee.getFirstname());
        employee.setLastname(updatedEmployee.getLastname());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

}
