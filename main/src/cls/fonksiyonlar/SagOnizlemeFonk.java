package cls.fonksiyonlar;

import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import cls.elementler.SagOnizleme;

public class SagOnizlemeFonk {
    public void OnizlemeGuncelle(Button button){
        button.setOnMouseClicked(e -> {
            if (e.getButton()==MouseButton.PRIMARY) {
                
            }
        });

    }
    
}
