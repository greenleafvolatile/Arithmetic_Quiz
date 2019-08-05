import javax.swing.*;
import java.util.logging.Logger;

public class Arithmetic_Quiz_1_0_1 {

    private int points;
    private int tries;

    public Arithmetic_Quiz_1_0_1() {
        points = 0;
        tries = 0;
        Arithmetic_Problem problem = new Level_1_Problem();
        presentProblem(problem);
    }

    private void presentProblem(Arithmetic_Problem problem) {

        while (points <= 5) {

            String response = JOptionPane.showInputDialog(problem.displayProblem());
            if (problem.checkAnswer(response)) {
                points++;
                tries = 0;
                Logger.getGlobal().info("Points: " + points);
            } else if (!problem.checkAnswer(response)) {
                tries++;
                if (tries < 2) {
                    JOptionPane.showMessageDialog(null, "Your answer was incorrect. The correct answer was: " + problem.getSolution());
                    presentProblem(problem);
                }
                if (tries == 2) {
                    askPlayAgain();
                }
            }
            if(points==5){
                points=0;
                levelUp(problem);

            }
            problem = problem.nextProblem();
        }
    }

    private void levelUp(Arithmetic_Problem problem){
       switch(problem.getLevel()) {
           case 1 :
               problem=new Level_2_Problem();
               JOptionPane.showMessageDialog(null, "Level 2!");
           break;
           case 2 :
               problem=new Level_3_Problem();
               JOptionPane.showMessageDialog(null, "Level 3!");
           break;
           case 3 :
               JOptionPane.showMessageDialog(null, "You win!");
               askPlayAgain();
       }
       presentProblem(problem);
    }


    private void askPlayAgain() {
        while (true) {
            String option = JOptionPane.showInputDialog(null, "Your answer was not correct. Play again(y/n)?");
            switch (option.toLowerCase()) {
                case "y":
                    Logger.getGlobal().info("User selected yes.");
                    presentProblem(new Level_1_Problem());
                    break;
                case "n":
                    Logger.getGlobal().info("User selected no.");
                    System.exit(0);
                    break;
            }
        }
    }
}
