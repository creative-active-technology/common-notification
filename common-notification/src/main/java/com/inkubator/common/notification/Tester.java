/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkubator.common.notification;

import com.inkubator.common.notification.model.VelocityTempalteModel;
import com.inkubator.common.notification.service.VelocityTemplateSender;
import com.inkubator.common.notification.util.EmailServiceUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CSL
 */
public class Tester {

    /**
     * Sample Penggunaan Nitification Email
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for (int i = 1; i < 2; i++) {
            VelocityTempalteModel vtm = new VelocityTempalteModel();
            vtm.setFrom("sam.erp@ciptasrigatilestari.co.id");
            List<String> toSend = new ArrayList<>();
            List<String> toSentCC = new ArrayList<>();
            List<String> toSentBCC = new ArrayList<>();
            toSentCC.add("rizal2_dhfr@yahoo.com");
            toSend.add("rizal2_dhfr@yahoo.com");
            vtm.setTo(toSend.toArray(new String[toSend.size()]));
            vtm.setCc(toSentCC.toArray(new String[toSentCC.size()]));
            vtm.setBcc(toSentCC.toArray(new String[toSentBCC.size()]));
            vtm.setSubject("Test");
            vtm.setTemplatePath("email_user_confirmation.vm");
//        File f = new File("C:/arsetup.log");
//        File g = new File("C:/debug1214.txt");
            List<File> sdfdsf = new ArrayList<>();
//        sdfdsf.add(f);
//        sdfdsf.add(g);
            vtm.setFileToAttach(sdfdsf);
            Map maptosed = new HashMap();
            maptosed.put("headerInfo", "Hahhahahaahhaahh");
            VelocityTemplateSender vts = (VelocityTemplateSender) EmailServiceUtil.getService("velocityTemplateSender");
            try {
                vts.sendMail(vtm, maptosed);
                System.out.println("suskese");
            } catch (Exception ex) {
                Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
