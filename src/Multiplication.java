import java.util.ArrayList;

public class Multiplication extends ComplexExpression{
    public Multiplication(ArrayList<NumarComplex> args) {
        super(Operation.MULTIPLICATION, args);
    }

    @Override
    public void executeAll() {
        NumarComplex result = new NumarComplex(1, 0);

        for (NumarComplex nr: super.getArgs()) {
            result = result.inmultire(nr);
        }

        System.out.println("Rezultatul inmultirii: " + result.toString() + "\n");
    }
}
