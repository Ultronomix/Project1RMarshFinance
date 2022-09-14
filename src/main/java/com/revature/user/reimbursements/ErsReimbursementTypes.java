package com.revature.user.reimbursements;

import java.util.Objects;

public class ErsReimbursementTypes {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErsReimbursementTypes that)) return false;
        return Objects.equals(getTypeId(), that.getTypeId()) && Objects.equals(getType(), that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTypeId(), getType());
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String typeId;

    String type;


    @Override
    public String toString() {
        return "ErsReimbursementTypes{" +
                "typeId='" + typeId + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
