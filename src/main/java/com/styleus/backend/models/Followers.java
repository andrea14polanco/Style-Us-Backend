package com.styleus.backend.models;

import java.util.Date;

public class Followers {

    private Long id;
    private Long users_id;
    private Long state_id;
    private Long FollowersStates_id;
    private Date created_at;
    private Date updated_at;

    public Followers(Long id, Long users_id, Long state_id, Long followersStates_id) {
        this.id = Long.valueOf(id);
        this.users_id = Long.valueOf(users_id);
        this.state_id = Long.valueOf(state_id);
        this.FollowersStates_id = Long.valueOf(followersStates_id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(Long users_id) {
        this.users_id = users_id;
    }

    public Long getState_id() {
        return state_id;
    }

    public void setState_id(Long state_id) {
        this.state_id = state_id;
    }

    public Long getFollowersStates_id() {
        return FollowersStates_id;
    }

    public void setFollowersStates_id(Long followersStates_id) {
        FollowersStates_id = followersStates_id;
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

    @Override
    public String toString() {
        return "Followers{" +
                "id=" + id +
                ", users_id=" + users_id +
                ", state_id=" + state_id +
                ", FollowersStates_id=" + FollowersStates_id +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
