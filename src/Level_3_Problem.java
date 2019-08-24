public class Level_3_Problem extends Arithmetic_Problem {

    private static final int level=3;

    public Level_3_Problem(){

        firstNumber=generator.nextInt(10);
        secondNumber=generator.nextInt(firstNumber+1);
    }

    public String displayProblem(){
        return String.format("What is the difference between %d and %d?", firstNumber, secondNumber);
    }

    public boolean checkAnswer(String response){
        return String.valueOf(firstNumber-secondNumber).equals(response);
    }

    public int getSolution(){
        return firstNumber-secondNumber;
    }

    public int getLevel(){
        return level;
    }

}
