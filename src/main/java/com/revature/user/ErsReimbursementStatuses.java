package com.revature.user;

import java.util.Objects;

public class ErsReimbursementStatuses {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErsReimbursementStatuses that)) return false;
        return Objects.equals(getStatusId(), that.getStatusId()) && Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatusId(), getStatus());
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    String statusId;

    String status;


    @Override
    public String toString() {
        return "ErsReimbursementStatuses{" +
                "statusId='" + statusId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
