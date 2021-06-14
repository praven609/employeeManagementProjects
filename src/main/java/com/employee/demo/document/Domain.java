package com.employee.demo.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document
public class Domain {

    @Id
    private Integer Id;
    private String domainName;
    private String domainDescription;
    private Date createdDate;
    private Date updatedDate;
    private Integer departmentId;
    private Boolean isActive;

    public Domain(Integer id, String domainName, String domainDescription, Date createdDate, Date updatedDate, Integer departmentId, Boolean isActive) {
        Id = id;
        this.domainName = domainName;
        this.domainDescription = domainDescription;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.departmentId = departmentId;
        this.isActive = isActive;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getDomainDescription() {
        return domainDescription;
    }

    public void setDomainDescription(String domainDescription) {
        this.domainDescription = domainDescription;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
