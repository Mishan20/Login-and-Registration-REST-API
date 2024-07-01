package com.learn.RegisterLogin.Service.Impl;

import com.learn.RegisterLogin.Dto.EmployeeDTO;
import com.learn.RegisterLogin.Dto.loginDTO;
import com.learn.RegisterLogin.Entity.Employee;
import com.learn.RegisterLogin.Repo.EmployeeRepo;
import com.learn.RegisterLogin.Response.loginResponse;
import com.learn.RegisterLogin.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeIMPL implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getEmployeeid(),
                employeeDTO.getEmployeename(),
                employeeDTO.getEmail(),
                this.passwordEncoder.encode(employeeDTO.getPassword())
        );
        employeeRepo.save(employee);

        return employee.getEmployeename();

    }
    EmployeeDTO employeeDTO;
    @Override
    public  loginResponse  loginEmployee(loginDTO loginDTO) {
        String msg = "";
        Employee employee1 = employeeRepo.findByEmail(loginDTO.getEmail());
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Employee> employee = employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new  loginResponse("Login Success", true);
                } else {
                    return new  loginResponse("Login Failed", false);
                }
            } else {
                return new  loginResponse("password Not Match", false);
            }
        }else {
            return new  loginResponse("Email not exits", false);
        }
    }
}
