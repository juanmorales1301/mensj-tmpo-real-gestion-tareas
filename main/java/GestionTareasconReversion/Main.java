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