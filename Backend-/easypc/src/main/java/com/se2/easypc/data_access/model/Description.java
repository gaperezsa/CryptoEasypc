package com.se2.easypc.data_access.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "description" )
public class Description { // Description class definition
    
    @Column(name = "id_description")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDescription;

    @Column(name = "part_name")
    private String partName;

    @Column(name = "part_description")
    private String partDescription;

    public Long getIdDescription() {
        return idDescription;
    }

    public void setIdDescription(Long idDescription) {
        this.idDescription = idDescription;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

}
