## 🚀Sistema de Notificaciones - Patrones Creacionales

Este proyecto implementa un sistema de gestión de notificaciones para una aplicación de e-commerce, aplicando patrones de diseño para garantizar la escalabilidad y la integridad de los datos.
Desarrollado como parte del laboratorio de la Unidad 2 de la asignatura patrones de diseño .

## 🛠️Tecnologías Utilizadas

Lenguaje: Java 17 o superior.


Gestor de Dependencias: Apache Maven 3.8+.


Control de Versiones: Git / GitHub

##  🧠Análisis de Patrones ImplementadosEl sistema resuelve dos necesidades críticas mediante patrones de diseño específicos:
1. Singleton (Variante Enum) 🛡️Problema que resuelve: La necesidad de un gestor de logs único en toda la aplicación que registre de forma centralizada cada notificación enviada, evitando la duplicidad de archivos o inconsistencias en los datos.Por qué esta variante: Se utilizó un enum (NotificationLogger.INSTANCE) porque garantiza que la instancia sea thread-safe por diseño de la JVM, siendo la forma más robusta de implementar el patrón en Java moderno.
2. Factory Method (Registro Dinámico) 🏭Problema que resuelve: Proporcionar un mecanismo extensible para crear distintos tipos de notificadores (Email, SMS, Push) sin que el código de negocio tenga que conocer o instanciar las clases concretas.Principio OCP (Open/Closed): Gracias al uso de un Map y Supplier<Notifier>, la fábrica permite registrar nuevos canales de comunicación (como Slack) en tiempo de ejecución sin necesidad de modificar el código fuente de la Factory original.

## 📁 Estructura del Proyecto
<img width="294" height="338" alt="image" src="https://github.com/user-attachments/assets/1563e021-03e6-4284-b390-b0346899002a" />

## 🚀 Instrucciones de Ejecución
Para compilar y ejecutar el sistema desde la raíz del proyecto, asegúrese de tener configurado su entorno y ejecute los siguientes comandos:

##  Compilar el proyecto

```bash 
mvn compile
```

## Ejecutar la demostración

```bash
mvn exec:java -Dexec.mainClass="com.patrones.u2.Main"
```
## Salida esperada
<img width="1150" height="856" alt="image" src="https://github.com/user-attachments/assets/656c8667-ba47-4641-8726-7cb57564d91c" />
