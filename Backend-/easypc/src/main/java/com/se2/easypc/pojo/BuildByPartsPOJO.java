package com.se2.easypc.pojo;

public class BuildByPartsPOJO {

    private Long idMouse;
    private Long idKeyboard;
    private Long idMonitor;
    private Long idMotherboard;
    private Long idCPU;
    private Long idGPU;
    private Long idRAM;
    private Long idCooling;
    private Long idSSD;
    private Long idHDD;
    private Long idPowerSupply;
    private Long idCase;

    public BuildByPartsPOJO(Long idMouse, Long idKeyboard, Long idMonitor, Long idMotherboard, Long idCPU, Long idGPU,
            Long idRAM, Long idCooling, Long idSSD, Long idHDD, Long idPowerSupply, Long idCase) {
        this.idMouse = idMouse;
        this.idKeyboard = idKeyboard;
        this.idMonitor = idMonitor;
        this.idMotherboard = idMotherboard;
        this.idCPU = idCPU;
        this.idGPU = idGPU;
        this.idRAM = idRAM;
        this.idCooling = idCooling;
        this.idSSD = idSSD;
        this.idHDD = idHDD;
        this.idPowerSupply = idPowerSupply;
        this.idCase = idCase;
    }

    public BuildByPartsPOJO(){}

    public Long getIdMouse() {
        return idMouse;
    }

    public void setIdMouse(Long idMouse) {
        this.idMouse = idMouse;
    }

    public Long getIdKeyboard() {
        return idKeyboard;
    }

    public void setIdKeyboard(Long idKeyboard) {
        this.idKeyboard = idKeyboard;
    }

    public Long getIdMonitor() {
        return idMonitor;
    }

    public void setIdMonitor(Long idMonitor) {
        this.idMonitor = idMonitor;
    }

    public Long getIdMotherboard() {
        return idMotherboard;
    }

    public void setIdMotherboard(Long idMotherboard) {
        this.idMotherboard = idMotherboard;
    }

    public Long getIdCPU() {
        return idCPU;
    }

    public void setIdCPU(Long idCPU) {
        this.idCPU = idCPU;
    }

    public Long getIdGPU() {
        return idGPU;
    }

    public void setIdGPU(Long idGPU) {
        this.idGPU = idGPU;
    }

    public Long getIdRAM() {
        return idRAM;
    }

    public void setIdRAM(Long idRAM) {
        this.idRAM = idRAM;
    }

    public Long getIdCooling() {
        return idCooling;
    }

    public void setIdCooling(Long idCooling) {
        this.idCooling = idCooling;
    }

    public Long getIdSSD() {
        return idSSD;
    }

    public void setIdSSD(Long idSSD) {
        this.idSSD = idSSD;
    }

    public Long getIdHDD() {
        return idHDD;
    }

    public void setIdHDD(Long idHDD) {
        this.idHDD = idHDD;
    }

    public Long getIdPowerSupply() {
        return idPowerSupply;
    }

    public void setIdPowerSupply(Long idPowerSupply) {
        this.idPowerSupply = idPowerSupply;
    }

    public Long getIdCase() {
        return idCase;
    }

    public void setIdCase(Long idCase) {
        this.idCase = idCase;
    }
 
}
