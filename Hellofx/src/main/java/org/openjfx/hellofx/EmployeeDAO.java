/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.hellofx;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Biedras
 */
public interface EmployeeDAO {

    /**
     * Zwraca pracownika o podanym id
     */
    Optional<Employee> findOne(Integer id);

    /**
     * Zwraca wszystkich pracowników
     */
    List<Employee> findAll();

    /**
     * Zwraca pracownika o podanym nazwisku
     */
    Optional<Employee> findByName(String name);

    /**
     * Usuwa pracownika
     */
    void delete(Employee employee);

    /**
     * Dodaje, jeśli brak, lub aktualizuje pracownika
     */
    void save(Employee employee);
}
