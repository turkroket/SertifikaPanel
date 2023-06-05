package cls.elementler;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
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
    public VBox alesaBox;

    public void ElementrleriOlustur(){
        button = new Button("Görüntüyü Güncelle.");
        button2 = new Button("Örnek Görüntü Çıktısı Al.");
        button3 = new Button("Görüntüleri oluştur.");
        image = new Image("sertifika.png");
        imageView = new ImageView(image);
        imageView.setFitWidth(600);
        imageView.setFitHeight(424);
        alesaBox = new VBox();
        progressBar = new ProgressBar();
        progressBar.setProgress(0.5);
        alesaBox.getChildren().addAll(imageView, progressBar);
    }
    public void PanelYinele(VBox vBox){
        ElementrleriOlustur();
        vBox.getChildren().addAll(alesaBox, button, button2);
        vBox.setStyle("-fx-background-color: #282828; -fx-text-fill: white;");
    }
}
