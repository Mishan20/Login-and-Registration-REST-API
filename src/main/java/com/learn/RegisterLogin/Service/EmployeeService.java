package com.learn.RegisterLogin.Service;

import com.learn.RegisterLogin.Dto.EmployeeDTO;
import com.learn.RegisterLogin.Dto.loginDTO;
import com.learn.RegisterLogin.Response.loginResponse;

public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);
    loginResponse loginEmployee(loginDTO loginDTO);
}
