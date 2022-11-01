package com.example.taykotoproject.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Roles {
    private long roleId;
    private String roleName;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Role_Id")
    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "Role_Name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roles roles = (Roles) o;
        return roleId == roles.roleId && Objects.equals(roleName, roles.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName);
    }
}
