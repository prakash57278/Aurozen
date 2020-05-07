package aurozen.assign.aurozenassign.repositry;


import aurozen.assign.aurozenassign.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositry extends JpaRepository<Employee, Integer> {

}
