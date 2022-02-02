import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        System.out.println("Hello Terminal");
        Scanner sc= new Scanner(System.in);
        System.out.println("Please enter absolut path to file with Puzzle data");
        String str= sc.nextLine();              //reads string
        System.out.print("You have entered: "+str);
        Solver mySolver = new Solver(str);
        mySolver.calculateNrSolutions();
        System.out.println("\n Number of solutions = "+ mySolver.getNrSolutions());
    }
}
