package com.basicpractice.basic.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.basicpractice.basic.dto.EmployeeDTO;
import com.basicpractice.basic.entities.EmployeeEntities;
import com.basicpractice.basic.repository.EmployeeRepository;

@Service
public class EmployeeService {

    final EmployeeRepository employeeRepository;
    final ModelMapper modelmapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelmapper) {
        this.employeeRepository = employeeRepository;
        this.modelmapper = modelmapper;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntities employeeEntitiy = employeeRepository.getById(id);
        return new EmployeeDTO(employeeEntitiy.getId(), employeeEntitiy.getName(), employeeEntitiy.getDateOfJoiniDate(),
                employeeEntitiy.isActive());
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntities employeeEntities = modelmapper.map(employeeDTO, EmployeeEntities.class);
        return modelmapper.map(employeeRepository.save(employeeEntities), EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployee() {
        return employeeRepository
                .findAll()
                .stream()
                .map(employee -> modelmapper.map(employee, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public boolean deleteEmployeeById(Long id) {
        boolean isPresent = employeeRepository.existsById(id);
        if (!isPresent)
            return false;
        employeeRepository.deleteById(id);
        return true;
    }
}
