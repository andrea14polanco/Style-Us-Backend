package com.styleus.backend.models;

import java.util.Date;

public class Like {

    private Long id;
    private Long actionstate_id;
    private Date created_at;
    private Date updated_at;
    private Long users_id;
    private Long posts_id;

    public Like(Long id, Long actionstate_id, Long users_id, Long posts_id){

        this.id = Long.valueOf(id);
        this.actionstate_id = Long.valueOf(actionstate_id);
        this.users_id = Long.valueOf(users_id);
        this.posts_id = Long.valueOf(posts_id);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActionstate_id() {
        return actionstate_id;
    }

    public void setActionstate_id(Long actionstate_id) {
        this.actionstate_id = actionstate_id;
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

    public Long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(Long users_id) {
        this.users_id = users_id;
    }

    public Long getPosts_id() {
        return posts_id;
    }

    public void setPosts_id(Long posts_id) {
        this.posts_id = posts_id;
    }
}
