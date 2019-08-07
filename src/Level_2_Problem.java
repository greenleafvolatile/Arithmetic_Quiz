public class Level_2_Problem extends Arithmetic_Problem {

    private static final int level=2;

    public Level_2_Problem(){
        firstNumber=generator.nextInt(10);
        secondNumber=generator.nextInt(10);
    }

    public String displayProblem(){
        return String.format("(Level 2) What is the sum of %d and %d: ", firstNumber, secondNumber);
    }

    public boolean checkAnswer(String response){
        return(String.valueOf(firstNumber+secondNumber).equals(response));
    }

    public int getSolution(){
        return firstNumber+secondNumber;
    }

    public int getLevel(){
        return level;
    }

}
