package com.se2.easypc.data_access.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "Build" )
public class Build {//Build class definition

    //Build attributes
    @Column(name = "id_build")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBuild;

    @Column
    private Date date;
    
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_mouse")
    private Mouse mouse;

    @ManyToOne
    @JoinColumn(name = "id_keyboard")
    private Keyboard keyboard;

    @ManyToOne
    @JoinColumn(name = "id_monitor")
    private Monitor monitor;

    @ManyToOne
    @JoinColumn(name = "id_motherboard")
    private Motherboard motherboard;

    @ManyToOne
    @JoinColumn(name = "id_cpu")
    private CPU cpu;

    @ManyToOne
    @JoinColumn(name = "id_gpu")
    private GPU gpu;

    @ManyToOne
    @JoinColumn(name = "id_ram")
    private RAM ram;

    @ManyToOne
    @JoinColumn(name = "id_cooling")
    private Cooling cooling;

    @ManyToOne
    @JoinColumn(name = "id_ssd")
    private SSD ssd;

    @ManyToOne
    @JoinColumn(name = "id_hdd")
    private HDD hdd;

    @ManyToOne
    @JoinColumn(name = "id_powersupply")
    private PowerSupply powerSupply;

    @ManyToOne
    @JoinColumn(name = "id_case")
    private Case caseObj;

    public Long getIdBuild() {//idBuild getter
        return idBuild;
    }

    public void setIdBuild(Long idBuild) {//idBuild setter
        this.idBuild = idBuild;
    }

    public Date getDate() {//date getter
        return date;
    }

    public void setDate(Date date) {//date setter
        this.date = date;
    }

    public User getUser() {//user getter
        return user;
    }

    public void setUser(User user) {//user setter
        this.user = user;
    }

    public Mouse getMouse() {//mouse getter
        return mouse;
    }

    public void setMouse(Mouse mouse) {//mouse setter
        this.mouse = mouse;
    }

    public Keyboard getKeyboard() {//keyboard getter
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {//keyboard setter
        this.keyboard = keyboard;
    }

    public Monitor getMonitor() {//monitor getter
        return monitor;
    }

    public void setMonitor(Monitor monitor) {//monitor setter
        this.monitor = monitor;
    }

    public Motherboard getMotherboard() {//motherboard getter
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {//motherboard setter
        this.motherboard = motherboard;
    }

    public CPU getCpu() {//cpu getter
        return cpu;
    }

    public void setCpu(CPU cpu) {//cpu setter
        this.cpu = cpu;
    }

    public GPU getGPU() {//cpu getter
        return gpu;
    }

    public void setGPU(GPU gpu) {//gpu setter
        this.gpu = gpu;
    }

    public RAM getRam() {//ram getter
        return ram;
    }

    public void setRam(RAM ram) {//ram setter
        this.ram = ram;
    }

    public Cooling getCooling() {//cooling getter
        return cooling;
    }

    public void setCooling(Cooling cooling) {//cooling setter
        this.cooling = cooling;
    }

    public SSD getSsd() {//ssd getter
        return ssd;
    }

    public void setSsd(SSD ssd) {//ssd setter
        this.ssd = ssd;
    }

    public HDD getHdd() {//hdd getter
        return hdd;
    }

    public void setHdd(HDD hdd) {//hdd setter
        this.hdd = hdd;
    }

    public PowerSupply getPowerSupply() {//powerSupply getter
        return powerSupply;
    }

    public void setPowerSupply(PowerSupply powerSupply) {//powerSupply setter
        this.powerSupply = powerSupply;
    }

    public Case getCaseObj() {//caseObj getter
        return caseObj;
    }

    public void setCaseObj(Case caseObj) {//caseObj setter
        this.caseObj = caseObj;
    }

    public Build(){}

    public Build(Motherboard motherboard, CPU cpu, GPU gpu, RAM ram, Cooling cooling,
            SSD ssd, HDD hdd, PowerSupply powerSupply, Case caseObj) {
        this.motherboard = motherboard;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.cooling = cooling;
        this.ssd = ssd;
        this.hdd = hdd;
        this.powerSupply = powerSupply;
        this.caseObj = caseObj;
    }

    public int getPrice(){
        int ret = 0;
        ret += caseObj.getPrice();
        ret += cooling.getPrice();
        ret += cpu.getPrice();   
        ret += gpu.getPrice();
        if( hdd != null ) ret += hdd.getPrice();
        if( keyboard != null ) ret += keyboard.getPrice();
        if( monitor != null ) ret += monitor.getPrice();
        ret += motherboard.getPrice();
        if( mouse != null ) ret += mouse.getPrice();
        ret += powerSupply.getPrice();
        ret += ram.getPrice();
        if( ssd != null ) ret += ssd.getPrice();
        return ret;
    }

    public Build(Long idBuild, Date date, User user, Mouse mouse, Keyboard keyboard, Monitor monitor,
            Motherboard motherboard, CPU cpu, GPU gpu, RAM ram, Cooling cooling, SSD ssd, HDD hdd,
            PowerSupply powerSupply, Case caseObj) {
        this.idBuild = idBuild;
        this.date = date;
        this.user = user;
        this.mouse = mouse;
        this.keyboard = keyboard;
        this.monitor = monitor;
        this.motherboard = motherboard;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.cooling = cooling;
        this.ssd = ssd;
        this.hdd = hdd;
        this.powerSupply = powerSupply;
        this.caseObj = caseObj;
    }
}
