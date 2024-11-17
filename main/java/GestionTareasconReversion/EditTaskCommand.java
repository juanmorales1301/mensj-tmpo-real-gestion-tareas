package GestionTareasconReversion;

public class EditTaskCommand implements Command {
    private TaskManager taskManager;
    private String oldTaskName;
    private String newTaskName;

    public EditTaskCommand(TaskManager taskManager, String oldTaskName, String newTaskName) {
        this.taskManager = taskManager;
        this.oldTaskName = oldTaskName;
        this.newTaskName = newTaskName;
    }

    @Override
    public void execute() {
        taskManager.editTask(oldTaskName, newTaskName);
    }

    @Override
    public void undo() {
        taskManager.undoEditTask(oldTaskName, newTaskName);
    }
}