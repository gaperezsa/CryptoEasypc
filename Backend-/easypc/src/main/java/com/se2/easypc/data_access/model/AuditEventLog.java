package com.se2.easypc.data_access.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table( name = "auditeventlog" )
public class AuditEventLog {//Build class definition

    //Build attributes
    @Column(name = "id_log")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLog;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_event")
    private AuditEvent auditLog;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Column
    private String detail;

    @Column
    private String clientIp;


    public Long getIdAuditEventLog() {//priceSL getter
		return idLog;
	}
	public void setIdAuditEventLog(Long id) {//priceSL setter
		this.idLog = id;
    }

    public Date getDate() {//priceSL getter
		return date;
	}
	public void setDate(Date date) {//priceSL setter
		this.date= date;
    }

    public User getUser() {//priceSL getter
		return user;
	}
	public void setUser(User user) {//priceSL setter
		this.user= user;
    }

    public String getDetail() {//priceSL getter
		return detail;
	}
	public void setDetail(String detail) {//priceSL setter
		this.detail= detail;
    }

    public String getClientIp() {//priceSL getter
		return clientIp;
	}
	public void setClientIp(String ip) {//priceSL setter
		this.clientIp= ip;
    }

    public AuditEventLog(Long idLog, Date date, User user, AuditEvent auditLog, String detail, String clientIp) {
        this.idLog = idLog;
        this.date = date;
        this.user = user;
        this.auditLog = auditLog;
        this.detail = detail;
        this.clientIp = clientIp;
    }


}