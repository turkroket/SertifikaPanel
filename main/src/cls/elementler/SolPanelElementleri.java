package cls.elementler;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import cls.fonksiyonlar.SolPanelFonksiyonlari;

public class SolPanelElementleri {
    public SolPanelFonksiyonlari solPanelFonksiyonlari = new SolPanelFonksiyonlari();
    public Button button;
    public Button button1;
    public TextField textField;
    public String tabload;
    public TextField textField1;
    public TextField textField2;
    public TextField textField3;
    public TextField textField4;
    public Button button2;
    
    public void ElementrleriOlustur(){
    button = new Button("Veri Tabanına Bağlan");
    button1 = new Button("Tablo Göster");
    textField = new TextField("Tablo ismini giriniz");
    textField1 = new TextField("Birinci Alana Gelecek Veri");
    textField1.setStyle("-fx-background-color: #282828; -fx-text-fill: red;");
    textField2 = new TextField("İkinci Alana Gelecek Veri");
    textField2.setStyle("-fx-background-color: #282828; -fx-text-fill: green;");
    textField3 = new TextField("Üçüncü Alana Gelecek Veri");
    textField3.setStyle("-fx-background-color: #282828; -fx-text-fill: blue;");
    textField4 = new TextField("Dördüncü Alana Gelecek Veri");
    textField4.setStyle("-fx-background-color: #282828; -fx-text-fill: cyan;");
    button2 = new Button("  =>  ");
    

    }
    public void PanelYinele(VBox leftButtons){
        ElementrleriOlustur();
        solPanelFonksiyonlari.verismdegisim(textField1,textField2,textField3,textField4);
        solPanelFonksiyonlari.TestBaglanti(button);
        leftButtons.getChildren().addAll(button,textField,button1,textField1,textField2,textField3,textField4,button2);
        //leftButtons.getChildren().addAll();
    }
}
