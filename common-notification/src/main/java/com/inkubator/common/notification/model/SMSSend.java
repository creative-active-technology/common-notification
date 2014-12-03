/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkubator.common.notification.model;

import java.io.Serializable;

/**
 *
 * @author Deni Husni FR
 */
public class SMSSend implements Serializable{
    private String from;
    private String destination;
    private String content;
    private Double pricePerSms;
    private String modemId;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getPricePerSms() {
        return pricePerSms;
    }

    public void setPricePerSms(Double pricePerSms) {
        this.pricePerSms = pricePerSms;
    }

    public String getModemId() {
        return modemId;
    }

    public void setModemId(String modemId) {
        this.modemId = modemId;
    }
    
    
    
}
