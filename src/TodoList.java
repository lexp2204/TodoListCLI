import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TodoList {
    //Add Task method
    public static void addTask(List<String> tasks, Scanner input){
        System.out.println("Enter your task:");
        String newTask=input.nextLine();
        tasks.add(newTask);
        System.out.println("Task added successfully.\n");
    }

    //View Tasks method
    public static void viewTasks(List<String> tasks){
        if(tasks.isEmpty()){
            System.out.println("No Tasks available. \n ");
        }else{
            System.out.println("Your Tasks:");
            for(int i=0;i<tasks.size();i++){
                System.out.println((i+1)+ ". "+tasks.get(i));
            }
            System.out.println();
        }
    }

    public static void removeTask(List<String> tasks, Scanner input){
        if(tasks.isEmpty()){
            System.out.println("There are no tasks in the list to remove");
        }else{
            //Using for loop method to loop through the array with index number
            System.out.println("Your current tasks:");
            for(int i=0;i<tasks.size();i++){
                System.out.println((i + 1) + ". " + tasks.get(i));
            }

            //Prompt user to enter the number with the task they want to remove
            System.out.print("Enter the number of the task to remove: ");
            int choice;

            try{
                choice=input.nextInt();
                input.nextLine();

                //Case Handling if choice number is out of range
                if(choice < 1 || choice>tasks.size()){
                    System.out.println("Invalid Task Number");
                    return;
                }

                String removedTask=tasks.remove(choice-1);
                System.out.println("Removed: \"" + removedTask + "\"\n");

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.\n");
                input.nextLine(); // clear invalid input
            }
        }
    }

    //Main method
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int num = 0;

        //List to store Tasks
        List<String> tasks= new ArrayList<>();

        //Loop to keep the program running
        while(num!=4){
            System.out.println("\n==== TODO LIST MENU ====");
            System.out.println("1. Add a Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove a Task");
            System.out.println("4. Exit");

            System.out.println("Choose a option:");
            num=input.nextInt();
            input.nextLine();

            switch(num){
                case 1:
                    addTask(tasks,input);
                    break;
                case 2:
                    viewTasks(tasks);
                    break;
                case 3:
                    removeTask(tasks,input);
                    break;
                case 4:
                    System.out.println("Exiting the Todo List. Goodbye!");
                default:
                    if(num!=4){
                        System.out.println("Invalid Input.");
                    }

            }


        }
    }
}
