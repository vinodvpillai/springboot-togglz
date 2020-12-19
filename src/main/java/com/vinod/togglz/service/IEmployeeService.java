package com.vinod.togglz.service;

import com.vinod.togglz.dto.EmployeeQueryDto;
import com.vinod.togglz.dto.EmployeeRegisterDto;

public interface IEmployeeService {

    /**
     * Add Employee object to database.
     *
     * @param employeeRegisterDto - Employee register command object.
     */
    void addEmployee(EmployeeRegisterDto employeeRegisterDto);

    /**
     * Get Employee object by id.
     *
     * @param id    - Employee ID.
     * @return      - Employee query object.
     */
    EmployeeQueryDto getEmployeeById(Long id);


    /**
     * Delete employee by ID.
     *
     * @param id - Employee ID.
     */
    void deleteEmployee(Long id);
}
