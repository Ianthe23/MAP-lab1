import java.util.ArrayList;

public class Division extends ComplexExpression{
    public Division(ArrayList<NumarComplex> args) {
        super(Operation.DIVISION, args);
    }

    @Override
    public void executeAll() {
        if (super.getArgs().size() < 1) {
            return;
        }

        NumarComplex result = super.getArgs().get(0);
        for (int i = 1; i < super.getArgs().size(); i++) {
            result = result.impartire(super.getArgs().get(i));
        }

        System.out.println("Rezultatul impartirii: " + result.toString() + "\n");
    }
}
