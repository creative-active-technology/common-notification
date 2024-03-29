/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkubator.common.notification.util;

import com.inkubator.common.notification.util.SMSServiceUtil.OutboundNotification;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.smslib.AGateway;
import org.smslib.AGateway.GatewayStatuses;
import org.smslib.AGateway.Protocols;
import org.smslib.GatewayException;
import org.smslib.ICallNotification;
import org.smslib.IGatewayStatusNotification;
import org.smslib.IInboundMessageNotification;
import org.smslib.IOrphanedMessageNotification;
import org.smslib.InboundMessage;
import org.smslib.InboundMessage.MessageClasses;
import org.smslib.Library;
import org.smslib.Message.MessageTypes;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.TimeoutException;
import org.smslib.modem.SerialModemGateway;

/**
 *
 * @author Deni Husni FR
 */
public class TestSMS {
//

    public void doIt() throws Exception {
        InboundNotification inboundNotification = new InboundNotification();
        // Create the notification callback method for inbound voice calls.
        CallNotification callNotification = new CallNotification();
        //Create the notification callback method for gateway statuses.
        GatewayStatusNotification statusNotification = new GatewayStatusNotification();
        OrphanedMessageNotification orphanedMessageNotification = new OrphanedMessageNotification();
        OutboundNotification outboundNotification = new OutboundNotification();
//        System.out.println("Example: Send message from a serial gsm modem.");
//        System.out.println(Library.getLibraryDescription());
//        System.out.println("Version: " + Library.getLibraryVersion());
        SerialModemGateway gateway = new SerialModemGateway("modem.com1", "COM8", 115200, "ZTE Corporation", "");
        gateway.setProtocol(Protocols.PDU);
        // Do we want the Gateway to be used for Inbound messages?
        gateway.setInbound(true);
        // Do we want the Gateway to be used for Outbound messages?
        gateway.setOutbound(true);
        // Let SMSLib know which is the SIM PIN.
        gateway.setSimPin("0000");
// Explicit SMSC address set is required for some modems.
// Below is for VODAFONE GREECE - be sure to set your own!
        gateway.setSmscNumber("+62818445009");
        Service.getInstance().setInboundMessageNotification(inboundNotification);
        Service.getInstance().setCallNotification(callNotification);
        Service.getInstance().setGatewayStatusNotification(statusNotification);
        Service.getInstance().setOrphanedMessageNotification(orphanedMessageNotification);
//        Service.getInstance().setOutboundMessageNotification(outboundNotification);
        gateway.getATHandler().setStorageLocations("SMME");
        Service.getInstance().addGateway(gateway);

        Service.getInstance().startService();

//        System.out.println();
//        System.out.println("Modem Information:");
//        System.out.println(" Manufacturer: " + gateway.getManufacturer());
//        System.out.println(" Model: " + gateway.getModel());
//        System.out.println(" Serial No: " + gateway.getSerialNo());
//        System.out.println(" SIM IMSI: " + gateway.getImsi());
//        System.out.println(" Signal Level: " + gateway.getSignalLevel() + " dBm");
//        System.out.println(" Battery Level: " + gateway.getBatteryLevel() + "%");
//        System.out.println();
// Send a message synchronously.
//        OutboundMessage msg = new OutboundMessage("6287887051607", "Hellosdsdsd from SMSLib... puteun ah lagi testing ... hehe!");
//        msg.setFrom("Deni Husni FR");
//        Service.getInstance().sendMessage(msg);
//        System.out.println(msg);
// Or, send out a WAP SI message.
//OutboundWapSIMessage wapMsg = new OutboundWapSIMessage("306974000000", new URL("http://www.smslib.org/"), "Visit SMSLib now!");
//Service.getInstance().sendMessage(wapMsg);
//System.out.println(wapMsg);
// You can also queue some asynchronous messages to see how the callbacks
// are called...
//msg = new OutboundMessage("309999999999", "Wrong number!");
//srv.queueMessage(msg, gateway.getGatewayId());
//msg = new OutboundMessage("308888888888", "Wrong number!");
//srv.queueMessage(msg, gateway.getGatewayId());
//        System.out.println("Now Sleeping - Hit <enter> to terminate.");
//        System.in.read();
//        System.out.println(" Sukses Send Messages");
//        List<InboundMessage> msgList = new ArrayList<InboundMessage>();
//        Service.getInstance().readMessages(msgList, MessageClasses.ALL);
//        for (InboundMessage msgs : msgList) {
//            if (msgs != null) {
//                System.out.println(msgs);
//                Service.getInstance().deleteMessage(msgs);
//            }
//
//        }
        System.in.read();
//        System.in.read();
        Service.getInstance().stopService();
    }

//    public void doIt() throws Exception {
//// Define a list which will hold the read messages.
//        List<InboundMessage> msgList;
//// Create the notification callback method for inbound & status report
//// messages.
//        InboundNotification inboundNotification = new InboundNotification();
//// Create the notification callback method for inbound voice calls.
//        CallNotification callNotification = new CallNotification();
////Create the notification callback method for gateway statuses.
//        GatewayStatusNotification statusNotification = new GatewayStatusNotification();
//        OrphanedMessageNotification orphanedMessageNotification = new OrphanedMessageNotification();
//        try {
//            System.out.println("Example: Read messages from a serial gsm modem.");
//            System.out.println(Library.getLibraryDescription());
//            System.out.println("Version: " + Library.getLibraryVersion());
//// Create the Gateway representing the serial GSM modem.
//            SerialModemGateway gateway = new SerialModemGateway("modem.com1", "COM8", 921600, "ZTE Corporation", "");
//// Set the modem protocol to PDU (alternative is TEXT). PDU is the default, anyway...
//            gateway.setProtocol(Protocols.PDU);
//// Do we want the Gateway to be used for Inbound messages?
//            gateway.setInbound(true);
//// Do we want the Gateway to be used for Outbound messages?
//            gateway.setOutbound(true);
//// Let SMSLib know which is the SIM PIN.
//            gateway.setSimPin("0000");
//// Set up the notification methods.
//            Service.getInstance().setInboundMessageNotification(inboundNotification);
//            Service.getInstance().setCallNotification(callNotification);
//            Service.getInstance().setGatewayStatusNotification(statusNotification);
//            Service.getInstance().setOrphanedMessageNotification(orphanedMessageNotification);
//// Add the Gateway to the Service object.
//            Service.getInstance().addGateway(gateway);
//// Similarly, you may define as many Gateway objects, representing
//// various GSM modems, add them in the Service object and control all of them.
//// Start! (i.e. connect to all defined Gateways)
//            Service.getInstance().startService();
//// Printout some general information about the modem.
//            System.out.println();
//            System.out.println("Modem Information:");
//            System.out.println(" Manufacturer: " + gateway.getManufacturer());
//            System.out.println(" Model: " + gateway.getModel());
//            System.out.println(" Serial No: " + gateway.getSerialNo());
//            System.out.println(" SIM IMSI: " + gateway.getImsi());
//            System.out.println(" Signal Level: " + gateway.getSignalLevel() + " dBm");
//            System.out.println(" Battery Level: " + gateway.getBatteryLevel() + "%");
//            System.out.println();
//// In case you work with encrypted messages, its a good time to declare your keys.
//// Create a new AES Key with a known key value.
//// Register it in KeyManager in order to keep it active. SMSLib will then automatically
//// encrypt / decrypt all messages send to / received from this number.
////            Service.getInstance().getKeyManager().registerKey("+306948494037", new AESKey(new SecretKeySpec("0011223344556677".getBytes(), "AES")));
//// Read Messages. The reading is done via the Service object and
//// affects all Gateway objects defined. This can also be more directed to a specific
//// Gateway - look the JavaDocs for information on the Service method calls.
//            msgList = new ArrayList<InboundMessage>();
//            Service.getInstance().readMessages(msgList, MessageClasses.ALL);
//            for (InboundMessage msg : msgList) {
//                System.out.println(msg);
//            }
//// Sleep now. Emulate real world situation and give a chance to the notifications
//// methods to be called in the event of message or voice call reception.
////            System.out.println("Now Sleeping - Hit <enter> to stop service.");
////            System.in.read();
////            System.in.read();
//        } catch (Exception e) {
//            e.printStackTrace();
////        } finally {
////            Service.getInstance().stopService();
//        }
//    }
    public class InboundNotification implements IInboundMessageNotification {

