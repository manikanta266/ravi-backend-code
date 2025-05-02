package com.example.employee_demo.controller;

import com.example.employee_demo.entity.Employee;
import com.example.employee_demo.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {


    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
// testing post-commit hook
// testing post-commit hook
// testing post-commit hook


    @PostMapping("/submit")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee save = employeeService.createEmployee(employee);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }


    @GetMapping("/get")
    public ResponseEntity<Employee> getEmployeeById(@RequestParam int employeeId) {
        Employee getEmployee = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(getEmployee, HttpStatus.OK);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int employeeId, @RequestBody Employee updateEmployee) {
        Employee updated = employeeService.updateEmployee(employeeId, updateEmployee);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") int employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>("Employee deleted", HttpStatus.OK);
    }

    @RestController
    public class WebhookController {

        @PostMapping("/github-webhook")
        public ResponseEntity<String> receiveWebhook(@RequestBody String payload) {
            System.out.println("Received webhook payload: " + payload);
            return ResponseEntity.ok("Webhook received");
        }
    }


}

