package MensajeriaTiempoReal;
import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
        System.out.println(observer + " subscrito.");
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
        System.out.println(observer + " des-subscrito.");
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}