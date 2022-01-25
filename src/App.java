import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class App extends Application {

    class EditableButton extends Button {
        TextField tf = new TextField();

        public EditableButton(String text) {
            setText(text);
            setOnMouseClicked(e -> {
                tf.setText(getText());
                setText("");
                setGraphic(tf);
            });

            tf.setOnAction(ae -> {
//              if (validateText(tf.getText())) {// this is where you would validate the text
                setText(tf.getText());
                setGraphic(null);
//            }
            });
        }
    }

        private EditableButton [][] buttons = new EditableButton[8][8];
        GridPane layout  = new GridPane();

        @Override
        public void start(Stage stage) throws IOException {


            layout.setHgap(10);
            layout.setVgap(10);
            layout.setPadding(new Insets(0, 10, 0, 10));
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    buttons[i][j] = new EditableButton(" ");
                    layout.add(buttons[i][j], i, j);
                }
            }
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                World pyWorld = new World.Builder()
                        //                .alien(new Position(5,5))
                        .dandelion(new Position(0, 4))
                        .toadstool(new Position(4, 4))
                        .grass(new Position(4, 0))
                        .wolf(new Position(7, 7))
                        .sheep(new Position(0, 0))
                        .build(8, 8);

                @Override
                public void run() {
                    pyWorld.makeTurn();
                    for(int i = 0; i < pyWorld.getOrganisms().size(); i++){
                        Organism o = pyWorld.getOrganisms().get(i);
                        Position position = o.getPosition();
                        EditableButton button = buttons[position.getX()][position.getY()];
                        button.setText(o.getSign());
                    }

                }
            };
            timer.schedule(task, 5000);

            Scene scene = new Scene(layout, 800, 600);
            stage.setTitle("Hello World!");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {

            launch();

        }

    }
