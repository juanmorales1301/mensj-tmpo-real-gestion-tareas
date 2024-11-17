package GestionTareasconReversion;

public class CompleteTaskCommand implements Command {
    private TaskManager taskManager;
    private String taskName;

    public CompleteTaskCommand(TaskManager taskManager, String taskName) {
        this.taskManager = taskManager;
        this.taskName = taskName;
    }

    @Override
    public void execute() {
        taskManager.completeTask(taskName);
    }

    @Override
    public void undo() {
        taskManager.undoCompleteTask(taskName);
    }
}