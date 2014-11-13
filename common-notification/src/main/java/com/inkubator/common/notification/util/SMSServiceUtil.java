/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkubator.common.notification.util;

import com.inkubator.common.notification.NotificationConstant;
import com.inkubator.common.notification.model.SmsModel;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.smslib.IOutboundMessageNotification;
import org.smslib.OutboundMessage;
import org.smslib.SMSLibException;
import org.smslib.Service;
import org.smslib.modem.SerialModemGateway;

/**
 *
 * @author Deni Husni FR Can manage by Spring
 */
public class SMSServiceUtil {

    private static final Logger LOGGER = Logger.getLogger(SMSServiceUtil.class);
    private SerialModemGateway gateway;
    private String modemId;
    private String comId;
    private int baudRate;
    private String manufacture;
    private String modelName;
    private String pinNumber;
    private boolean inBound;
    private boolean outBound;
    private String smscNumber;

    public void initialisasi() {
//        Must only one gate way per port number
        LOGGER.info("Oppening Gateway");
        try {
            if (gateway == null) {
                OutboundNotification outboundNotification = new OutboundNotification();
                gateway = new SerialModemGateway(modemId, comId, baudRate, manufacture, modelName);
                Service.getInstance().setOutboundMessageNotification(outboundNotification);
                gateway.setInbound(inBound);
                gateway.setOutbound(outBound);
                gateway.setSimPin(pinNumber);
                gateway.setSmscNumber(smscNumber);
                Service.getInstance().addGateway(gateway);
                Service.getInstance().startService();
                OutboundMessage msg = new OutboundMessage("+6287887051607", "Test UP");
                msg.setFlashSms(false);
                Service.getInstance().sendMessage(msg);
            }

            LOGGER.info("Gateway Running");
        } catch (Exception ex) {
            LOGGER.error(ex, ex);
        }
    }

//    public SMSServiceUtil() {
//        LOGGER.info("Oppening Gateway");
//        try {
//            if (gateway == null) {
//                OutboundNotification outboundNotification = new OutboundNotification();
//                gateway = new SerialModemGateway(modemId, comId, baudRate, manufacture, modelName);
//                Service.getInstance().setOutboundMessageNotification(outboundNotification);
//                gateway.setInbound(inBound);
//                gateway.setOutbound(outBound);
//                gateway.setSimPin(pinNumber);
//                gateway.setSmscNumber(smscNumber);
//                Service.getInstance().addGateway(gateway);
//                Service.getInstance().startService();
//            }
//
//            LOGGER.info("Gateway Running");
//        } catch (SMSLibException | IOException | InterruptedException ex) {
//            LOGGER.error(ex, ex);
//        }
//
//    }
    public static void sendSMSOutBound(SmsModel model) throws Exception {
        LOGGER.info("Send SMS Begin BY Static and Closs Gateway only for direct purfose");
        OutboundNotification outboundNotification = new OutboundNotification();
        SerialModemGateway gateway = new SerialModemGateway(model.getModemId(), model.getComPort(), model.getBaudRate(), model.getManufacture(), model.getModel());
        gateway.setInbound(model.getIsInbound());
        gateway.setOutbound(model.getIstOutbound());
        gateway.setSimPin(model.getSimPin());
        gateway.setSmscNumber(model.getSmscNumber());
        Service.getInstance().setOutboundMessageNotification(outboundNotification);
        Service.getInstance().addGateway(gateway);
        Service.getInstance().startService();
        OutboundMessage msg = new OutboundMessage(model.getDestinationPhone(), model.getMessages());
        msg.setFlashSms(model.getisFlasMessages());
        if (model.getDeliveryType()
                .equals(NotificationConstant.SYNCRONOUS)) {
            Service.getInstance().sendMessage(msg);
        }
        if (model.getDeliveryType()
                .equals(NotificationConstant.A_SYNCRONOUS)) {
            Service.getInstance().queueMessage(msg);
        }
        LOGGER.info("Send SMS Success");
        Service.getInstance().stopService();
    }

    public void setGateway(SerialModemGateway gateway) {
        this.gateway = gateway;
    }

    public void setModemId(String modemId) {
        this.modemId = modemId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public void setBaudRate(int baudRate) {
        this.baudRate = baudRate;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }

    public void setInBound(boolean inBound) {
        this.inBound = inBound;
    }

    public void setOutBound(boolean outBound) {
        this.outBound = outBound;
    }

    public void setSmscNumber(String smscNumber) {
        this.smscNumber = smscNumber;

    }

    public static class OutboundNotification implements IOutboundMessageNotification {

        @Override
        public void process(org.smslib.AGateway gateway, OutboundMessage msg) {
            LOGGER.info("Outbound handler called from Gateway " + gateway.getGatewayId());
            LOGGER.info(msg);
        }

    }

    public void close() {
        try {
            Service.getInstance().stopService();
        } catch (SMSLibException | IOException | InterruptedException ex) {
            LOGGER.error(ex, ex);
        }
    }
}
