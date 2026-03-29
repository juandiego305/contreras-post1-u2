package com.patrones.u2;

/**
 * Product (interfaz): contrato de todo notificador.
 * El código cliente solo conoce esta interfaz.
 */
public interface Notifier {
    void send(String recipient, String message); // [cite: 107]
    String channel(); // [cite: 110]
}