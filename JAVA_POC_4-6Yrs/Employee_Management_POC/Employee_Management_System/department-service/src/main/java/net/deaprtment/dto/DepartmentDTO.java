package net.deaprtment.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;

@Schema(
        description = "DepartmentDTO model information"
)
public class DepartmentDTO {

    private Long id;
    @Schema(
            description = "Department Name"
    )
    @NotEmpty(message = "Department name should not be empty")
    private String departmentName;
    @Schema(
            description = "Department description"
    )
    @NotEmpty(message = "Department name should not be empty")
    private String departmentDescription;
    @Schema(
            description = "Department Code"
    )
    @NotEmpty(message = "Department name should not be empty")
    private String departmentCode;

    public DepartmentDTO(Long id, String departmentName, String departmentDescription, String departmentCode) {
        this.id = id;
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
        this.departmentCode = departmentCode;
    }

    public DepartmentDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", departmentDescription='" + departmentDescription + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                '}';
    }
}
