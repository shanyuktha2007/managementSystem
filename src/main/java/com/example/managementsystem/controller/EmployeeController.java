
package com.example.managementsystem.controller;

import com.example.managementsystem.model.Employee;
import com.example.managementsystem.service.EmployeeService;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String showEmployees(Model model) {
        if (!model.containsAttribute("employee")) {
            model.addAttribute("employee", new Employee());
        }

        model.addAttribute("employees",
                employeeService.getAllEmployees());

        return "employees";
    }

    @PostMapping("/employees")
    public String registerEmployee(
            @Valid @ModelAttribute("employee") Employee employee,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            model.addAttribute("employees",
                    employeeService.getAllEmployees());
            return "employees";
        }

        employeeService.registerEmployee(employee);

        redirectAttributes.addFlashAttribute(
                "successMessage",
                "Employee registered successfully!");

        return "redirect:/";
    }
}
