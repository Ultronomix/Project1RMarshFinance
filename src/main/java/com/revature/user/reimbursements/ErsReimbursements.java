package com.revature.user.reimbursements;

import java.util.Objects;

public class ErsReimbursements {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErsReimbursements that)) return false;
        return Objects.equals(getReimbId(), that.getReimbId()) && Objects.equals(getAmount(), that.getAmount()) && getSubmitted().equals(that.getSubmitted()) && Objects.equals(getResolved(), that.getResolved()) && getDescription().equals(that.getDescription()) && Objects.equals(getReceipt(), that.getReceipt()) && Objects.equals(getPaymentId(), that.getPaymentId()) && getAuthorId().equals(that.getAuthorId()) && Objects.equals(getResolverId(), that.getResolverId()) && Objects.equals(getStatusId(), that.getStatusId()) && Objects.equals(getTypeId(), that.getTypeId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReimbId(), getAmount(), getSubmitted(), getResolved(), getDescription(), getReceipt(), getPaymentId(), getAuthorId(), getResolverId(), getStatusId(), getTypeId());
    }

    public String getReimbId() {
        return reimbId;
    }

    public void setReimbId(String reimbId) {
        this.reimbId = reimbId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSubmitted() {
        return submitted;
    }

    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }

    public String getResolved() {
        return resolved;
    }

    public void setResolved(String resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getResolverId() {
        return resolverId;
    }

    public void setResolverId(String resolverId) {
        this.resolverId = resolverId;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    String reimbId;

    String amount;

    String submitted;

    String resolved;

    String description;

    String receipt;

    String paymentId;

    String authorId;

    String resolverId;

    String statusId;

    String typeId;


    @Override
    public String toString() {
        return "ErsReimbursements{" +
                "reimbId='" + reimbId + '\'' +
                ", amount='" + amount + '\'' +
                ", submitted='" + submitted + '\'' +
                ", resolved='" + resolved + '\'' +
                ", description='" + description + '\'' +
                ", receipt='" + receipt + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", authorId='" + authorId + '\'' +
                ", resolverId='" + resolverId + '\'' +
                ", statusId='" + statusId + '\'' +
                ", typeId='" + typeId + '\'' +
                '}';
    }
}
