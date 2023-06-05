package cls.fonksiyonlar;

import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

//import cls.fonksiyonlar.SolOnizlemeFonk;

public class SagPanelFonksiyonlari {
    private SolOnizlemeFonk solOnizlemeFonk;
    public void setSolOnizlemeFonk(SolOnizlemeFonk solOnizlemeFonk) {
        this.solOnizlemeFonk = solOnizlemeFonk;
    }
    // public void veriGonder() {
    //     // Veri gönderme işlemleri
    //     double[] veri = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0};
    //     solOnizlemeFonk.veriAl(veri);
    // }
    //private SolOnizlemeFonk solOnizlemeFonk = new SolOnizlemeFonk();
    public double[] xKoordinatlar=new double[8];
    public void xKordinatlarGonder(){
        System.out.println("Gönderilen veriler"+ xKoordinatlar);
        solOnizlemeFonk.xKoordinatlariniAl(xKoordinatlar);
    }
    public void xYKoordinatlariniAl(TextField textField1,TextField textField2,TextField textField3,TextField textField4, TextField textField5, TextField textField6, TextField textField7, TextField textField8){
        TextField[] textFields = {textField1,textField2,textField3,textField4,textField5,textField6,textField7,textField8};
        for (int i = 0; i < textFields.length; i++) {
            final int index = i;
            textFields[index].setOnMouseClicked(event -> {
                
                String text = textFields[index].getText();
                //System.out.println(text);
                if(text.equals("X") || text.equals("Y")){
                    //System.out.println("tıklandı");
                    textFields[index].setText("0");
                }
            });
            textFields[index].textProperty().addListener((observable, oldValue, newValue) -> {
                if(!newValue.equals("")){
                    if (!newValue.matches("\\d*(\\.\\-\\d*)?")) {
                        textFields[index].setText(newValue.replaceAll("[^\\d.]", ""));
                    
                }}else{
                    textFields[index].setText("0");
                }
            });
            textFields[index].setOnKeyPressed(event -> {
                String text = textFields[index].getText();
                //System.out.println(text);
                if(text.equals("X") || text.equals("Y")){
                    //System.out.println("tıklandı");
                    textFields[index].setText("0");
                }
                //System.out.println("basıldı");
                xKoordinatlar[index]=Double.parseDouble(textFields[index].getText());
                xKordinatlarGonder();
                //solOnizlemeFonk.xKoordinatlariAl(xKoordinatlari);
                //System.out.println(xKoordinatlar[index]);
            });
        }
        // TextField[] textFields = {textField1,textField2,textField3,textField4};
        // for (int i = 0; i < textFields.length; i++) {
        //     final int index = i;
        //     textFields[index].textProperty().addListener((observable, oldValue, newValue) -> {
        //         if (newValue.matches("\\d*")) {
        //             textFields[index].setText(newValue.replaceAll("[^\\d]", ""));
        //         }
        //     });
        // }
    }
    public void FontAl(ComboBox<String> comboBox, ComboBox<String> comboBox2, ComboBox<String> comboBox3,ComboBox<String> comboBox4) {
        //create combobox to array
        ComboBox[] comboBoxs = {comboBox,comboBox2,comboBox3,comboBox4};
        for (int i = 0; i < comboBoxs.length; i++) {
            final int index = i;
            comboBoxs[index].setPrefWidth(2);
            comboBoxs[index].setMaxHeight(comboBoxs[index].getPrefWidth());
        }
        for (int i = 0; i < comboBoxs.length; i++) {
            final int index = i;
            comboBoxs[index].setOnMouseClicked(event -> {
                
                //ObservableList<String> fontList = FXCollections.observableArrayList(Font.getFamilies());
                //comboBoxs[index].setItems(fontList);
                System.out.println("null");
            });
        }
    }

}
    

