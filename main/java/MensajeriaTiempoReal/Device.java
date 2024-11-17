package MensajeriaTiempoReal;

public class Device implements Observer {
    private String name;

    public Device(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Device " + name + " received message: " + message);
    }

    @Override
    public String toString() {
        return "Device{" + "name='" + name + '\'' + '}';
    }
}