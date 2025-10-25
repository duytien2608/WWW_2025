package iuh.fit.se.nguyenduytien_21000025_tuan08.controllers;


import iuh.fit.se.nguyenduytien_21000025_tuan08.entities.Employee;
import iuh.fit.se.nguyenduytien_21000025_tuan08.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String index(Model model) {
        List<Employee> employees = this.employeeService.getAll();

        model.addAttribute("employees", employees);

        return "list";
    }

    @GetMapping("/show-form")
    public ModelAndView showForm(ModelAndView modelAndView) {
        Employee employee = new Employee();

        modelAndView.addObject("employee", employee);
        modelAndView.setViewName("register");

        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        this.employeeService.save(employee);

        return "redirect:";
    }

    @GetMapping("/show-form-update")
    public ModelAndView showFormUpdate(@RequestParam("employeId") Long id, ModelAndView modelAndView) {
        Employee employee = this.employeeService.getById(id);

        if (employee == null) {
            modelAndView.addObject("errorMessage", "Not found - employee id: " + id);
            modelAndView.setViewName("error");
        }
        else {
            modelAndView.addObject("employee", employee);
            modelAndView.setViewName("register");
        }

        return modelAndView;
    }
}
