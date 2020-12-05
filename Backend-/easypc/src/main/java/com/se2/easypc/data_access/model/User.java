package com.se2.easypc.data_access.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.Column;

@Entity
@Table( name = "User" )
public class User {//User class definition
    //User attributes
    @Column(name="id_user")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    //@JsonIgnore
    @ManyToMany( fetch = FetchType.EAGER )
    @JoinTable( name = "user_role" , joinColumns = { @JoinColumn(name = "id_user") } ,
                inverseJoinColumns = { @JoinColumn( name = "id_role" ) } )
    private List <Role> roles;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Build> builds;

    public Long getIdUser() {//idUser getter
        return idUser;
    }

    public void setIdUser(Long idUser) {//idUser setter
        this.idUser = idUser;
    }

    public String getUsername() {//username getter
        return username;
    }

    public void setUsername(String username) {//username setter
        this.username = username;
    }

    public String getPassword() {//password getter
        return password;
    }

    public void setPassword(String password) {//password setter
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Build> getBuilds() {
        return builds;
    }

    public void setBuilds(List<Build> builds) {
        this.builds = builds;
    }
}
