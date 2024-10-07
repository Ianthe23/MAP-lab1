import java.util.ArrayList;

public abstract class ComplexExpression {
    //Template Pattern
    // In Template pattern, an abstract class exposes defined way(s)/template(s) to execute its methods.
    // Its subclasses can override the method implementation as per need
    // but the invocation is to be in the same way as defined by an abstract class.
    // This pattern comes under behavior pattern category.
    private Operation operation;
    private ArrayList<NumarComplex> args;

    public ComplexExpression(Operation operation, ArrayList<NumarComplex> args) {
        this.operation = operation;
        this.args = args;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public ArrayList<NumarComplex> getArgs() {
        return args;
    }

    public void setArgs(ArrayList<NumarComplex> args) {
        this.args = args;
    }

    public abstract void executeAll();
}
