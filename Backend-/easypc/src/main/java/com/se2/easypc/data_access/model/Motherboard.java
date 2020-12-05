package com.se2.easypc.data_access.model;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;

@Entity
@Table( name = "Motherboard" )
public class Motherboard {//Motherboard class definition
    //Motherboard attributes    
    @Column(name="id_motherboard")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMotherboard;

    @Column(name="model")
    private String model;

    @Column(name = "price_sl")
    private Integer priceSL;
    @Column(name = "price_tauret")
    private Integer priceTauret;
    @Column(name = "price_cyp")
    private Integer priceCyP;
    @Column(name = "link_sl")
    private String linkSL;
    @Column(name = "link_tauret")
    private String linkTauret;
    @Column(name = "link_cyp")
    private String linkCyP;
    @Column(name = "link_picture")
    private String linkPicture;
    @Column(name = "link_benchmark")
    private String linkBenchmark;
    @Column(name="power")
    private Float power;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "CompatibleCPU", joinColumns = {@JoinColumn(name = "id_motherboard")},
    inverseJoinColumns = {@JoinColumn(name = "id_cpu")})
    private List<CPU> compatibleCPUs;

    public Long getIdMotherboard() {//idMotherboard getter
        return idMotherboard;
    }

    public void setIdMotherboard(Long idMotherboard) {//idMotherboard setter
        this.idMotherboard = idMotherboard;
    }

    public String getModel() {//model getter
        return model;
    }

    public void setModel(String model) {//model setter
        this.model = model;
    }

    public Float getPower() {//power getter
        return power;
    }

    public void setPower(Float power) {//power setter
        this.power = power;
    }

    
	public Integer getPriceSL() {//priceSL getter
		return priceSL;
	}
	public void setPriceSL(Integer priceSL) {//priceSL setter
		this.priceSL = priceSL;
	}
	public Integer getPriceTauret() {//priceTauret getter
		return priceTauret;
	}
	public void setPriceTauret(Integer priceTauret) {//priceTauret setter
		this.priceTauret = priceTauret;
	}
	public Integer getPriceCyP() {//priceCyP getter
		return priceCyP;
	}
	public void setPriceCyP(Integer priceCyP) {//priceCyP setter
		this.priceCyP = priceCyP;
	}
	public String getLinkSL() { //linkSL getter
		return linkSL;
	}
	public void setLinkSL(String linkSL) {//linkSL setter
		this.linkSL = linkSL;
	}
	public String getLinkTauret() {//linkTauret getter
		return linkTauret;
	}
	public void setLinkTauret(String linkTauret) {//linkTauret setter
		this.linkTauret = linkTauret;
	}
	public String getLinkCyP() {//linkCyP getter
		return linkCyP;
	}
	public void setLinkCyP(String linkCyP) {//linkCyP setter
		this.linkCyP = linkCyP;
	}
	public String getLinkPicture() {//linkPicture getter
		return linkPicture;
	}
	public void setLinkPicture(String linkPicture) {//linkPicture setter
		this.linkPicture = linkPicture;
	}

    public List<CPU> getCompatibleCPUs() {//CompatibleCPU getter
        return compatibleCPUs;
    }

    public void setCompatibleCPUs(List<CPU> compatibleCPUs) {//compatibleCPU setter
        this.compatibleCPUs = compatibleCPUs;
    }

    public String getLinkBenchmark() {//linkBenchmark getter
        return linkBenchmark;
    }

    public void setLinkBenchmark(String linkBenchmark) {//linkBenchmark setter
        this.linkBenchmark = linkBenchmark;
    }

    public int getPrice(){
		int ret = Integer.MAX_VALUE;
		if( priceSL != null ) ret = Integer.min( ret , priceSL.intValue() );
		if( priceCyP != null ) ret = Integer.min( ret , priceCyP.intValue() );
		if( priceTauret != null ) ret = Integer.min( ret , priceTauret.intValue() );
		if( ret == Integer.MAX_VALUE ) return 0;
		return ret;
	}

}
