import javax.swing.JOptionPane;

public class Arithmetic_Quiz_1_0_2 {


    public Arithmetic_Quiz_1_0_2() {
    }


    public void startQuiz() {
        do {
            if (getRound()) {
                JOptionPane.showMessageDialog(null, "Yay!");
            }
        } while (askPlayAgain());
    }

    private boolean askPlayAgain() {
        while (true) {
            String option = JOptionPane
                    .showInputDialog(null, "Game over! Play again (y/n)?")
                    .toLowerCase();
            if ("y".equals(option)) {
                return true;
            }
            if ("n".equals(option)) {
                return false;
            }
        }
    }

    private boolean getRound() {
        Arithmetic_Problem[] levels = {new Level_1_Problem(), new Level_2_Problem(), new Level_3_Problem()};
        for (Arithmetic_Problem arithmetic_problem : levels) {
            if (!getLevel(arithmetic_problem)) {
                return false;
            }
        }
        return true;
    }

    private boolean getLevel(Arithmetic_Problem level) {
        JOptionPane.showMessageDialog(null, "Level: " + level.getLevel());
        for (int points = 0; points < 5; points++) {
            if (!getPoint(level)) {
                return false;
            }
            // If user provides correct solution, present new problem.
            if(level.getLevel()==1){
                level=new Level_1_Problem();
            }
            else if(level.getLevel()==2){
                level=new Level_2_Problem();
            }
            else if(level.getLevel()==3){
                level=new Level_3_Problem();
            }
        }
        return true;
    }

    private boolean getPoint(Arithmetic_Problem level) {
        for (int tries = 0; tries < 2; tries++) {
            String response = JOptionPane.showInputDialog(level.displayProblem());
            if (level.checkAnswer(response)) {
                return true;
            }
            JOptionPane.showMessageDialog(null, "Your answer was incorrect. The correct answer was: " + level.getSolution());
        }
        return false;


    }
}


/**
 * This was my original code
 */

/*public void presentProblem(Arithmetic_Problem problem) {

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
                String option = "";
                while (!option.toLowerCase().equals("y") && !option.toLowerCase().equals("n")) {
                    option = JOptionPane.showInputDialog(null, "You answer was not correct! Play again (y/n)?");
                }
                switch (option.toLowerCase()) {
                    case "y":
                        presentProblem(new Level_1_Problem());
                        break;
                    case "n":
                        System.out.print("No");
                        break;
                }
            }
        }
        if (points == 5 && problem.getLevel()==1) {
            points = 0;
            JOptionPane.showMessageDialog(null, "Level 2!");
            problem = new Level_2_Problem();
            presentProblem(problem);
        } else if (points == 5 && problem.getLevel()==2) {
            points = 0;
            JOptionPane.showMessageDialog(null, "Level 3");
            problem = new Level_3_Problem();
            presentProblem(problem);
        } else if (points == 5 && problem.getLevel==3) {
            JOptionPane.showMessageDialog(null, "Yay!");
            System.exit(0);
        }
        problem=problem.getNextProblem();
    }
}*/
