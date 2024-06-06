package net.employee.service;

import net.employee.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8888",value = "DEPARTMENT-SERVICE")
@FeignClient(value = "DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("/api/departments/getbycode/{department-code}")
    DepartmentDTO getDepartment(@PathVariable("department-code") String departmentCode);

    @GetMapping("/api/departments/getall")
    public List<DepartmentDTO> getALlDepartment();

}
