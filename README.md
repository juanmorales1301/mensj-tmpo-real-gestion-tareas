# Patrones de Diseño Aplicados

Este repositorio contiene la implementación de dos patrones de diseño aplicados a problemas específicos:
1. **Sistema de Mensajes Instantáneos** utilizando el **Patrón Observer**.
2. **Sistema de Gestión de Tareas** utilizando el **Patrón Command**.

Cada patrón fue seleccionado y desarrollado para resolver problemas particulares, maximizando el desacoplamiento, la flexibilidad y la extensibilidad del sistema.


---

## **Sistema de Mensajes Instantáneos (Patrón Observer)**

### **Descripción**
La empresa requiere una aplicación de mensajería en tiempo real que permita a los usuarios comunicarse desde múltiples dispositivos. Cada vez que llega un nuevo mensaje, todos los dispositivos del usuario deben recibir notificaciones. Para mantener la flexibilidad y desacoplar la lógica de notificación, se implementa el **Patrón Observer**.

### **Objetivos Cubiertos**
1. **Notificación en Tiempo Real**: Los dispositivos reciben notificaciones al instante.
2. **Desacoplamiento**: El sistema principal no necesita conocer detalles específicos de los dispositivos.
3. **Flexibilidad**: Se pueden añadir o eliminar dispositivos durante la ejecución sin modificar la lógica principal.



## **Descripción del Patrón Observer**

El patrón **Observer** establece una relación "uno a muchos" entre objetos. Cuando el objeto observado (Subject) cambia de estado, todos los objetos suscriptores (Observers) son notificados automáticamente.

### **Características principales**
- **Notificación en Tiempo Real**: Cada dispositivo suscrito recibe actualizaciones al instante.
- **Desacoplamiento**: El objeto principal no necesita saber detalles específicos de los observadores.
- **Flexibilidad**: Los observadores pueden añadirse o eliminarse dinámicamente sin alterar la lógica principal.

---

## **Diagrama UML**

### **Diagrama de Clases**

![MensajeriaTiempoReal.svg](assets%2FMensajeriaTiempoReal.svg)

### **Descripción del Diagrama**
- **Subject**:
    - Mantiene una lista de observadores y los notifica cuando ocurre un cambio.
- **Observer**:
    - Define la interfaz para recibir actualizaciones.
- **Device**:
    - Representa un dispositivo suscrito, como un teléfono, tableta o laptop.

---

## **Estructura del Proyecto**

### **Clases Implementadas**
1. **Subject**:
    - Administra los observadores suscritos y se asegura de que reciban notificaciones.
2. **Observer**:
    - Define el contrato para que los dispositivos reciban mensajes.
3. **Device**:
    - Implementa la interfaz `Observer` y representa un dispositivo concreto.

### **Flujo de Trabajo**
1. **Suscripción**: Los dispositivos se suscriben al `Subject`.
2. **Notificación**: Cuando llega un nuevo mensaje, el `Subject` notifica a todos los dispositivos suscritos.
3. **Desuscripción**: Los dispositivos pueden dejar de recibir notificaciones eliminándose del `Subject`.

---

## **Ejemplo de Código**

```java
package MensajeriaTiempoReal;

public class Main {
    public static void main(String[] args) {
        Subject messageService = new Subject();

        Device phone = new Device("Phone");
        Device laptop = new Device("Laptop");
        Device tablet = new Device("Tablet");

        // Se suscribe a los dispositivos
        messageService.subscribe(phone);
        messageService.subscribe(laptop);

        // Envia notificación a todos los dispositivos
        messageService.notifyObservers("You have a new message!");

        // Se des subscribe del dispositivo phone
        messageService.unsubscribe(phone);

        // Envia otra notificación
        messageService.notifyObservers("Another message has arrived!");

        // Agrega una nueva suscripción
        messageService.subscribe(tablet);
        messageService.notifyObservers("Tablet joined the notifications!");
    }
}
```

---

# Gestión de Tareas con Reversión (Patrón Command)

### **Descripción**
El sistema permite a los usuarios gestionar tareas mediante acciones como crear, editar, eliminar y completar. Es crucial mantener un historial de acciones realizadas para permitir la reversión en caso necesario. Para esto, se implementa el **Patrón Command**.

### **Objetivos Cubiertos**
1. **Desacoplamiento**: Separamos el invocador (`TaskInvoker`) del ejecutor de las acciones (`TaskManager`).
2. **Extensibilidad**: Es fácil agregar nuevas operaciones sin modificar el código existente.
3. **Reversibilidad**: Mantenemos un historial de comandos para deshacer las acciones.

## **Descripción del Patrón Command**

El patrón **Command** encapsula una solicitud como un objeto, permitiendo parametrizar otros objetos con diferentes solicitudes, encolar solicitudes o registrar su historial para posibles reversiones. Este patrón desacopla el emisor de una solicitud del objeto que la ejecuta.

### **Características principales**
- **Desacoplamiento**: El invocador no necesita saber cómo se realiza la acción, solo invoca el comando.
- **Extensibilidad**: Fácil de agregar nuevas operaciones sin modificar el código existente.
- **Reversibilidad**: Permite deshacer acciones ejecutadas gracias a un historial.

---

## **Diagrama UML**

### **Diagrama de Clases**

![GestionTareasconReversion.svg](assets%2FGestionTareasconReversion.svg)

### **Descripción del Diagrama**
- La clase `Command` es la interfaz base que define los métodos `execute()` y `undo()`.
- Las clases concretas como `CreateTaskCommand` encapsulan acciones específicas sobre tareas.
- `TaskManager` es la clase que ejecuta las acciones reales sobre las tareas.
- `TaskInvoker` mantiene un historial de comandos y permite deshacer el último comando ejecutado.

---

## **Estructura del Proyecto**

### **Clases Implementadas**
1. **Command**: Interfaz base para todos los comandos.
2. **CreateTaskCommand, EditTaskCommand, DeleteTaskCommand, CompleteTaskCommand**: Clases concretas que encapsulan acciones específicas.
3. **TaskManager**: Clase que contiene la lógica para gestionar tareas.
4. **TaskInvoker**: Clase responsable de ejecutar y deshacer comandos.

### **Flujo de Trabajo**
1. Un comando concreto encapsula la acción solicitada.
2. El invocador (`TaskInvoker`) ejecuta el comando.
3. La acción se realiza a través del `TaskManager`.
4. El comando ejecutado se guarda en un historial para revertirlo si es necesario.

---

## **Código de Ejemplo de Uso**

```java
package GestionTareasconReversion;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        TaskInvoker taskInvoker = new TaskInvoker();

        Command createTask = new CreateTaskCommand(taskManager, "Task 1");
        Command editTask = new EditTaskCommand(taskManager, "Task 1", "Updated Task 1");
        Command deleteTask = new DeleteTaskCommand(taskManager, "Updated Task 1");
        Command completeTask = new CompleteTaskCommand(taskManager, "Task 1");

        // Ejecutar comandos
        taskInvoker.executeCommand(createTask);
        taskInvoker.executeCommand(editTask);
        taskInvoker.executeCommand(deleteTask);
        taskInvoker.executeCommand(completeTask);

        // Deshacer comando
        taskInvoker.undoLastCommand();
        taskInvoker.undoLastCommand();
    }
}
```
