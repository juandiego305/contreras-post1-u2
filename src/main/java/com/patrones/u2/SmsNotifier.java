package com.patrones.u2;
public class SmsNotifier implements Notifier {
    public String channel() { return "SMS"; } // [cite: 128]
    public void send(String recipient, String message) {
        NotificationLogger.INSTANCE.log(channel(), recipient, message); // [cite: 130]
    }
}