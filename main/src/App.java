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
        launch(args);
    }
    }

