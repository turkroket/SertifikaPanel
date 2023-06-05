package cls.fonksiyonlar;

import javafx.scene.control.TextField;

public class SolPanelFonksiyonlari {
    public void verismdegisim(TextField textField1,TextField textField2,TextField textField3,TextField textField4){
        TextField[] textFields = {textField1,textField2,textField3,textField4};
        for (int i = 0; i < textFields.length; i++) {
            final int index = i;
            textFields[index].textProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.matches("\\d*")) {
                    textFields[index].setText(newValue.replaceAll("[^\\d]", ""));
                }
            });
        }
    }
    public void textFieldChoser(TextField text1, TextField text2, TextField text3 , TextField text4){
        text1.setOnDragEntered(null);
    }
}
