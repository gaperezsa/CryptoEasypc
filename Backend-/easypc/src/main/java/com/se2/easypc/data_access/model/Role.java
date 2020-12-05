package com.se2.easypc.data_access.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table( name = "easypc.role" )
public class Role {//Role class definition

    public static final Long ROLE_CLIENT = (long)1;
    public static final Long ROLE_ADMIN = (long)2;

    //Role attributes
    @Column(name="id_role")
    @Id
    private Long idRole;

    @Column(name="role_name")
    private String roleName;

    @JsonIgnore
    @ManyToMany( mappedBy = "roles" )
    private List<User> users;

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
