/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkubator.common.notification.util;

import com.inkubator.common.notification.NotificationConstant;
import com.inkubator.common.notification.model.SmsModel;
import org.apache.log4j.Logger;
import org.smslib.IOutboundMessageNotification;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.modem.SerialModemGateway;

/**
 *
 * @author Deni Husni FR
 */
public class SMSServiceUtil {

    private static final Logger LOGGER = Logger.getLogger(SMSServiceUtil.class);

    public static void sendSMSOutBound(SmsModel model) throws Exception {
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
        if (model.getDeliveryType().equals(NotificationConstant.SYNCRONOUS)) {
            Service.getInstance().sendMessage(msg);
        }
        if (model.getDeliveryType().equals(NotificationConstant.A_SYNCRONOUS)) {
            Service.getInstance().queueMessage(msg);
        }
        LOGGER.info("Send SMS Success");
        Service.getInstance().stopService();
    }

    public static class OutboundNotification implements IOutboundMessageNotification {

        @Override
        public void process(org.smslib.AGateway gateway, OutboundMessage msg) {
            LOGGER.info("Outbound handler called from Gateway "+gateway.getGatewayId());
            LOGGER.info(msg);
        }

    }
}
