/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkubator.common.notification.model;

/**
 *
 * @author Deni Husni FR
 */
public class SerialGateWay {
    private String modemId;
    private String comPort;
    private Integer baudRate;
    private String manaufactur;
    private String modelName;
    private String pinNumber;
    private String smscNumber;
    private Boolean inBound;
    private Boolean outBound;

    public String getModemId() {
        return modemId;
    }

    public void setModemId(String modemId) {
        this.modemId = modemId;
    }

    public String getComPort() {
        return comPort;
    }

    public void setComPort(String comPort) {
        this.comPort = comPort;
    }

    public Integer getBaudRate() {
        return baudRate;
    }

    public void setBaudRate(Integer baudRate) {
        this.baudRate = baudRate;
    }

    public String getManaufactur() {
        return manaufactur;
    }

    public void setManaufactur(String manaufactur) {
        this.manaufactur = manaufactur;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }

    public String getSmscNumber() {
        return smscNumber;
    }

    public void setSmscNumber(String smscNumber) {
        this.smscNumber = smscNumber;
    }

    

    public Boolean getInBound() {
        return inBound;
    }

    public void setInBound(Boolean inBound) {
        this.inBound = inBound;
    }

    public Boolean getOutBound() {
        return outBound;
    }

    public void setOutBound(Boolean outBound) {
        this.outBound = outBound;
    }
    
    
    
}
