package cls.elementler;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import cls.fonksiyonlar.SagOnizlemeFonk;

public class SagOnizleme {
    CheckBox checkBox = new CheckBox("Görüntüyü Güncelle");
    public SagOnizlemeFonk fonk = new SagOnizlemeFonk();
    public Image image;
    public ImageView imageView;
    public Button button;
    public Button button2;
    public Button button3;
    public ProgressBar progressBar;
    public HBox alesaBox;

    public void ElementrleriOlustur(){
        button = new Button("Görüntüyü Güncelle.");
        button2 = new Button("Örnek Görüntü Çıktısı Al.");
        button3 = new Button("Görüntüleri oluştur.");
        image = new Image("sertifika.png");
        imageView = new ImageView(image);
        imageView.setFitWidth(600);
        imageView.setFitHeight(424);
        alesaBox = new HBox();
        progressBar = new ProgressBar();
        progressBar.setProgress(0);
        checkBox.setAlignment(Pos.CENTER_LEFT);
        alesaBox.getChildren().addAll(checkBox,progressBar);
        alesaBox.setAlignment(Pos.CENTER_RIGHT);
    }
    public void PanelYinele(VBox vBox, Stage stage){
        ElementrleriOlustur();
        vBox.getChildren().addAll(alesaBox,imageView, button, button2,button3);
        vBox.setStyle("-fx-background-color: #282828; -fx-text-fill: white;");
        fonk.OnizlemeGuncelleKaydet(button, button2, button3, imageView, vBox, image,stage,progressBar);
    }
}
