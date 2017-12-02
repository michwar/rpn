package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Controller controller = new Controller();

        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(12);

        Label equationLabel = new Label("Enter the equation");
        TextField equation = new TextField();

        Label enteredEquationLabel = new Label("Entered equation:");
        Text enteredEquation = new Text();

        Label resultLabel = new Label("Result:");
        Text result = new Text();

        Button reset = new Button();
        reset.setText("Reset");
        reset.setStyle("-fx-font-size: 10pt;");
        reset.setOnAction(action -> {
            equation.setText("");
            enteredEquation.setText("");
            result.setText("");
            controller.reset();
        });

        Button calculate = new Button();
        calculate.setText("Compute");
        calculate.setStyle("-fx-font-size: 10pt;");
        calculate.setOnAction(action -> {
            equation.setEditable(false);
            calculate.setDisable(true);
            reset.setDisable(true);

            String entered = equation.getText();
            for (int i = 0; i < entered.length(); i++) {
                controller.perform(entered.charAt(i));
            }
            enteredEquation.setText(entered);
            result.setText(controller.getResult() + "");
            calculate.setDisable(false);
            reset.setDisable(false);
            equation.setEditable(true);
            equation.setText("");
            controller.reset();
        });

        root.add(equationLabel, 0, 0);
        root.add(equation, 0, 1);
        root.add(enteredEquationLabel, 0, 3);
        root.add(enteredEquation, 0, 4);
        root.add(resultLabel, 1, 3);
        root.add(result, 1, 4);
        root.add(calculate, 0, 6);
        root.add(reset, 1, 6);

        Scene scene = new Scene(root, 1000, 500);
        primaryStage.setTitle("Reverse Polish Notation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
