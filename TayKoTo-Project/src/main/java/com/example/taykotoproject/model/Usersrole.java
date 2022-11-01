package com.example.taykotoproject.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Usersrole {
    private long id;
    private Long roleId;
    private Long userId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Role_Id")
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "User_Id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usersrole usersrole = (Usersrole) o;
        return id == usersrole.id && Objects.equals(roleId, usersrole.roleId) && Objects.equals(userId, usersrole.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleId, userId);
    }
}
