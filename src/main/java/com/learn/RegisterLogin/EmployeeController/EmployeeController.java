package com.learn.RegisterLogin.EmployeeController;

import com.learn.RegisterLogin.Dto.EmployeeDTO;
import com.learn.RegisterLogin.Dto.loginDTO;
import com.learn.RegisterLogin.Response.loginResponse;
import com.learn.RegisterLogin.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController // This annotation tells Spring that this class will be a controller
@CrossOrigin // This annotation tells Spring to allow requests from any origin
@RequestMapping("/api/v1/employee") // This annotation tells Spring that this controller will handle requests to the /api/v1/employee path
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        String id = employeeService.addEmployee(employeeDTO);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody loginDTO loginDTO)
    {
        loginResponse loginResponse = employeeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}
