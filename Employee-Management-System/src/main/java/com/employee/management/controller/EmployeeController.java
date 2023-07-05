package com.employee.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.management.entity.Employee;
import com.employee.management.service.EmployeeService;


@Controller
public class EmployeeController {
	
	private EmployeeService empSrvc;


    public EmployeeController(EmployeeService employeeService) {
        this.empSrvc = employeeService;
    }
   
    @GetMapping("/employees")
    public String listEmployees(Model model) {
        model.addAttribute("employees", empSrvc.getAllEmployees());
        return "Employee-List";
    }
    
    @GetMapping("/employees/new")
    public String createEmployeeForm(Model model) {
        // create employee object to hold employee form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "Create-Employee";
    }


    @PostMapping("/employees")
    public String saveEmployee(
            @ModelAttribute("employee") Employee employee) {
    	empSrvc.saveEmployee(employee);
        return "redirect:/employees";
    }  

    
    @GetMapping("/employees/edit/{id}")
	public String editEmployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee", empSrvc.getEmployeeById(id));
		return "Update-Employee";
	}

	@PostMapping("/employees/{id}")
	public String updateEmployee(
			@PathVariable Long id, 
			@ModelAttribute("employee") Employee employee, 
			Model model) {

		Employee existingEmp = empSrvc.getEmployeeById(id);
		existingEmp.setId(id);
		existingEmp.setFirstName(employee.getFirstName());
		existingEmp.setLastName(employee.getLastName());
		existingEmp.setEmail(employee.getEmail());

		empSrvc.updateEmployee(existingEmp);
		return "redirect:/employees";
	}	

    
    @GetMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
    	empSrvc.deleteEmployeeById(id);
        return "redirect:/employees";
    }

}


