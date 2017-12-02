package sample;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Double> numbers;

    Controller() {
        numbers = new ArrayList<>();
    }

    private void addNumberToList(Double number) {
        numbers.add(number);
    }

    private void calculate(ActionType action) {
        if (numbers.size() < 2) {
            throw new IllegalStateException("Cannot perform any action when the scope consists of less than two numbers");
        }

        Double result = 0D;
        int size = numbers.size();
        Double second = numbers.remove(size - 1);
        Double first = numbers.remove(size - 2);

        switch (action) {
            case PLUS:
                result = first + second;
                break;
            case MINUS:
                result = first - second;
                break;
            case MULTIPLY:
                result = first * second;
                break;
            case DIVIDE:
                result = first / second;
                break;
            case POWER:
                result = Math.pow(first, second);
                break;
        }

        addNumberToList(result);
    }

    Double getResult() {
        if (numbers.size() == 1)
            return numbers.get(0);
        throw new IllegalStateException("On the scope is more than one number. You have to perform more action before getting result");
    }

    void reset() {
        numbers = new ArrayList<>();
    }

    void perform(char sign) {
        if (sign >= '0' && sign <= '9') {
            double d = (double) (sign - '0');
            addNumberToList(d);
        } else {
            ActionType action = ActionType.valueOfSign(String.valueOf(sign));
            calculate(action);
        }
    }
}
