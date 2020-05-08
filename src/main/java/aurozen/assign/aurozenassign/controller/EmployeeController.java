package aurozen.assign.aurozenassign.controller;

import aurozen.assign.aurozenassign.entity.Employee;
import aurozen.assign.aurozenassign.model.AuthenticationRequest;
import aurozen.assign.aurozenassign.model.AuthenticationResponse;
import aurozen.assign.aurozenassign.repositry.EmployeeRepositry;
import aurozen.assign.aurozenassign.service.MyUserDetailsService;
import aurozen.assign.aurozenassign.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    EmployeeRepositry empRepo;

    @PostMapping(value = "/signup",produces = {"application/json"})
    public Employee addEmployee(@RequestBody Employee employee) {
        empRepo.save(employee);
        return employee;
    }

    @PutMapping(path = "/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {

     employee=empRepo.save(employee);
//        empRepo.save(employee.updateSkillsetEmpId(employee));
        return employee;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getEmp() {

        return empRepo.findAll();

    }

    @RequestMapping("/employee/{empid}")
    @ResponseBody
    public String getEmpById(@PathVariable("empid") int empid) {
        return empRepo.findById(empid).toString();
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
