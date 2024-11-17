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
