package com.patrones.u2;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Demo: Singleton + Factory Method ===\n");

        // 1. Demostración Singleton: misma instancia desde distintos contextos
        NotificationLogger logger1 = NotificationLogger.INSTANCE;
        NotificationLogger logger2 = NotificationLogger.INSTANCE;
        System.out.println("Misma instancia: " + (logger1 == logger2));

        // 2. Demostración Factory Method: crear notificadores por tipo
        Notifier email = NotifierFactory.create("email");
        Notifier sms = NotifierFactory.create("sms");
        Notifier push = NotifierFactory.create("push");

        // 3. Enviar notificaciones (el Singleton registra todas)
        email.send("cliente@mail.com", "Su pedido #1001 fue confirmado");
        sms.send("+57-300-0000001", "Pedido #1001 confirmado");
        push.send("device-token-abc123", "Nuevo pedido listo para enviar");

        // 4. Demostrar OCP: Registrar un tipo nuevo en tiempo de ejecucion
        NotifierFactory.register("slack", () -> new Notifier() {
            public String channel() { return "SLACK"; }
            public void send(String r, String m) {
                NotificationLogger.INSTANCE.log(channel(), r, m);
            }
        });

        // Probar el nuevo tipo dinámico
        NotifierFactory.create("slack").send("#pedidos", "Pedido #1001 procesado");

        // 5. Imprimir historial (el Singleton tiene TODOS los registros)
        NotificationLogger.INSTANCE.printAll();
    }
}