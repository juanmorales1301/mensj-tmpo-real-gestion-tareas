package GestionTareasconReversion;

public interface Command {
    void execute();
    void undo();
}