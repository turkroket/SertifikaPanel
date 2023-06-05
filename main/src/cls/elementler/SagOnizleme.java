package cls.elementler;

import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class SagOnizleme {
    public Image image;
    public ImageView imageView;
    public Button button;
    public Button button2;
    public ProgressBar progressBar;
    public VBox alesaBox;

    public void ElementrleriOlustur(){
        button = new Button("Onizlemeyi Güncelle");
        button2 = new Button("Farklı Pencerede Görüntüle");
        image = new Image("resim.jpg");
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
