package net.orgranization.service.impl;

import net.orgranization.dto.OrganizationDto;
import net.orgranization.entity.Organization;
import net.orgranization.exception.OrgCodeAlreadyExistException;
import net.orgranization.exception.ResourceNotFoundException;
import net.orgranization.repository.OrganizationRepository;
import net.orgranization.service.OrganizationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;
    private ModelMapper modelMapper;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository, ModelMapper modelMapper) {
        this.organizationRepository = organizationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization mappedOrg = modelMapper.map(organizationDto, Organization.class);
        Optional<Organization> byOrganizationCode = organizationRepository.findByOrganizationCode(mappedOrg.getOrganizationCode());
        if (byOrganizationCode.isPresent()){
            throw new OrgCodeAlreadyExistException("Organization", mappedOrg.getOrganizationCode());
        }
        Organization savedOrg = organizationRepository.save(mappedOrg);
        return modelMapper.map(savedOrg,OrganizationDto.class);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode).
                orElseThrow(()->
                new ResourceNotFoundException("Organization","OrganizationCode",organizationCode));
        return modelMapper.map(organization,OrganizationDto.class);
    }

    @Override
    public OrganizationDto updateOrganization(String organizationCode, OrganizationDto organizationDto) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode).orElseThrow(
                ()->new ResourceNotFoundException("Organization","OrganizationCode",organizationCode)
        );
        organization.setOrganizationName(organizationDto.getOrganizationName());
        organization.setOrganizationDescription(organizationDto.getOrganizationDescription());
        Organization updatedOrganization = organizationRepository.save(organization);
        return modelMapper.map(updatedOrganization,OrganizationDto.class);
    }

    @Override
    public List<OrganizationDto> getAllOrganization() {
        return organizationRepository.findAll().stream().map(org->modelMapper.map(org,OrganizationDto.class)).collect(Collectors.toList());

    }

    @Override
    public void deleteOrganization(String organizationCode) {
        Organization byOrganizationCode = organizationRepository.findByOrganizationCode(organizationCode).orElseThrow(
                ()->new ResourceNotFoundException("Organization","OrganizationCode",organizationCode)
        );
        organizationRepository.delete(byOrganizationCode);

    }
}
