import java.util.Random;

public abstract class Arithmetic_Problem {

    public static final Random generator=new Random();
    protected int firstNumber;
    protected int secondNumber;


    public abstract boolean checkAnswer(String response);

    public abstract String displayProblem();

    public abstract int getSolution();

    public abstract int getLevel();

    public abstract Arithmetic_Problem nextProblem();
}

