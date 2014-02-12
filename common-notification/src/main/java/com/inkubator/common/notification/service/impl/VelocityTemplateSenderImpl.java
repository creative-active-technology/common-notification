/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkubator.common.notification.service.impl;


import com.inkubator.common.notification.model.VelocityTempalteModel;
import com.inkubator.common.notification.service.VelocityTemplateSender;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.mail.internet.MimeMessage;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 *
 * @author Deni Husni FR
 */
public class VelocityTemplateSenderImpl implements VelocityTemplateSender {

    private JavaMailSender javaMailSender;
    private VelocityEngine velocityEngine;

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
        
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    @Override
    public void sendMail(final VelocityTempalteModel velocityTempalteModel, final Map mapToSend) throws Exception {
        MimeMessagePreparator mimeMessagePreparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mm) throws Exception {
                MimeMessageHelper messages;
                if (velocityTempalteModel.getFileToAttach().isEmpty()) {
                    messages = new MimeMessageHelper(mm);
                } else {
                    messages = new MimeMessageHelper(mm, true);
                }
                messages.setTo(velocityTempalteModel.getTo());
                messages.setFrom(velocityTempalteModel.getFrom());
                messages.setCc(velocityTempalteModel.getCc());
                messages.setBcc(velocityTempalteModel.getBcc());
                messages.setSubject(velocityTempalteModel.getSubject());
                messages.setSentDate(new Date());
                if (!(velocityTempalteModel.getFileToAttach().isEmpty())) {
                    List<File> fileToAttach = velocityTempalteModel.getFileToAttach();
                    for (File file : fileToAttach) {
                        messages.addAttachment(file.getName(), file);
                    }
                }
                if (!(velocityTempalteModel.getInputStreamToAttach().isEmpty())) {
                    List<InputStreamSource> inputStreamToAttach = velocityTempalteModel.getInputStreamToAttach();
                    for (InputStreamSource inputStreamSource : inputStreamToAttach) {
                        messages.addAttachment(inputStreamSource.toString(), inputStreamSource);
                    }
                }
                String text = VelocityEngineUtils.mergeTemplateIntoString(
                        velocityEngine, velocityTempalteModel.getTemplatePath(), mapToSend);
                messages.setText(text, true);
            }
        };
        this.javaMailSender.send(mimeMessagePreparator);
    }
}
