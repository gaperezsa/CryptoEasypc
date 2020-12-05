package com.se2.easypc.data_access.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
@Entity
@Table(name="HDD")
public class HDD {//HDD class definition
	//HDD attributes
    @Column(name = "id_hdd")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHDD;
    @Column
    private String model;
    @Column
    private Float power;
    @Column
    private Integer memory;
    @Column
    private String speed;
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

	public Long getIdHDD() {//idHDD getter
		return idHDD;
	}

	public void setIdHDD(Long idHDD) {//idHDD setter
		this.idHDD = idHDD;
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

	public Integer getMemory() {//memory getter
		return memory;
	}

	public void setMemory(Integer memory) {//memery setter
		this.memory = memory;
	}

	public String getSpeed() {//speed getter
		return speed;
	}

	public void setSpeed(String speed) {//speed setter
		this.speed = speed;
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
