package com.patrones.u2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class NotifierFactory {
    private static final Map<String, Supplier<Notifier>> REGISTRY = new HashMap<>(); // [cite: 155]

    static {
        // Registro inicial [cite: 157]
        REGISTRY.put("email", EmailNotifier::new); // [cite: 158]
        REGISTRY.put("sms", SmsNotifier::new); // [cite: 159]
        REGISTRY.put("push", PushNotifier::new); // [cite: 161]
    }

    public static void register(String type, Supplier<Notifier> factory) {
        REGISTRY.put(type.toLowerCase(), factory); // [cite: 169]
    }

    public static Notifier create(String type) {
        Supplier<Notifier> factory = REGISTRY.get(type.toLowerCase()); // [cite: 178]
        if (factory == null) {
            throw new IllegalArgumentException("Tipo no registrado: " + type); // [cite: 179]
        }
        return factory.get(); // [cite: 184]
    }
}