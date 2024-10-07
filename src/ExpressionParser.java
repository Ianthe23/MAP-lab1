import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParser {
    public ComplexExpression parseExpression(String input) {
        // Ex: 3+2*i - 4-2*i
        String[] parti = input.split(" ");

        if (parti.length < 3) {
            throw new IllegalArgumentException("Expresie invalida!");
        }

        String operatie = parti[1];
        for (int i = 3; i < parti.length; i += 2) {
            if (!parti[i].equals(operatie)) {
                throw new IllegalArgumentException("Expresie invalida!");
            }
        }

        Operation operation = parseOperation(operatie);
        ArrayList<NumarComplex> args = parseArguments(parti);

        ExpressionFactory factory = ExpressionFactory.getInstance();
        return factory.createExpression(operation, args);
    }

    private Operation parseOperation(String optiuni) {
        switch (optiuni.toLowerCase()) {
            case "+":
                return Operation.ADDITION;
            case "-":
                return Operation.SUBTRACTION;
            case "*":
                return Operation.MULTIPLICATION;
            case "/":
                return Operation.DIVISION;
            default:
                throw new IllegalArgumentException("Operatie invalida!");
        }
    }

    private ArrayList<NumarComplex> parseArguments(String[] args) {
        ArrayList<NumarComplex> argList = new ArrayList<>();
        for (int i = 0; i < args.length; i += 2) {
            double re = 0, im = 0;

            // ne asiguram ca argumentul contine "i"
            if (!args[i].contains("i")) {
                throw new IllegalArgumentException("Argument invalid! Trebuie sa fie un nr complex cu parte imaginara!");
            }

            // veriricam daca argumentul contine si alte argumente decat cifre,-,+,*,i
            Pattern pattern = Pattern.compile("[^0-9+\\-*i]");
            Matcher matcher = pattern.matcher(args[i]);

            if (matcher.find()) {
                throw new IllegalArgumentException("Un argument contine alte caractere decat cele permise!");
            }

            // regex ca sa dam split la numere
            String[] parts = args[i].split("(?=[+-])");

            for (String part : parts) {
                part = part.trim();
                if (part.endsWith("i")) {
                    // luam partea imaginara
                    String imaginaryPart = part.substring(0, part.length() - 1).trim(); // eliminam i-ul

                    // +2* de exemplu
                    if (imaginaryPart.isEmpty() || imaginaryPart.equals("+")) {
                        im = 1;  // "+i" or "i"
                    } else if (imaginaryPart.equals("-")) {
                        im = -1; // "-i"
                    } else if (imaginaryPart.contains("*")){
                        // dam extract la numar
                        imaginaryPart = imaginaryPart.replaceAll("[^\\d-+]", ""); // pastram doar numarul si semnul
                        im = Double.parseDouble(imaginaryPart);
                    } else {
                        throw new IllegalArgumentException("Partea imaginara este invalida!");
                    }
                } else {
                    // luam partea reala
                    re = Double.parseDouble(part);
                }
            }

            argList.add(new NumarComplex(re, im));
        }
        return argList;
    }
}