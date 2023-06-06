package cls.fonksiyonlar;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

public class SolOnizlemeFonk {
    
    
    //final SagPanelFonksiyonlari sagPanelFonksiyonlari = SagPanelFonksiyonlari();

    private double[] xKoordinatlari = new double[8];
    public void xKoordinatlariniAl(double[] gelenKoordinatlar) {
        for (int i = 0; i < xKoordinatlari.length; i++) {
            xKoordinatlari[i] = gelenKoordinatlar[i];
        }
    
        // Değiştirilen xKoordinatlari'ni kullanarak istediğiniz işlemi yapabilirsiniz
        // Örneğin, değiştirilen xKoordinatlari'ni ekrana yazdırabilirsiniz
        // for (double value : xKoordinatlari) {
        //     System.out.println(value);
        // }
    }

    private String imageString = "";
    public void setImageString(String imageString) {
        this.imageString = imageString;
        //System.out.println(this.imageString);
    }
    
    private double[] FontBoyutlari = new double[4];
    public void setFontBoyutlari(double[] FontBoyutlari) {
        this.FontBoyutlari = FontBoyutlari;
    }
    public String previmgurlString = "";

    Rectangle rectangle = new Rectangle();
    //SolOnizleme solg = new SolOnizleme();
    
    public void OnizlemeGuncelle(CheckBox checkBox,Button button, TextArea textField, ImageView image, VBox vBox, Image image2) {
        previmgurlString = imageString;
        final double[] prevxKoordinatlari = new double[8];
        final double[] prevFontBoyutlari = new double[4];
        Timer timer = new Timer();
    
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if (!checkBox.isSelected()) {
                        return;
                    }
                    if (!previmgurlString.equals(imageString)) {
                        System.out.println("Degisim gercekleşti");
                        //change image url
                        Image image3 = new Image(imageString);
                        image.setImage(image3);
                        previmgurlString = imageString;
                    }
                    boolean xKoordinatlariDegisti = false;
                    boolean fontBoyutlariDegisti = false;
                    
                    for (int i = 0; i < xKoordinatlari.length; i++) {
                        if (prevxKoordinatlari[i] != xKoordinatlari[i]) {
                            xKoordinatlariDegisti = true;
                            break;
                        }
                    }
                    
                    for (int i = 0; i < FontBoyutlari.length; i++) {
                        if (prevFontBoyutlari[i] != FontBoyutlari[i]) {
                            fontBoyutlariDegisti = true;
                            break;
                        }
                    }
                    
                    if (xKoordinatlariDegisti || fontBoyutlariDegisti) {
                        OnizlemeMotoru(image, vBox, image2, imageString);
                        System.out.println("Değişim gerçekleşti");
                        System.arraycopy(xKoordinatlari, 0, prevxKoordinatlari, 0, xKoordinatlari.length);
                        System.arraycopy(FontBoyutlari, 0, prevFontBoyutlari, 0, FontBoyutlari.length);
                    }
                });
            }
        };
//xKonrdinatlarinda değişiklik olursa çalışacak
    timer.scheduleAtFixedRate(task, 100, 100);
        button.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                //getChildrens(vBox);
                OnizlemeMotoru(image, vBox, image2, imageString);
            } 
        });

    }
public void getChildrens(VBox vBox){
        ObservableList<javafx.scene.Node> children = vBox.getChildren();
                for (javafx.scene.Node child : children) {
                    System.out.println(child);
                }
    }
    public void OnizlemeMotoru(ImageView view, VBox vBox, Image image, String imageString){
        if (vBox.getChildren().contains(view)) {
            System.out.println("view var");
            vBox.getChildren().remove(view);
        }

        // Mevcut StackPane'leri kaldırma
        vBox.getChildren().removeIf(node -> node instanceof StackPane);

        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.CENTER);
        stackPane.getChildren().add(view);

        Rectangle Rectangle1 = new Rectangle();
        Rectangle1.setWidth(10);
        Rectangle1.setHeight(FontBoyutlari[0]);
        Rectangle1.setFill(Color.RED);
        Rectangle1.setTranslateX(xKoordinatlari[0]);
        Rectangle1.setTranslateY(xKoordinatlari[1]);
        Rectangle Rectangle2 = new Rectangle();
        Rectangle2.setWidth(10);
        Rectangle2.setHeight(FontBoyutlari[1]);
        Rectangle2.setFill(Color.RED);
        Rectangle2.setTranslateX(xKoordinatlari[2]);
        Rectangle2.setTranslateY(xKoordinatlari[3]);
        Rectangle Rectangle3 = new Rectangle();
        Rectangle3.setWidth(10);
        Rectangle3.setHeight(FontBoyutlari[2]);
        Rectangle3.setFill(Color.RED);
        Rectangle3.setTranslateX(xKoordinatlari[4]);
        Rectangle3.setTranslateY(xKoordinatlari[5]);
        Rectangle Rectangle4 = new Rectangle();
        Rectangle4.setWidth(10);
        Rectangle4.setHeight(FontBoyutlari[3]);
        Rectangle4.setFill(Color.RED);
        Rectangle4.setTranslateX(xKoordinatlari[6]);
        Rectangle4.setTranslateY(xKoordinatlari[7]);

        stackPane.getChildren().addAll(Rectangle1, Rectangle2, Rectangle3, Rectangle4);

        vBox.getChildren().add(1, stackPane);
        
    }
    private String[] fontisim = new String[4];
    public void setFontIsimleri(String[] fontisim2) {
        this.fontisim = fontisim2;
    }
}
