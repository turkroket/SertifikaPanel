package cls.elementler;

import cls.fonksiyonlar.SolOnizlemeFonk;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SolOnizleme {
    public SolOnizlemeFonk solOnizlemeFonk = new SolOnizlemeFonk();
    CheckBox checkBox = new CheckBox("Önizleme");
    public Image image;
    public ImageView imageView;
    public Button button;
    public Button button2;
    public TextArea textField;

    public void ElementrleriOlustur(){
        button = new Button("Onizlemeyi Güncelle");
        button2 = new Button("Farklı Pencerede Görüntüle");
        //action
        image = new Image("resim.jpg");
        imageView = new ImageView(image);
        imageView.setFitWidth(600);
        imageView.setFitHeight(424);
        textField = new TextArea("LOG KAYITLARI BAŞLATILIYOR");
        textField.setPrefWidth(600);
        textField.setPrefHeight(500);
        textField.setEditable(false);
        //textField.setStyle("-fx-background-color: #282828; -fx-text-fill: white;");
    }
    public void PanelYinele(VBox vBox){
        ElementrleriOlustur();
        PanelFonksiyonellik(vBox);
        vBox.getChildren().addAll(checkBox,imageView, button, button2, textField);
        vBox.setStyle("-fx-background-color: #282828; -fx-text-fill: white;");
    }
    public void PanelFonksiyonellik(VBox vBox){
        solOnizlemeFonk.OnizlemeGuncelle(checkBox,button, textField,imageView,vBox, image);

    }
}
