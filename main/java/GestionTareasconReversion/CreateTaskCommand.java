package GestionTareasconReversion;

public class CreateTaskCommand implements Command {
    private TaskManager taskManager;
    private String taskName;

    public CreateTaskCommand(TaskManager taskManager, String taskName) {
        this.taskManager = taskManager;
        this.taskName = taskName;
    }

    @Override
    public void execute() {
        taskManager.createTask(taskName);
    }

    @Override
    public void undo() {
        taskManager.undoCreateTask(taskName);
    }
}