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
public class SmsModel {

   
    private String modemId;
    private String comPort;
    private int baudRate;
    private String model;
    private String simPin;
    private boolean isInbound;
    private boolean istOutbound;
    private String smscNumber;
    private String destinationPhone;
    private String messagesFrom; // only for bulk sms via smsc operator not GSM modem
    private String messages;
    private String deliveryType;
    private boolean isFlasMessages; // default is not flas.
    private String manufacture;

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

    public int getBaudRate() {
        return baudRate;
    }

    public void setBaudRate(int baudRate) {
        this.baudRate = baudRate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSimPin() {
        return simPin;
    }

    public void setSimPin(String simPin) {
        this.simPin = simPin;
    }

    public boolean getIsInbound() {
        return isInbound;
    }

    public void setIsInbound(boolean isInbound) {
        this.isInbound = isInbound;
    }

    public boolean getIstOutbound() {
        return istOutbound;
    }

    public void setIstOutbound(boolean istOutbound) {
        this.istOutbound = istOutbound;
    }

    public String getSmscNumber() {
        return smscNumber;
    }

    public void setSmscNumber(String smscNumber) {
        this.smscNumber = smscNumber;
    }

    public String getDestinationPhone() {
        return destinationPhone;
    }

    public void setDestinationPhone(String destinationPhone) {
        this.destinationPhone = destinationPhone;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public String getMessagesFrom() {
        return messagesFrom;
    }

    public void setMessagesFrom(String messagesFrom) {
        this.messagesFrom = messagesFrom;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public boolean getisFlasMessages() {
        return isFlasMessages;
    }

    public void setIsFlasMessages(boolean isFlasMessages) {
        this.isFlasMessages = isFlasMessages;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

}
