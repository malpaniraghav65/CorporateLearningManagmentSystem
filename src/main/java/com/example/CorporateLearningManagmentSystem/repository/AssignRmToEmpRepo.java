package com.example.CorporateLearningManagmentSystem.repository;
import com.example.CorporateLearningManagmentSystem.entity.AssignRmToEmp;
import com.example.CorporateLearningManagmentSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AssignRmToEmpRepo extends JpaRepository<AssignRmToEmp, Integer> {


    @Query(value = "SELECT * FROM reportingmanager_employee WHERE emp_id = :employeeId", nativeQuery = true)
    AssignRmToEmp findByEmployee_Id(@Param("employeeId") int employeeId);
//    AssignRmToEmp findByEmployee_Id(int employeeId);

    boolean existsByEmployee(User employee);
}
