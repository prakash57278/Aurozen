package aurozen.assign.aurozenassign.repositry;


import aurozen.assign.aurozenassign.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepositry extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByEmpcontact(String s);
}
