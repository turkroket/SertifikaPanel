package cls.fonksiyonlar;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

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
    private SagOnizlemeFonk sagOnizlemeFonk;
    public void SagOnizlemeFonk(SagOnizlemeFonk sagOnizlemeFonk)
    {
        this.sagOnizlemeFonk = sagOnizlemeFonk;
    }
    // public void veriGonder() {
    //     // Veri gönderme işlemleri
    //     double[] veri = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0};
    //     solOnizlemeFonk.veriAl(veri);
    // }
    //private SolOnizlemeFonk solOnizlemeFonk = new SolOnizlemeFonk();
    public String[] Fontisim = new String[4];
    public double[] xKoordinatlar=new double[8];
    public double[] FontBoyutlari = new double[4];
    public void xKordinatlarGonder(){
        System.out.println("Gönderilen veriler"+ xKoordinatlar);
        solOnizlemeFonk.xKoordinatlariniAl(xKoordinatlar);
        sagOnizlemeFonk.xKoordinatlariniAl(xKoordinatlar);
    }
    public String imaString;
    public void imaStringGonder(){
        solOnizlemeFonk.setImageString(imaString);
        sagOnizlemeFonk.setImageString(imaString);
    }
    private void FontBoyutlariGonder() {
        solOnizlemeFonk.setFontBoyutlari(FontBoyutlari);
        sagOnizlemeFonk.setFontBoyutlari(FontBoyutlari);
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
                    if (!newValue.matches("-?\\d*(\\.\\d*)?")) {
                        textFields[index].setText(newValue.replaceAll("[^\\d.]", ""));
                    
                }
            }else{
                    textFields[index].setText("0");
                }
            });
            textFields[index].setOnKeyPressed(event -> {
                String text = textFields[index].getText();
                //System.out.println(text);
                if(text.equals("X") || text.equals("Y") || text.equals("-")){
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
            comboBoxs[index].setPrefWidth(1);
            comboBoxs[index].setMaxHeight(comboBoxs[index].getPrefWidth());
        }
        for (int i = 0; i < comboBoxs.length; i++) {
            final int index = i;
            comboBoxs[index].setOnMouseClicked(event -> {
                
                ObservableList<String> fontList = FXCollections.observableArrayList(Font.getFamilies());
                comboBoxs[index].setItems(fontList);
                //System.out.println("null");
            });
            comboBoxs[index].setOnAction(event ->{
                Fontisim[index]=comboBoxs[index].getValue().toString();
                //System.out.println(Fontisim[index]);
                FontisimleriGonder();
                //System.out.println("null");
            });
        }
    }
    private void FontisimleriGonder() {
        solOnizlemeFonk.setFontIsimleri(Fontisim);
        sagOnizlemeFonk.setFontIsimleri(Fontisim);
    }
    public void Sablondegis(Button button, Stage primaryStage){
        button.setOnMouseClicked(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Dosya Seç");
            fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("JPEG dosyaları", "*.jpeg", "*.jpg"),
        new FileChooser.ExtensionFilter("PNG dosyaları", "*.png")
);
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                String filePath = selectedFile.getAbsolutePath();
                // Dosya yolunu kullanabilirsiniz
                //System.out.println("Seçilen dosya yol: " + filePath);
                imaString=filePath;
                imaStringGonder();
            }
            });
    }
    public void FontBuyuklugu(TextField textField8, TextField textField9, TextField textField10, TextField textField11) {
        TextField[] textFields = {textField8,textField9,textField10,textField11};
        for (int i = 0; i < textFields.length; i++) {
            final int index = i;
            textFields[index].setOnMouseClicked(event -> {
                
                String text = textFields[index].getText();
                //System.out.println(text);
                if(text.equals("Birincil Punto") || text.equals("İkincil Punto") || text.equals("Üçüncül Punto") || text.equals("Dördüncül Punto")){
                    //System.out.println("tıklandı");
                    textFields[index].setText("0");
                }
            });
            textFields[index].textProperty().addListener((observable, oldValue, newValue) -> {
                if(!newValue.equals("")){
                    if (!newValue.matches("-?\\d*(\\.\\d*)?")) {
                        textFields[index].setText(newValue.replaceAll("[^\\d.]", ""));
                    
                }
            }else{
                    textFields[index].setText("0");
                }
            });
            textFields[index].setOnKeyPressed(event -> {
                String text = textFields[index].getText();
                //System.out.println(text);
                if(text.equals("Birincil Punto") || text.equals("İkincil Punto") || text.equals("Üçüncül Punto") || text.equals("Dördüncül Punto") || text.equals("-")){
                    //System.out.println("tıklandı");
                    textFields[index].setText("0");
                }
                //System.out.println("basıldı");
                FontBoyutlari[index]=Double.parseDouble(textFields[index].getText());
                FontBoyutlariGonder();
                //solOnizlemeFonk.xKoordinatlariAl(xKoordinatlari);
                //System.out.println(xKoordinatlar[index]);
            });
        }

    }
    
    }


    

