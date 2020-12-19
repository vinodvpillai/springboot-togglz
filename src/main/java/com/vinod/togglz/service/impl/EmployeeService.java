package com.vinod.togglz.service.impl;

import com.vinod.togglz.aspect.FeatureAssociation;
import com.vinod.togglz.dto.EmployeeQueryDto;
import com.vinod.togglz.dto.EmployeeRegisterDto;
import com.vinod.togglz.model.Employee;
import com.vinod.togglz.repository.EmployeeRepository;
import com.vinod.togglz.service.IEmployeeService;
import com.vinod.togglz.util.MyFeatures;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.vinod.togglz.util.GlobalUtility.isNotNull;

@Service
@Slf4j
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Add Employee object to database.
     *
     * @param employeeRegisterDto - Employee register command object.
     */
    @Override
    public void addEmployee(EmployeeRegisterDto employeeRegisterDto) {
        log.trace("Request came to add new customer : {}", employeeRegisterDto);
        modelMapper.typeMap(EmployeeRegisterDto.class, Employee.class).addMappings(mapper -> mapper.skip(Employee::setId));
        Employee customer = modelMapper.map(employeeRegisterDto, Employee.class);
        customer.setEnabled(true);
        employeeRepository.save(customer);
        log.trace("Successfully saved customer object for: {}", employeeRegisterDto);
    }

    /**
     * Get Employee object by id.
     *
     * @param id    - Employee ID.
     * @return      - Employee query object.
     */
    @Override
    public EmployeeQueryDto getEmployeeById(Long id) {
        log.trace("Request came to fetch the employee having employee id : {}",id);
        Optional<Employee> optionalEmployee=employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            Employee employee=optionalEmployee.get();
            EmployeeQueryDto employeeQueryDto=modelMapper.map(employee,EmployeeQueryDto.class);
            log.trace("Successfully fetched employee object : {} having employee id: {}",employeeQueryDto,id);
            return employeeQueryDto;
        }
        return null;
    }

    /**
     * Delete employee by ID.
     *
     * @param id - Employee ID.
     */
    @Override
    @FeatureAssociation(value = MyFeatures.EMPLOYEE_DELETE_FEATURE)
    public void deleteEmployee(Long id) {
        log.trace("Request came to delete the employee having employee id : {}",id);
        if(isNotNull(getEmployeeById(id))) {
            employeeRepository.deleteById(id);
            log.trace("Successfully delete employee object having employee id: {}",id);
        }
    }


}
