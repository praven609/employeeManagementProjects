package com.employee.demo.io.employee;

public class activateResponse {
    private STATUS_VALUES status;
    public enum STATUS_VALUES {
        SUCCESS,
        EMPLOYEE_ALREADY_ACTIVATED,
        INTERNAL_SERVER_ERROR,
        NO_EMPLOYEE_EXISTS_WITH_SPECIFIED_ID,
        FAILED,
    }

    public STATUS_VALUES getStatus() {
        return status;
    }

    public void setStatus(STATUS_VALUES status) {
        this.status = status;
    }
}