        public void process(AGateway gateway, MessageTypes msgType, InboundMessage msg) {
            if (msgType == MessageTypes.INBOUND) {
                try {
                    System.out.println(">>> New Inbound message detected from Gateway: " + gateway.getGatewayId());
                    System.out.println(" ini adalah messagenya " + msg.getText());
                    System.out.println(" ini adalah messagenya " + msg.getOriginator());
                    Service.getInstance().deleteMessage(msg);
                } catch (TimeoutException | GatewayException | IOException | InterruptedException ex) {
                    Logger.getLogger(TestSMS.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (msgType == MessageTypes.STATUSREPORT) {
                System.out.println(">>> New Inbound Status Report message detected from Gateway: " + gateway.getGatewayId());
            }
//            System.out.println(msg);
        }
    }

    public class CallNotification implements ICallNotification {

        public void process(AGateway gateway, String callerId) {
            System.out.println(">>> New call detected from Gateway: " + gateway.getGatewayId() + " : " + callerId);
        }
    }

    public class GatewayStatusNotification implements IGatewayStatusNotification {

        public void process(AGateway gateway, GatewayStatuses oldStatus, GatewayStatuses newStatus) {
            System.out.println(">>> Gateway Status change for " + gateway.getGatewayId() + ", OLD: " + oldStatus + " -> NEW: " + newStatus);
        }
    }

    public class OrphanedMessageNotification implements IOrphanedMessageNotification {

        public boolean process(AGateway gateway, InboundMessage msg) {
            System.out.println(">>> Orphaned message part detected from " + gateway.getGatewayId());
//            System.out.println(msg);
            // Since we are just testing, return FALSE and keep the orphaned message part.
            return false;
        }
    }
//    public class OutboundNotification implements IOutboundMessageNotification {
//
//        @Override
//        public void process(org.smslib.AGateway gateway, OutboundMessage msg) {
//            System.out.println("Outbound handler called from Gateway: " + gateway.getGatewayId());
//            System.out.println(msg);
//        }
//
//    }

    public static void main(String args[]) {
//        try {
        TestSMS app = new TestSMS();
        try {
            app.doIt();
        } catch (Exception e) {
            e.printStackTrace();
        }
//            SmsModel model = new SmsModel();
//            model.setBaudRate(115200);
//            model.setComPort("COM18");
//            model.setDeliveryType(NotificationConstant.SYNCRONOUS);
//            model.setDestinationPhone("087887051607");
//            model.setIsFlasMessages(false);
//            model.setIsInbound(true);
//            model.setIstOutbound(true);
//            model.setManufacture("WaveCom");
//            model.setModel("M1306B");
//            model.setModemId("modem1");
//            model.setSimPin("0000");
//            model.setSmscNumber("+62818445009");//XL 
////            Satelindo - SMSC Mentari dan Matrix = 62816124
////Telkomsel - SMSC Telkomsel = 6281100000
////Excelcom - SMSC XL = 62818445009
////Indosat - SMSC IM3 = 62855000000 
//            model.setMessages("Dear Mr Andi </br> Tolong di Approve. HR SYSTEM");
//            SMSServiceUtil.sendSMSOutBound(model);
////            model.setMessages("Dear Mr Andi </br> Tolong di Approve. HsfsdfdsfR SYSTEM");
////            mSServiceUtil.sendSMSOutBound(model);
//        } catch (Exception ex) {
//            Logger.getLogger(TestSMS.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }{
//        TestSMS app = new TestSMS();
//        try {
//            app.doIt();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//         try {
//            // TODO code application logic
//            
//            double a=9;
//            ScriptEngineManager mgr = new ScriptEngineManager();
//            ScriptEngine jsEngine = mgr.getEngineByName("JavaScript");
//            jsEngine.put("data", a);
//            
//            System.out.println("Nili nya" +jsEngine.eval("Math.max(5, 10)*data"));
//        } catch (ScriptException ex) {
//            Logger.getLogger(TestSMS.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
