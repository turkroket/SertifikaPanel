package cls.GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import cls.elementler.*;

public class In {
    
    SolOnizleme SPO = new SolOnizleme();
    OrtaPanelElementleri OPA = new OrtaPanelElementleri();
    SolPanelElementleri SPA = new SolPanelElementleri();
    SagPanelElementleri SGA = new SagPanelElementleri();
    SagOnizleme SPG = new SagOnizleme();


    public VBox solonizleme;
    public VBox leftButtons;
    public VBox rightButtons;
    public VBox sagonlizleme;
    public VBox centerbuttons;
    public HBox mainHBox;
    public HBox StageDuzeniOlustur(){
        SGA.sagPanelFonksiyonlari.setSolOnizlemeFonk(SPO.solOnizlemeFonk);
        SGA.sagPanelFonksiyonlari.SagOnizlemeFonk(SPG.fonk);
        solonizleme = new VBox(10);
        solonizleme.setAlignment(Pos.TOP_LEFT);
        solonizleme.setPadding(new Insets(10));
        leftButtons = new VBox(10);
        leftButtons.setAlignment(Pos.BASELINE_LEFT);
        leftButtons.setPadding(new Insets(10));
        rightButtons = new VBox(10);
        rightButtons.setAlignment(Pos.BASELINE_RIGHT);
        rightButtons.setPadding(new Insets(10));
        // create a VBox for right side buttons
        sagonlizleme = new VBox(10);
        sagonlizleme.setAlignment(Pos.TOP_RIGHT);
        centerbuttons = new VBox(10);
        centerbuttons.setAlignment(Pos.BASELINE_CENTER);
        centerbuttons.setPadding(new Insets(10));
        mainHBox = new HBox(10);
        mainHBox.setAlignment(Pos.TOP_CENTER);
        mainHBox.setPadding(new Insets(10));
        mainHBox.getChildren().addAll(solonizleme, leftButtons, centerbuttons, rightButtons, sagonlizleme);
        mainHBox.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
        //mainHBox.getStyleClass().add("main-hbox");
        return mainHBox;
    }
    public void StageDuzeniGuncelle(Stage stage){
        SPO.PanelYinele(solonizleme);
        OPA.PanelYinele(centerbuttons);
        SGA.PanelYinele(rightButtons, stage);
        SPA.PanelYinele(leftButtons);
        SPG.PanelYinele(sagonlizleme);
    }
    
}
