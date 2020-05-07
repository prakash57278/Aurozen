package aurozen.assign.aurozenassign.service;

import aurozen.assign.aurozenassign.entity.Employee;
import aurozen.assign.aurozenassign.model.MyUserDetails;
import aurozen.assign.aurozenassign.repositry.EmployeeRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    EmployeeRepositry employeeRepositry;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<Employee> emp =  employeeRepositry.findByEmpcontact(s);

        return emp.map(MyUserDetails::new).get() ;
    }
}
