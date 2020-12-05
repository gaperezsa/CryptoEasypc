package com.se2.easypc.pojo;

import java.sql.Date;
import com.se2.easypc.data_access.model.*;

public class BuildPOJO {

    private Long idBuild;

    private Date date;
    
    private UserPOJO user;

    private Mouse mouse;

    private Keyboard keyboard;

    private Monitor monitor;

    private Motherboard motherboard;

    private CPU cpu;

    private GPU gpu;

    private RAM ram;

    private Cooling cooling;

    private SSD ssd;

    private HDD hdd;

    private PowerSupply powerSupply;

    private Case caseObj;

    public BuildPOJO ( Build build ){
        this.user = new UserPOJO( build.getUser() );
        this.idBuild = build.getIdBuild();
        this.date = build.getDate();
        this.mouse = build.getMouse();
        this.keyboard = build.getKeyboard();
        this.monitor = build.getMonitor();
        this.motherboard = build.getMotherboard();
        this.cpu = build.getCpu();
        this.gpu = build.getGPU();
        this.ram = build.getRam();
        this.cooling = build.getCooling();
        this.ssd = build.getSsd();
        this.hdd = build.getHdd();
        this.powerSupply = build.getPowerSupply();
        this.caseObj = build.getCaseObj();
    }

    public BuildPOJO ( ){}

    public Build toBuild(){
        return new Build( this.idBuild , this.date , null , this.mouse , this.keyboard , this.monitor ,
                        this.motherboard , this.cpu , this.gpu , this.ram , this.cooling , this.ssd ,
                        this.hdd , this.powerSupply , this.caseObj);
    }

    public Long getIdBuild() {
        return idBuild;
    }

    public void setIdBuild(Long idBuild) {
        this.idBuild = idBuild;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserPOJO getUser() {
        return user;
    }

    public void setUser(UserPOJO user) {
        this.user = user;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public GPU getGpu() {
        return gpu;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Cooling getCooling() {
        return cooling;
    }

    public void setCooling(Cooling cooling) {
        this.cooling = cooling;
    }

    public SSD getSsd() {
        return ssd;
    }

    public void setSsd(SSD ssd) {
        this.ssd = ssd;
    }

    public HDD getHdd() {
        return hdd;
    }

    public void setHdd(HDD hdd) {
        this.hdd = hdd;
    }

    public PowerSupply getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(PowerSupply powerSupply) {
        this.powerSupply = powerSupply;
    }

    public Case getCaseObj() {
        return caseObj;
    }

    public void setCaseObj(Case caseObj) {
        this.caseObj = caseObj;
    }

}
