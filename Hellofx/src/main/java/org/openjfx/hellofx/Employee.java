/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.hellofx;

/**
 *
 * @author Biedras
 */
public class Employee {
    private Integer id;
    private String name;
    private String email;
    private Double salary;
    
    public Employee(Integer id, String name, String email, Double salary){
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }
    
    
}
