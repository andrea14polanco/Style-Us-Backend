package com.styleus.backend.models;

import java.util.Date;

public class Notification {

    private Long id;
    private Long sender_id;
    private Long receiver_id;
    private Long reference_id;
    private Boolean status;
    private String body;
    private Long action_type;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    public Notification(Long id, Long sender_id, Long receiver_id, Long reference_id, Boolean status, String body, Long action_type) {
        this.id = id;
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
        this.reference_id = reference_id;
        this.status = status;
        this.body = body;
        this.action_type = action_type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSender_id() {
        return sender_id;
    }

    public void setSender_id(Long sender_id) {
        this.sender_id = sender_id;
    }

    public Long getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(Long receiver_id) {
        this.receiver_id = receiver_id;
    }

    public Long getReference_id() {
        return reference_id;
    }

    public void setReference_id(Long reference_id) {
        this.reference_id = reference_id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getAction_type() {
        return action_type;
    }

    public void setAction_type(Long action_type) {
        this.action_type = action_type;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Date deleted_at) {
        this.deleted_at = deleted_at;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", sender_id=" + sender_id +
                ", receiver_id=" + receiver_id +
                ", reference_id=" + reference_id +
                ", status=" + status +
                ", body='" + body + '\'' +
                ", action_type=" + action_type +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", deleted_at=" + deleted_at +
                '}';
    }
}
