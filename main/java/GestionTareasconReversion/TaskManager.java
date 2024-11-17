package GestionTareasconReversion;

public class TaskManager {
    public void createTask(String taskName) {
        System.out.println("Tarea creada: " + taskName);
    }

    public void editTask(String oldTaskName, String newTaskName) {
        System.out.println("Tarea editada: " + oldTaskName + " -> " + newTaskName);
    }

    public void deleteTask(String taskName) {
        System.out.println("Tarea eliminada: " + taskName);
    }

    public void completeTask(String taskName) {
        System.out.println("Tarea completada: " + taskName);
    }

    public void undoCreateTask(String taskName) {
        System.out.println("Deshacer Crear Tarea: " + taskName + " eliminada.");
    }

    public void undoEditTask(String oldTaskName, String newTaskName) {
        System.out.println("Deshacer Editar Tarea: Restaurada " + oldTaskName);
    }

    public void undoDeleteTask(String taskName) {
        System.out.println("Deshacer Eliminar Tarea: " + taskName + " restaurada.");
    }

    public void undoCompleteTask(String taskName) {
        System.out.println("Deshacer Completar Tarea: " + taskName + " marcada como incompleta.");
    }
}