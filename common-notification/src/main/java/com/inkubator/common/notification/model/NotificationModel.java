/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkubator.common.notification.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.springframework.core.io.InputStreamSource;

/**
 *
 * @author Deni Husni FR
 */
public class NotificationModel {

    protected String subject;
    protected String from;
    protected String[] to;
    protected String[] cc;
    protected String[] bcc;
    protected String message;
    protected List<File> fileToAttach = new ArrayList<>();
    protected List<InputStreamSource> inputStreamToAttach = new ArrayList<>();

    public List<File> getFileToAttach() {
        return fileToAttach;
    }

    public void setFileToAttach(List<File> fileToAttach) {
        this.fileToAttach = fileToAttach;
    }

    public List<InputStreamSource> getInputStreamToAttach() {
        return inputStreamToAttach;
    }

    public void setInputStreamToAttach(List<InputStreamSource> inputStreamToAttach) {
        this.inputStreamToAttach = inputStreamToAttach;
    }
    
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public String[] getBcc() {
        return bcc;
    }

    public void setBcc(String[] bcc) {
        this.bcc = bcc;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
