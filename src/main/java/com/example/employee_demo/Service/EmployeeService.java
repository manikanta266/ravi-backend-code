package com.example.employee_demo.Service;

import com.example.employee_demo.entity.Employee;
import com.example.employee_demo.Exception.ResourceNotFoundException;
import com.example.employee_demo.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public List<Employee> getAllEmployees() {

        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(int employeeId) {
        Employee getEmployee = employeeRepo.findById(employeeId).get();
        return getEmployee;
    }

    public Employee updateEmployee(int employeeId, Employee updateEmployee) {
        Employee updateEmp = getEmployeeById(employeeId);
        updateEmp.setName(updateEmployee.getName());
        updateEmp.setAddress(updateEmployee.getAddress());
        updateEmp.setAge(updateEmployee.getAge());
        updateEmp.setPassword(updateEmployee.getPassword());
        return employeeRepo.save(updateEmp);

    }
    public void deleteEmployee(int employeeId) {
      if (!employeeRepo.existsById(employeeId)) {
          throw new ResourceNotFoundException("Employee with ID " + employeeId + " not found");
      }
      employeeRepo.deleteById(employeeId);

    }
}
