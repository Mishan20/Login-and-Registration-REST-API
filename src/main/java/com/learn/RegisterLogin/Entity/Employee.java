package com.learn.RegisterLogin.Entity;

import jakarta.persistence.*;

@Entity // This annotation tells Spring that this class will be an entity
@Table(name = "employee") // This annotation tells Spring that this entity will be mapped to a table named employee
public class Employee {
    @Id // This annotation tells Spring that this field will be the primary key
    @Column(name = "employeeid" , length = 45) // This annotation tells Spring that this field will be mapped to a column named employeeid
    @GeneratedValue(strategy = GenerationType.AUTO) // This annotation tells Spring that this field will be auto-generated
    private int employeeid;

    @Column(name = "employeename" , length = 225) // This annotation tells Spring that this field will be mapped to a column named employeename
    private String employeename;

    @Column(name = "email" , length = 225) // This annotation tells Spring that this field will be mapped to a column named email
    private String email;

    @Column(name = "password" , length = 225) // This annotation tells Spring that this field will be mapped to a column named password
    private String password;

    public Employee(int employeeid, String employeename, String email, String password) {
        this.setEmployeeid(employeeid);
        this.setEmployeename(employeename);
        this.setEmail(email);
        this.setPassword(password);
    }

    public Employee() {
    }


    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeid=" + employeeid +
                ", employeename='" + employeename + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
