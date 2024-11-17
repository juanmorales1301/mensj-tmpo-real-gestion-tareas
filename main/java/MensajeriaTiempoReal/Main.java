package MensajeriaTiempoReal;

public class Main {
    public static void main(String[] args) {
        Subject messageService = new Subject();

        Device phone = new Device("Teléfono");
        Device laptop = new Device("Portátil");
        Device tablet = new Device("Tableta");

        // Se subscribe a los dispositivos
        messageService.subscribe(phone);
        messageService.subscribe(laptop);

        // Envia notificación a todos los dispositivos
        messageService.notifyObservers("¡Tienes un nuevo mensaje!");

        // Se des subscribe del dispositivo phone
        messageService.unsubscribe(phone);

        // Envia otra notificación
        messageService.notifyObservers("¡Ha llegado otro mensaje!");

        // Agrega una nueva suscripción
        messageService.subscribe(tablet);
        messageService.notifyObservers("¡La tableta se unió a las notificaciones!");
    }
}
