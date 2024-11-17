package MensajeriaTiempoReal;

public class Device implements Observer {
    private String name;

    public Device(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Dispositivo " + name + " recibió el mensaje: " + message);
    }

    @Override
    public String toString() {
        return "Dispositivo{" + "nombre='" + name + '\'' + '}';
    }
}