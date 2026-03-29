package com.patrones.u2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton (variante enum): gestor de logs de notificaciones.
 * Una sola instancia en toda la aplicacion thread-safe por diseno de la JVM.
 */
public enum NotificationLogger {
    INSTANCE; // [cite: 61, 62]

    private final List<String> entries = new ArrayList<>(); // [cite: 63]
    private static final DateTimeFormatter FMT = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // [cite: 64, 65]

    public void log(String channel, String recipient, String message) {
        String entry = String.format("[%s] [%s] -> %s: %s",
            LocalDateTime.now().format(FMT),
            channel,
            recipient,
            message); // [cite: 67-71]
        entries.add(entry); // [cite: 72]
        System.out.println(entry); // [cite: 73]
    }

    public List<String> getEntries() {
        return List.copyOf(entries); // [cite: 79]
    }

    public void printAll() {
        System.out.println("\n=== Historial de Notificaciones ==="); // [cite: 82]
        entries.forEach(System.out::println); // [cite: 83]
        System.out.println("Total: " + entries.size() + " notificaciones"); // [cite: 84, 85, 87]
    }
}