/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkubator.common.notification.service;


import com.inkubator.common.notification.model.VelocityTempalteModel;
import java.util.Map;

/**
 *
 * @author Deni Husni FR
 */
public interface VelocityTemplateSender {
    public void sendMail(VelocityTempalteModel velocityTempalteModel, Map mapToSend) throws Exception;
}
