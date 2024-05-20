import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Task [] taskList = new Task[100];
        Scanner scanner = new Scanner(System.in);
        boolean isItGoing = true;
        do {
            System.out.println("What do you want do do?");
            System.out.println("1. Add task to do");
            System.out.println("2. Check tasks");
            System.out.println("3. Exit");

            int userAnswer = scanner.nextInt();
            //scanner.nextLine();

            switch (userAnswer){
                case 1:
                    AddingTask(scanner, taskList);
                    break;
                case 2:
                    CheckingTasks(taskList, scanner);
                    break;
                case 3:
                    isItGoing = false;
                    break;
                default:break;
            }
            System.out.println('\n');
        }while(isItGoing);
        System.out.println("end");
    }

    public static void AddingTask (Scanner s, Task [] tasks){
        int index = 0;
        for (Task task : tasks){
            if(task == null){
                System.out.println("Enter a name of this task: ");
                s.nextLine();
                String taskName = s.nextLine();
                System.out.println("Enter a status of this task: ");
                System.out.println("1. TO_DO");
                System.out.println("2. DOING");
                System.out.println("3. DONE");
                int status = s.nextInt();
                //s.nextLine();

                switch (status){
                    case 1: tasks [index] = new Task(taskName,Task.Status.TO_DO, index);break;
                    case 2: tasks [index] = new Task(taskName, Task.Status.DOING, index);break;
                    case 3: tasks [index] = new Task(taskName, Task.Status.DONE, index);break;
                    default:break;
                }
                break;
            }
            index++;
        }
    }
    public static void CheckingTasks(Task [] tasks, Scanner s){
        System.out.println("Tasks with which status would you like to see?");
        System.out.println("1. To do tasks");
        System.out.println("2. Doing tasks");
        System.out.println("3. Done tasks");
        System.out.println("4. All tasks");
        int choice = s.nextInt();
        //s.nextLine();

        switch(choice){
            case 1: ShowTasks(tasks, s, Task.Status.TO_DO, false);
                    break;
            case 2: ShowTasks(tasks, s, Task.Status.DOING, false);
                    break;
            case 3: ShowTasks(tasks, s, Task.Status.DONE, false);
                    break;
            case 4: ShowTasks(tasks, s, Task.Status.ALL, true);
        }
    }

    public static void ShowTasks (Task [] tasks, Scanner s, Task.Status status, boolean areAllSelected){
        Task [] avaibleTasks = new Task[100];
        int indexInc = 0;
        System.out.println(status + ":");
        for (Task task : tasks){
            if (task != null && (task.getStatus() == status || areAllSelected)){
                avaibleTasks [indexInc] = task;
                System.out.println((indexInc + 1) + ". " + task.getName());
                indexInc++;
            }
        }

        waitABit();

        System.out.println("Which task do you want to modify, please enter a number of that task");
        System.out.println("If you don't want to modify, just enter any number up to 100 ");
        int modifyChoice = s.nextInt() - 1;
        //s.nextLine();

        Task modifyingTask = null;
        if(avaibleTasks [modifyChoice] != null){
            for (Task currentTask : tasks){
                if (currentTask != null && currentTask.getName() == avaibleTasks[modifyChoice].getName()){
                    modifyingTask = currentTask;
                }
            }

            System.out.println("What do you want to do with it?: ");
            System.out.println("1. Change name");
            System.out.println("2. Change status");
            System.out.println("3. Delete");
            System.out.println("If nothing then enter any other number: ");
            modifyChoice = s.nextInt();
            //s.nextLine();

            switch (modifyChoice){
                case 1:
                    System.out.println("Please enter new name: ");
                    s.nextLine();
                    String newName = s.nextLine();
                    modifyingTask.setName(newName);
                    break;
                case 2:
                    System.out.println("To which one?: ");
                    System.out.println("1. To do");
                    System.out.println("2. Doing");
                    System.out.println("3. Done");

                    modifyChoice = s.nextInt();
                    if (modifyChoice == 1) modifyingTask.setStatus(Task.Status.TO_DO);
                    else if (modifyChoice == 2) modifyingTask.setStatus(Task.Status.DOING);
                    else if (modifyChoice == 3) modifyingTask.setStatus((Task.Status.DONE));
                    break;
                case 3: modifyingTask.Clear();
                        break;
                default:break;
            }
            waitABit();
        }

    }

    public static void waitABit(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

