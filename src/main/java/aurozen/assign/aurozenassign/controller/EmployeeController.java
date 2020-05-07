package aurozen.assign.aurozenassign.controller;

import aurozen.assign.aurozenassign.entity.Employee;
import aurozen.assign.aurozenassign.repositry.EmployeeRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeRepositry empRepo;

    @PostMapping("/signup")
    public Employee addEmployee(Employee employee){
        empRepo.save(employee);
        return employee;
    }

    @PutMapping(path = "/employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        empRepo.save(employee);
        return employee;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getEmp(){

        return empRepo.findAll();

    }

    @RequestMapping("/employee/{empid}")
    @ResponseBody
    public String getEmpById(@PathVariable("empid") int empid ){
        return empRepo.findById(empid).toString();
    }

}
