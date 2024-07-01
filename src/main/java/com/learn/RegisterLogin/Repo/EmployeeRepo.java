package com.learn.RegisterLogin.Repo;

import com.learn.RegisterLogin.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories // This annotation tells Spring to enable JPA repositories
@Repository // This annotation tells Spring that this class will be a repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    Optional<Employee> findOneByEmailAndPassword(String email, String password);
    Employee findByEmail(String email);
}
