package cls.fonksiyonlar;

import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Pos;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import com.mysql.cj.log.Log;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import cls.elementler.SolOnizleme;


public class SagOnizlemeFonk {
    StackPane onizlemPane = new StackPane();
    StackPane OutPane = new StackPane();
    StackPane pane = new StackPane();
    Image realImage;
    Text text = new Text();
    Text text2 = new Text();
    Text text3 = new Text();
    Text text4 = new Text();
    

    ImageView realView;
    private String directory = new String("");
    private SolOnizleme solOnizleme = new SolOnizleme();
    public void setSolOnizlemeyiAl(SolOnizleme solOnizleme){
        this.solOnizleme = solOnizleme;
    }
    public void LogEkle(String mesaj){
        solOnizleme.textField.appendText("\n"+mesaj);
    }
    private String previmgurlString = "sertifika.png";
    public void OnizlemeGuncelleKaydet(Button button, Button button2, Button button3, ImageView view, VBox vBox, Image image, Stage stage, ProgressBar progressBar){
        LogEkle("Başlatılıyor...");
        button.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY){
                LogEkle("Görüntü güncelleniyor...");
                if (!previmgurlString.equals(imageString)) {
                    System.out.println("Degisim gercekleşti");
                    //change image url
                    Image image3 = new Image(imageString);
                    //Image newImage = loadImage("path/to/your/new_image.jpg");""
                    //image = new Image(imageString);
                    view.setImage(image3);
                    previmgurlString = imageString;
                }
                //LogEkle(dataStrings[0][1]);
                //LogEkle(solPanelFonksiyonlari.dataStrings[0][1]);
                OnizlemeMotoru( view, vBox, image, imageString, 0, stage);
            }
        });
        button2.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY){
                LogEkle("Görüntü kaydediliyor...");
                ResimKayit(stage, OnizlemeKaydet(textler[0], textler[1], textler[2], textler[3]));
                //OnizlemeMotoru( view, vBox, image, imageString, 1,stage);
            }
        });
        button3.setOnMouseClicked(event->{
            DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Klasör Seç");
        File selectedDirectory = directoryChooser.showDialog(stage);

        if (selectedDirectory != null) {
            directory = selectedDirectory.getAbsolutePath();
            //System.out.println("Seçilen Klasör Konumu: " + selectedDirectory.getAbsolutePath());
        }
            OtomasyonKayıt(progressBar);
        });
    }
    private double[] FontBoyutlari = new double[4];
    public void setFontBoyutlari(double[] FontBoyutlari) {
        this.FontBoyutlari = FontBoyutlari;
    }
    private String imageString = "sertifika.png";
    public void setImageString(String imaString) {
        this.imageString = imaString;
        //System.out.println(this.imageString);
    }
    private double[] xKoordinatlar = new double[8];
    public void xKoordinatlariniAl(double[] xKoordinatlari) {
        this.xKoordinatlar = xKoordinatlari;
    
        // Değiştirilen xKoordinatlari'ni kullanarak istediğiniz işlemi yapabilirsiniz
        // Örneğin, değiştirilen xKoordinatlari'ni ekrana yazdırabilirsiniz
        //System.out.println(xKoordinatlar[0]);
    }
    public void OtomasyonKayıt(ProgressBar progress){
        for (int i = 0; i < dataStrings.length; i++) {
            PDFKayit(OnizlemeKaydet(dataStrings[i][0], dataStrings[i][3], dataStrings[i][5], dataStrings[i][1]), dataStrings[i][4], progress);
        }

    }
    public void OnizlemeMotoru(ImageView view, VBox vBox, Image image, String imageString, int nod, Stage stage){
        //System.out.println("Güncelleme");
            if (vBox.getChildren().contains(view)) {
            System.out.println("view var");
            vBox.getChildren().remove(view);
            }

        // Mevcut StackPane'leri kaldırma
        vBox.getChildren().removeIf(node -> node instanceof StackPane);
        if(!onizlemPane.getChildren().isEmpty()){
            onizlemPane.getChildren().removeAll();
        }
        if(!onizlemPane.getChildren().isEmpty()){
            onizlemPane.getChildren().clear();
        }
        onizlemPane.setAlignment(Pos.CENTER);
        onizlemPane.getChildren().add(view);
        //Text text = new Text(textler[0]);
        text.setText(textler[0]);
        text.setFont(Font.font(fontisim[0], FontBoyutlari[0]));
        text.setTranslateX(xKoordinatlar[0]);
        text.setTranslateY(xKoordinatlar[1]);
        text.setFill(Color.BLACK);
        //Text text2 = new Text(textler[1]);
        text2.setText(textler[1]);
        text2.setFont(Font.font(fontisim[1], FontBoyutlari[1]));
        text2.setTranslateX(xKoordinatlar[2]);
        text2.setTranslateY(xKoordinatlar[3]);
        text2.setFill(Color.BLACK);
        //Text text3 = new Text(textler[2]);
        text3.setText(textler[2]);
        text3.setFont(Font.font(fontisim[2], FontBoyutlari[2]));
        text3.setTranslateX(xKoordinatlar[4]);
        text3.setTranslateY(xKoordinatlar[5]);
        text3.setFill(Color.BLACK);
        //Text text4 = new Text(textler[3]);
        text4.setText(textler[3]);
        text4.setFont(Font.font(fontisim[3], FontBoyutlari[3]));
        text4.setTranslateX(xKoordinatlar[6]);
        text4.setTranslateY(xKoordinatlar[7]);
        
        text4.setFill(Color.BLACK);
        text.setTextAlignment(TextAlignment.CENTER);
        text2.setTextAlignment(TextAlignment.LEFT);
        text3.setTextAlignment(TextAlignment.LEFT);
        text4.setTextAlignment(TextAlignment.LEFT);
        onizlemPane.getChildren().addAll(text, text2, text3, text4);
        //stackPane.getChildren().addAll(Rectangle1, Rectangle2, Rectangle3, Rectangle4);

        vBox.getChildren().add(1, onizlemPane);
        }
        // if (vBox.getChildren().contains(view)) {
        //     System.out.println("view var");
        //     vBox.getChildren().remove(view);
        // }
    public StackPane OnizlemeKaydet(String string1, String string2, String string3, String string4){
        realImage = new Image(imageString);
        realView = new ImageView(realImage);
        pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().add(realView);
        //Text text = new Text(string1);
        text.setText(string1);
        text.setFont(Font.font(fontisim[0], FontBoyutlari[0]*5.85));
        text.setTextAlignment(TextAlignment.CENTER);
        text.setTranslateX(xKoordinatlar[0]*5.85);
        text.setTranslateY(xKoordinatlar[1]*5.85);
        text.setFill(Color.BLACK);
        //Text text2 = new Text(string2);
        text2.setText(string2);
        text2.setTextAlignment(TextAlignment.LEFT);
        text2.setFont(Font.font(fontisim[1], FontBoyutlari[1]*5.85));
        text2.setTranslateX(xKoordinatlar[2]*5.85);
        text2.setTranslateY(xKoordinatlar[3]*5.85);
        text2.setFill(Color.BLACK);

        //Text text3 = new Text(string3);
        text3.setTextAlignment(TextAlignment.LEFT);
        
        text3.setFont(Font.font(fontisim[2], FontBoyutlari[2]*5.85));
        text3.setTranslateX(xKoordinatlar[4]*5.85);
        text3.setTranslateY(xKoordinatlar[5]*5.85);
        text3.setFill(Color.BLACK);
        //Text text4 = new Text(string4);
        text4.setTextAlignment(TextAlignment.LEFT);
        text4.setFont(Font.font(fontisim[3], FontBoyutlari[3]*5.85));
        text4.setTranslateX(xKoordinatlar[6]*5.85);
        text4.setTranslateY(xKoordinatlar[7]*5.85);
        text4.setFill(Color.BLACK);
        pane.getChildren().addAll(text, text2, text3, text4);
        //System.out.println("Kaydetme");
        return pane;
        }
    
    public void PDFKayit(StackPane pane, String Dosyadi, ProgressBar progressBar){
        //System.out.println("PDF Kaydetme"+":"+ directory+Dosyadi+".pdf");
        File file = new File(directory+"\\"+Dosyadi+".pdf");
        convertToPDF(file, pane,progressBar);
    }
    private void convertToPDF(File file, StackPane pane, ProgressBar progressBar) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage(new org.apache.pdfbox.pdmodel.common.PDRectangle(3508, 2480));
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Resmi yükle
            //File imageFile = new File("path/to/your/image.jpg");
            Image snapshot = pane.snapshot(null, null);
            //Image image = new Image(imageFile.toURI().toString());
            PDImageXObject pdfImage = LosslessFactory.createFromImage(document, SwingFXUtils.fromFXImage(snapshot, null));
            contentStream.drawImage(pdfImage, 0, 0, 3508, 2480);

            contentStream.close();

            document.save(file);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void ResimKayit(Stage stage, StackPane pane){
        FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPEG Image", "*.jpg"));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG Image", "*.png"));
            File file = fileChooser.showSaveDialog(stage);
            if (file != null) {
                // Görüntüyü oluştur
                Image snapshot = pane.snapshot(null, null);

                // Görüntüyü dosyaya kaydet
                try {
                    ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", file);
                    LogEkle("Resim Kaydedildi");
                    realView.setImage(null);
                    pane.getChildren().clear();
                    snapshot = null;
                    pane = null;
                    
                    //System.out.println("Dosya başarıyla kaydedildi: " + file.getAbsolutePath());
                } catch (IOException e) {
                    //System.out.println("Dosya kaydedilirken bir hata oluştu: " + e.getMessage());
                }
            }
    }
    private String[] textler = new String[4];
        public void setTextler(String[] textler) {
        this.textler = textler;
    }
        
    private String[] fontisim = new String[4];
    public void setFontIsimleri(String[] fontisim2) {
        this.fontisim = fontisim2;
        }
    
        private String[][] dataStrings;
    public void dataStringAl(String[][] dataStrings) {
        this.dataStrings = dataStrings;

        //System.out.println(this.dataStrings[0][1]);
    }

        // // Mevcut StackPane'leri kaldırma
        // vBox.getChildren().removeIf(node -> node instanceof StackPane);

        // StackPane stackPane = new StackPane();
        // stackPane.setAlignment(Pos.CENTER);
        // stackPane.getChildren().add(view);

        // //stackPane.getChildren().addAll(Rectangle1, Rectangle2, Rectangle3, Rectangle4);

        // vBox.getChildren().add(1, stackPane);
        
}
    

