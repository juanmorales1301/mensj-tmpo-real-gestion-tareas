package GestionTareasconReversion;

public class TaskManager {
    public void createTask(String taskName) {
        System.out.println("Task Created: " + taskName);
    }

    public void editTask(String oldTaskName, String newTaskName) {
        System.out.println("Task Edited: " + oldTaskName + " -> " + newTaskName);
    }

    public void deleteTask(String taskName) {
        System.out.println("Task Deleted: " + taskName);
    }

    public void completeTask(String taskName) {
        System.out.println("Task Completed: " + taskName);
    }

    public void undoCreateTask(String taskName) {
        System.out.println("Undo Create Task: " + taskName + " deleted.");
    }

    public void undoEditTask(String oldTaskName, String newTaskName) {
        System.out.println("Undo Edit Task: Restored " + oldTaskName);
    }

    public void undoDeleteTask(String taskName) {
        System.out.println("Undo Delete Task: " + taskName + " restored.");
    }

    public void undoCompleteTask(String taskName) {
        System.out.println("Undo Complete Task: " + taskName + " marked incomplete.");
    }
}