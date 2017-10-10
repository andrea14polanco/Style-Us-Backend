package com.styleus.backend.models;

import java.security.PublicKey;
import java.util.Date;

public class Post {

    private Long id;
    private String body;
    private Long likes_count;
    private Long comments_count;
    private String photo_type;
    private Date posted_at;
    private Date updated_at;
    private Date deleted_at;
    //Atributos de otras clases
    private Long user_id;
    private Long actionstate_id;
    private Long clothe_id;

    public Post(int id, String body, int likes_count, int comments_count, String photo_type, Long user_id, int actionstate_id, int clothe_id) {
        this.id = Long.valueOf(id);
        this.body = body;
        this.likes_count = Long.valueOf(likes_count);
        this.comments_count = Long.valueOf(comments_count);
        this.photo_type = photo_type;
        this.user_id = user_id;
        this.actionstate_id = Long.valueOf(actionstate_id);
        this.clothe_id = Long.valueOf(clothe_id);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(Long likes_count) {
        this.likes_count = likes_count;
    }

    public Long getComments_count() {
        return comments_count;
    }

    public void setComments_count(Long comments_count) {
        this.comments_count = comments_count;
    }

    public String getPhoto_type() {
        return photo_type;
    }

    public void setPhoto_type(String photo_type) {
        this.photo_type = photo_type;
    }

    public Date getPosted_at() {
        return posted_at;
    }

    public void setPosted_at(Date posted_at) {
        this.posted_at = posted_at;
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

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getActionstate_id() {
        return actionstate_id;
    }

    public void setActionstate_id(Long actionstate_id) {
        this.actionstate_id = actionstate_id;
    }

    public long getClothe_id() {
        return clothe_id;
    }

    public void setClothe_id(long clothe_id) {
        this.clothe_id = clothe_id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", likes_count=" + likes_count +
                ", comments_count=" + comments_count +
                ", photo_type='" + photo_type + '\'' +
                ", posted_at=" + posted_at +
                ", updated_at=" + updated_at +
                ", deleted_at=" + deleted_at +
                ", user_id=" + user_id +
                ", actionstate_id=" + actionstate_id +
                ", clothe_id=" + clothe_id +
                '}';
    }
}
