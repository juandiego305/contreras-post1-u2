package com.patrones.u2;
public class PushNotifier implements Notifier {
    public String channel() { return "PUSH"; } // [cite: 135]
    public void send(String recipient, String message) {
        NotificationLogger.INSTANCE.log(channel(), recipient, message); // [cite: 137]
    }
}