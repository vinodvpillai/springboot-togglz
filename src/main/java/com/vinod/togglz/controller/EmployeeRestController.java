package com.vinod.togglz.controller;

import com.vinod.togglz.dto.EmployeeQueryDto;
import com.vinod.togglz.dto.EmployeeRegisterDto;
import com.vinod.togglz.service.IEmployeeService;
import com.vinod.togglz.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.vinod.togglz.util.GlobalUtility.buildResponseForError;
import static com.vinod.togglz.util.GlobalUtility.buildResponseForSuccess;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeRestController {

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Response> addNewCustomer(@RequestBody EmployeeRegisterDto employeeRegisterDto) {
        try{
            log.trace("Request came to add new employee with following details: {}", employeeRegisterDto);
            employeeService.addEmployee(employeeRegisterDto);
            return buildResponseForSuccess(HttpStatus.SC_OK,"Successfully added the employee details.",null);
        } catch (Exception e) {
            log.error("Exception occurred while adding the employee details, error msg: {}",e.getMessage(), e);
            return buildResponseForError(HttpStatus.SC_INTERNAL_SERVER_ERROR, String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR),"Unable to add the employee details.",null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getEmployee(@PathVariable("id") Long id) {
        log.trace("Request came to get the employee details having the id: {}", id);
        EmployeeQueryDto employeeQueryDto=employeeService.getEmployeeById(id);
        if(null!=employeeQueryDto) {
            return buildResponseForSuccess(HttpStatus.SC_OK,"Successfully fetched employee",employeeQueryDto);
        }
        return buildResponseForError(HttpStatus.SC_BAD_REQUEST, String.valueOf(HttpStatus.SC_BAD_REQUEST),"No employee detail found for the given id.",null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteEmployee(@PathVariable("id") Long id) {
        try{
            log.trace("Request came to delete employee details having the id: {}", id);
            employeeService.deleteEmployee(id);
            return buildResponseForSuccess(HttpStatus.SC_OK,"Successfully delete the employee details.",null);
        } catch (Exception e) {
            log.error("Exception occurred while deleting the employee details, error msg: {}",e.getMessage(), e);
            return buildResponseForError(HttpStatus.SC_INTERNAL_SERVER_ERROR, String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR),"Unable to delete the employee details.",null);
        }
    }
}
