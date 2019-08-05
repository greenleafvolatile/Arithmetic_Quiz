public class Level_1_Problem extends Arithmetic_Problem {

    private final static int level=1;

    public Level_1_Problem(){
        firstNumber=generator.nextInt(10);
        secondNumber=generator.nextInt(10-firstNumber);
    }

    public String displayProblem(){
        return String.format("(Level 1) What is the sum of %d and %d: ", firstNumber, secondNumber);
    }

    public boolean checkAnswer(String response){
        return String.valueOf(firstNumber+secondNumber).equals(response);
    }

    public int getSolution(){
        return firstNumber+secondNumber;
    }

    public int getLevel(){
        return level;
    }

    public Level_1_Problem nextProblem(){
        return new Level_1_Problem();
    }
}
