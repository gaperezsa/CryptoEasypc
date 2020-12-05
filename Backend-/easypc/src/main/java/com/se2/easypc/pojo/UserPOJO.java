package com.se2.easypc.pojo;

import java.util.List;

import com.se2.easypc.data_access.model.Role;
import com.se2.easypc.data_access.model.User;

public class UserPOJO {
    
    private Long idUser;

    private String username;

    private List <Role> roles;

    public UserPOJO( User user ){
        this.idUser = user.getIdUser();
        this.username = user.getUsername();
        this.roles = user.getRoles();
    }

    public UserPOJO() {}

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

    public List<Role> getRoles(){
        return roles;
    }

    public void setRoles(List<Role> roles){
        this.roles = roles;
    }

    @Override
    public boolean equals( Object obj){
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        UserPOJO user = (UserPOJO) obj;
        if( user.getIdUser() == this.getIdUser() && user.getUsername() == this.getUsername() && user.getRoles() == this.getRoles()){
            return true;
        }
        return false;

    }

}
