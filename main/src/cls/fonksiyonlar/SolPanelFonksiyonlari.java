package cls.fonksiyonlar;

import cls.VeriTApi.MySql;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SolPanelFonksiyonlari {
    SagOnizlemeFonk sagOnizlemeFonk = new SagOnizlemeFonk();
    MySql mySql = new MySql();
    public String[][] dataStrings;
    private void datastringonder(){
        sagOnizlemeFonk.dataStringAl(dataStrings);
    }
    public void setSagOnizlemeFonk(SagOnizlemeFonk sagOnizlemeFonk){
        this.sagOnizlemeFonk = sagOnizlemeFonk;
    }
    private String[] textler = new String[4];
    public void textGonder(String[] textler){
        sagOnizlemeFonk.setTextler(textler);
    }
    public void verismdegisim(TextField textField1,TextField textField2,TextField textField3,TextField textField4){
        TextField[] textFields = {textField1,textField2,textField3,textField4};
        for (int i = 0; i < textFields.length; i++) {
            final int index = i;
            textFields[index].textProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.matches("\\d*")) {
                    textFields[index].setText(newValue.replaceAll("[^\\d]", ""));
                }
            
            textFields[index].setOnKeyPressed(event -> {
                if (event.getCode().toString().equals("ENTER")) {
                    textler[index] = textFields[index].getText();
                    textGonder(textler);
                }
            });
            });
        }
    }
    public void textFieldChoser(TextField text1, TextField text2, TextField text3 , TextField text4){
        text1.setOnDragEntered(null);
    }
    public void TestBaglanti(Button button){
        button.setOnAction(event -> {
        mySql.getData("sertifika");
        this.dataStrings = mySql.getDataArray();
        //LogEkle(dataStrings[0][0]);
        datastringonder();
        });
        
        
    }
    public void LogEkle(String log){
        sagOnizlemeFonk.LogEkle(log);
    }
}
