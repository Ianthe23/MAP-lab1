import java.util.ArrayList;

public class ExpressionFactory {
    //Factory Pattern
    // In Factory pattern, we create object without exposing the creation logic to the client
    // and refer to newly created object using a common interface.

    //Singleton Pattern
    // This pattern involves a single class which is responsible to create an object
    // while making sure that only single object gets created.
    // This class provides a way to access its only object which can be accessed directly
    // without need to instantiate the object of the class.

    //instanta singleton
    private static ExpressionFactory instance = new ExpressionFactory();

    //constructorul privat pentru singleton - ca sa nu poata fi instantiat
    private ExpressionFactory() {}

    //metoda statica ca sa iau instanta singleton
    public static ExpressionFactory getInstance() {
        if (instance == null) {
            instance = new ExpressionFactory();
        }
        return instance;
    }

    //metoda factory ca sa creez ComplexExpression
    public ComplexExpression createExpression(Operation operation, ArrayList<NumarComplex> args) {
        switch (operation) {
            case ADDITION:
                return new Addition(args);
            case SUBTRACTION:
                return new Substraction(args);
            case MULTIPLICATION:
                return new Multiplication(args);
            case DIVISION:
                return new Division(args);
            default:
                throw new IllegalArgumentException("Operatie nesuportata");

        }
    }
}
