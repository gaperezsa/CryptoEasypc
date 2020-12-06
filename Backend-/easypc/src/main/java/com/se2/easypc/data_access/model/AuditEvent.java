package com.se2.easypc.data_access.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "auditevent" )
public class AuditEvent {

    @Column(name = "id_event")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAuditLog;

    @Column
    private String name;

    public Long getIdAuditLog() {//priceSL getter
		return idAuditLog;
	}
	public void setIdAuditLog(Long id) {//priceSL setter
		this.idAuditLog = id;
    }

    public String getName() {//priceSL getter
		return name;
	}
	public void setName(String name) {//priceSL setter
		this.name = name;
    }

    public AuditEvent() {

    }
    
}