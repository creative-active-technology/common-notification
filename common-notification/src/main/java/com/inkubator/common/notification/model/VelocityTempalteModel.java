/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkubator.common.notification.model;

/**
 *
 * @author CSL
 */
public class VelocityTempalteModel extends NotificationModel{
    private String templatePath;
    private String headerInfo;
    private String footerInfo;

    public String getHeaderInfo() {
        return headerInfo;
    }

    public void setHeaderInfo(String headerInfo) {
        this.headerInfo = headerInfo;
    }

    public String getFooterInfo() {
        return footerInfo;
    }

    public void setFooterInfo(String footerInfo) {
        this.footerInfo = footerInfo;
    }
    

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }
    
}
