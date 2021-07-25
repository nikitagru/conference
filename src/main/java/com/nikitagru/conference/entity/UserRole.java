package com.nikitagru.conference.entity;

import com.nikitagru.conference.entity.id.UserRoleId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "users_roles")
@IdClass(UserRoleId.class)
public class UserRole {
    @Id
    private long user_id;
    @Id
    private long role_id;
}
