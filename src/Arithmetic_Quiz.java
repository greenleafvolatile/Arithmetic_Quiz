import javax.swing.*;

public class Arithmetic_Quiz {


    public Arithmetic_Quiz() {
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
        // I wanted the text on the JOptionPane to be centered. For that I had to put together my own OptionPane.
        JOptionPane pane=new JOptionPane(new JLabel("Level " + level.getLevel() + "!", JLabel.CENTER));
        JDialog dialog=pane.createDialog("");
        dialog.setModal(true);
        dialog.setVisible(true);
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
            if(response==null){
                JOptionPane.showMessageDialog(null, "Thanks for playing!", "Bye!", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
            else if (level.checkAnswer(response)) {
                return true;
            }
            JOptionPane.showMessageDialog(null, "Your answer was incorrect. The correct answer was: " + level.getSolution());
        }
        return false;
    }
}



