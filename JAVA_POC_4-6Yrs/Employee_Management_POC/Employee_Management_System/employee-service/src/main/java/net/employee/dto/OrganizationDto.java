package net.employee.dto;

import java.time.LocalDateTime;

public class OrganizationDto {

    private Long id;

    private String organizationName;

    private String organizationDescription;

    private String organizationCode;

    private LocalDateTime createdDate;

    public OrganizationDto(Long id, String organizationName, String organizationDescription, String organizationCode, LocalDateTime createdDate) {
        this.id = id;
        this.organizationName = organizationName;
        this.organizationDescription = organizationDescription;
        this.organizationCode = organizationCode;
        this.createdDate = createdDate;
    }

    public OrganizationDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationDescription() {
        return organizationDescription;
    }

    public void setOrganizationDescription(String organizationDescription) {
        this.organizationDescription = organizationDescription;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "OrganizationDto{" +
                "id=" + id +
                ", organizationName='" + organizationName + '\'' +
                ", organizationDescription='" + organizationDescription + '\'' +
                ", organizationCode='" + organizationCode + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
