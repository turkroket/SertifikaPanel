import javafx.application.Application;

import cls.GUI.Main;
import javafx.stage.Stage;

public class App extends Application {
    Main Panel = new Main();
    @Override
    public void start(Stage stage) {
        Panel.Show(stage);
    }

    // Main Method
    public static void main(String args[]) {
        // launch the application
        if (args.length > 0 && args[0].equals("console")) {
            System.out.println("Console Mode");
        }else{
            launch(args);
        }
    }
    }

