package com.se2.easypc.data_access.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.Column;

@Entity
@Table( name = "CPU" )
public class CPU {//CPU class definition
    //CPU attributes
    @Column(name = "id_cpu")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCPU;

    @Column
    private String model;

    @Column
    private Float power;

    @Column
    private Integer cores;

    @Column
    private Float speed;

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

    @JsonIgnore
    @ManyToMany(mappedBy = "compatibleCPUs" )
    private List<Motherboard> compatibleMotherboards;

    public Long getIdCPU() {//idCPU getter
        return idCPU;
    }

    public void setIdCPU(Long idCPU) {//idCPU setter
        this.idCPU = idCPU;
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

    public Integer getCores() {//cores getter
        return cores;
    }

    public void setCores(Integer cores) {//cores setter
        this.cores = cores;
    }

    public Float getSpeed() {//speed getter
        return speed;
    }

    public void setSpeed(Float speed) {//speed setter
        this.speed = speed;
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

    public List<Motherboard> getCompatibleMotherboards() { //compatibleMotherboard getter
        return compatibleMotherboards;
    }

    public void setCompatibleMotherboards(List<Motherboard> compatibleMotherboard) {//compatibleMotherboard setter
        this.compatibleMotherboards = compatibleMotherboard;
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
