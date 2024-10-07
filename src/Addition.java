import java.util.ArrayList;

public class Addition extends ComplexExpression{

    public Addition(ArrayList<NumarComplex> args) {
        super(Operation.ADDITION, args);
    }

    @Override
    public void executeAll() {
        NumarComplex result = new NumarComplex();
        for (NumarComplex num : super.getArgs()) {
            result = result.adunare(num);
        }
        System.out.println("Rezultatul adunarii: " + result.toString() + "\n");
    }
}
