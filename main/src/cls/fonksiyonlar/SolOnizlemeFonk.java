package cls.fonksiyonlar;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

public class SolOnizlemeFonk {
    
    //final SagPanelFonksiyonlari sagPanelFonksiyonlari = SagPanelFonksiyonlari();
    private SagPanelFonksiyonlari sagPanel;
    public void setSagPanelFonksiyonlari(SagPanelFonksiyonlari sagPanelFonksiyonlari) {
        this.sagPanel = sagPanelFonksiyonlari;
    }
    // public void veriAl(double[] veri) {
    //     // Veri alma işlemleri
    //     for (double value : veri) {
    //         System.out.println(value);
    //     }
    // }
    
    
    private double[] xKoordinatlari = new double[8];
    public void xKoordinatlariniAl(double[] gelenKoordinatlar) {
        for (int i = 0; i < xKoordinatlari.length; i++) {
            xKoordinatlari[i] = gelenKoordinatlar[i];
        }
    
        // Değiştirilen xKoordinatlari'ni kullanarak istediğiniz işlemi yapabilirsiniz
        // Örneğin, değiştirilen xKoordinatlari'ni ekrana yazdırabilirsiniz
        for (double value : xKoordinatlari) {
            System.out.println(value);
        }
    }
    
    private static final int MIN_COORDINATE = 200;
    private static final int MAX_COORDINATE = 300;
    Random random = new Random();
    Rectangle rectangle = new Rectangle();
    //SolOnizleme solg = new SolOnizleme();
    public void getChildrens(VBox vBox){
        ObservableList<javafx.scene.Node> children = vBox.getChildren();
                for (javafx.scene.Node child : children) {
                    System.out.println(child);
                }
    }
    public void OnizlemeGuncelle(Button button, TextArea textField, ImageView image, VBox vBox){
        Timer timer = new Timer();

TimerTask task = new TimerTask() {
    @Override
    public void run() {
        Platform.runLater(() -> {
        OnizlemeMotoru(image, vBox);
            //System.out.println("TimerTask");
        });
    }
};
//xKonrdinatlarinda değişiklik olursa çalışacak
timer.scheduleAtFixedRate(task, 100, 100);
        button.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                //getChildrens(vBox);
                OnizlemeMotoru(image, vBox);
            } 
        });

    }

    public void OnizlemeMotoru(ImageView view, VBox vBox){
        if (vBox.getChildren().contains(view)) {
            System.out.println("view var");
            vBox.getChildren().remove(view);
        }

        // Mevcut StackPane'leri kaldırma
        vBox.getChildren().removeIf(node -> node instanceof StackPane);

        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.CENTER);
        stackPane.getChildren().add(view);

        Circle circle = new Circle();
        circle.setRadius(10);
        circle.setFill(Color.RED);
        //System.out.println("xKoordinatlari[0]"+xKoordinatlari[0]);
        //xKoordinatlari=sagPanelFonksiyonlari.xYKordinatVer();
        
        //double randomX = random.nextInt((int)xKoordinatlari[0] - (int)xKoordinatlari[1]) + (int)xKoordinatlari[1];
        //double randomY = random.nextInt((int)xKoordinatlari[2] - (int)xKoordinatlari[3]) + (int)xKoordinatlari[3];
        //RANDOM SET TRANSLATE X
        //int randomX = random.nextInt(MAX_COORDINATE - MIN_COORDINATE) + MIN_COORDINATE;
        //System.out.println("sss"+xKoordinatlari[0]);
        circle.setTranslateX(xKoordinatlari[0]);
        //int randomY = random.nextInt(MAX_COORDINATE - MIN_COORDINATE) + MIN_COORDINATE;
        circle.setTranslateY(xKoordinatlari[1]);
        //circle.setTranslateX();
        //circle.setTranslateY(0);
        stackPane.getChildren().add(circle);

        vBox.getChildren().add(0, stackPane);
        
    }
}
