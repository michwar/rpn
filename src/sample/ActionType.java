package sample;

/**
 * Created by Michał on 2017-12-02.
 */
public enum ActionType {
    PLUS("+"), MINUS("-"), DIVIDE("/"), MULTIPLY("*"), POWER("^");

    private String sign;

    ActionType(String sign) {

        this.sign = sign;
    }

    public static ActionType valueOfSign(String s) {
        for (ActionType action : values()) {
            if (action.sign.equals(s))
                return action;
        }
        throw new IllegalArgumentException("Incorrect sign");
    }
}
