import java.util.ArrayList;

public class Substraction extends ComplexExpression{
    public Substraction(ArrayList<NumarComplex> args) {
        super(Operation.SUBTRACTION, args);
    }

    @Override
    public void executeAll() {
        if (super.getArgs().size() < 1)
            return;

        NumarComplex result = super.getArgs().get(0);
        for (int i = 1; i < super.getArgs().size(); i++) {
            result = result.scadere(super.getArgs().get(i));
        }

        System.out.println("Rezultatul scaderii: " + result.toString() + "\n");
    }
}
