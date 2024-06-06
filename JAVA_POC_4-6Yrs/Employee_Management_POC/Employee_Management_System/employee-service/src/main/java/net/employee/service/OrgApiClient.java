package net.employee.service;

import net.employee.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "ORGANIZATION-SERVICE")
public interface OrgApiClient {
    @GetMapping("/api/organization/getall")
    public List<OrganizationDto> getAllOrganization();
}
