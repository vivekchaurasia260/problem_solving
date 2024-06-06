package net.deaprtment.service.impl;

import net.deaprtment.dto.DepartmentDTO;
import net.deaprtment.entity.Department;
import net.deaprtment.exception.DeptCodeAlreadyExistException;
import net.deaprtment.exception.ResourceNotFoundException;
import net.deaprtment.repository.DepartmentRepository;
import net.deaprtment.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

        Department department = modelMapper.map(departmentDTO,Department.class);
        Optional<Department> deptByCode = departmentRepository.findByDepartmentCode(department.getDepartmentCode());
        if(deptByCode.isPresent()){
            throw new DeptCodeAlreadyExistException("Department Code already exist", department.getDepartmentCode());
        }

        Department savedDepartment = departmentRepository.save(department);

        return modelMapper.map(savedDepartment, DepartmentDTO.class);
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String departmentCode) {
        Department departmentByCode = departmentRepository.findByDepartmentCode(departmentCode).orElseThrow(
                ()->new ResourceNotFoundException("DEPARTMENT","DEPARTMENT-CODE",departmentCode)
        );
        return modelMapper.map(departmentByCode, DepartmentDTO.class);
    }

    @Override
    public DepartmentDTO updateDepartment(String deptCode,DepartmentDTO departmentDTO) {
        Department department = departmentRepository.findByDepartmentCode(deptCode).orElseThrow(
                ()->new ResourceNotFoundException("DEPARTMENT","DEPARTMENT_CODE",deptCode)
        );
        department.setDepartmentName(departmentDTO.getDepartmentName());
        department.setDepartmentDescription(departmentDTO.getDepartmentDescription());
        Department savedDept = departmentRepository.save(department);
        return modelMapper.map(savedDept,DepartmentDTO.class);
    }

    @Override
    public List<DepartmentDTO> getAllDepartment() {
        List<Department> allDepartment = departmentRepository.findAll();
        return allDepartment.stream().map(dept -> modelMapper.map(dept, DepartmentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteDepartment(String departmentCode) {
        Department byDepartmentCode = departmentRepository.findByDepartmentCode(departmentCode).orElseThrow(
                ()->new ResourceNotFoundException("DEPARTMENT","DEPARTMENT-CODE",departmentCode)
        );
        departmentRepository.delete(byDepartmentCode);
    }
}
