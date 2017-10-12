package com.styleus.backend.models;
import java.util.Date;

public class Comments {

    private Long id;
    private Long post_id;
    private Long user_id;
    private String comment_body;
    private Long actionstate_id;
    private Long comment_id;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;

    public Comments(int id, int post_id, int user_id, String comment_body, int actionstate_id, int comment_id) {
        this.id = Long.valueOf(id);
        this.post_id = Long.valueOf(post_id);
        this.user_id = Long.valueOf(user_id);
        this.comment_body = comment_body;
        this.actionstate_id = Long.valueOf(actionstate_id);
        this.comment_id = Long.valueOf(comment_id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getComment_body() {
        return comment_body;
    }

    public void setComment_body(String comment_body) {
        this.comment_body = comment_body;
    }

    public Long getActionstate_id() {
        return actionstate_id;
    }

    public void setActionstate_id(Long actionstate_id) {
        this.actionstate_id = actionstate_id;
    }

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
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
        return "Comments{" +
                "id=" + id +
                ", post_id=" + post_id +
                ", user_id=" + user_id +
                ", comment_body='" + comment_body + '\'' +
                ", actionstate_id=" + actionstate_id +
                ", comment_id=" + comment_id +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", deleted_at=" + deleted_at +
                '}';
    }
}
