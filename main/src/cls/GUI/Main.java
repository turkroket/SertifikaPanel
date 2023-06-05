package cls.GUI;

import java.io.File;
import java.net.MalformedURLException;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main {
    In Duzenleyici = new In();
    
    public Scene scene;
    public void StageOlustur(Stage stag){   
        stag.setTitle("Sertifika Paneli");
    }
    
    public void Show(Stage stag){
        StageOlustur(stag);
        scene = new Scene(Duzenleyici.StageDuzeniOlustur(), 1720, 900);
        
        Duzenleyici.StageDuzeniGuncelle(stag);
        try {
            File file = new File("main.css");
            String fileUrl = file.toURI().toURL().toExternalForm();
            scene.getStylesheets().add(fileUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //scene.getStylesheets().add(getClass().getResource("C:/Users/h/Documents/UyeYonetim/main/binbutton-styles.css").toExternalForm());
        stag.setScene(scene);
        stag.show();
    }
}
