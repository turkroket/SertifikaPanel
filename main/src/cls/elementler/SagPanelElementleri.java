package cls.elementler;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import cls.fonksiyonlar.SagPanelFonksiyonlari;

public class SagPanelElementleri {
    public SagPanelFonksiyonlari sagPanelFonksiyonlari = new SagPanelFonksiyonlari();
    Button button2;
    public Label label;
    public TextField textField;
    public TextField textField1;
    public Label label1;
    public TextField textField2;
    public TextField textField3;
    public Label label2;
    public TextField textField4;
    public TextField textField5;
    public Label label3;
    public TextField textField6;
    public TextField textField7;
    public Label label4;
    public CheckBox checkBox;
    public Label label5;
    public CheckBox checkBox2;
    public HBox hBox;
    public Label label6;
    public CheckBox checkBox3;
    public Label label7;
    public CheckBox checkBox4;
    public HBox hBox2;
    public TextField textField8;
    public TextField textField9;
    public TextField textField10;
    public TextField textField11;
    public ComboBox<String> comboBox;
    public ComboBox<String> comboBox2;
    public ComboBox<String> comboBox3;
    public ComboBox<String> comboBox4;
    public HBox hBox3;
    public HBox hBox4;

    Button button;


    public void ElementrleriOlustur(){
    /*
     * GELECEK SÜRÜM İÇİN
     */
    // hBox = new HBox(5);
    // label4 = new Label("Bir No");
    // checkBox = new CheckBox("");
    // label5 = new Label("İki No");
    // checkBox2 = new CheckBox("");
    // hBox.getChildren().addAll(label4, checkBox,label5,checkBox2);
    // hBox2 = new HBox(5);
    // label6 = new Label("Üç No");
    // checkBox3 = new CheckBox("");
    // label7 = new Label("Dört No");
    // checkBox4 = new CheckBox("");
    // hBox2.getChildren().addAll(label6, checkBox3,label7,checkBox4);
    /*
     * GELECEK SÜRÜM İÇİN
     */
    
    hBox = new HBox(5);
    textField8 = new TextField("Birincil Punto");
    textField9 = new TextField("İkincil Punto");
    textField10 = new TextField("Üçüncül Punto");
    textField11 = new TextField("Dördüncül Punto");
    hBox.getChildren().addAll(textField8, textField9);
    hBox2 = new HBox(5);
    hBox2.getChildren().addAll(textField10, textField11);
    
    button2 = new Button("Şablonu Seç");
    label = new Label("Bir numaralı alanın konumu");
    textField = new TextField("X");
    textField1 = new TextField("Y");
    label1 = new Label("İki numaralı alanın konumu");
    textField2 = new TextField("X");
    textField3 = new TextField("Y");
    label2 = new Label("Üç numaralı alanın konumu");
    textField4 = new TextField("X");
    textField5 = new TextField("Y");
    label3 = new Label("Dört numaralı alanın konumu");
    textField6 = new TextField("X");
    textField7 = new TextField("Y");
    comboBox = new ComboBox<>();
    comboBox.setPromptText("Bir No Font");
    comboBox2 = new ComboBox<>();
    comboBox2.setPromptText("İki No Font");
    comboBox3 = new ComboBox<>();
    comboBox3.setPromptText("Üç No Font");
    comboBox4 = new ComboBox<>();
    comboBox4.setPromptText("Dört No Font");
    hBox3 = new HBox(5);
    hBox3.getChildren().addAll(comboBox,comboBox2);
    hBox4 = new HBox(5);
    hBox4.getChildren().addAll(comboBox3,comboBox4);
    button = new Button("<=");

    }

    public void PanelYinele(VBox rightButtons, Stage stage){
        ElementrleriOlustur();
        sagPanelFonksiyonlari.xYKoordinatlariniAl(textField,textField1,textField2,textField3,textField4,textField5,textField6,textField7);
        sagPanelFonksiyonlari.FontBuyuklugu(textField8,textField9,textField10,textField11);
        rightButtons.getChildren().addAll(button2,label,textField,textField1,label1,textField2,textField3,label2,textField4,textField5,label3,textField6,textField7,hBox,hBox2,hBox3,hBox4);
        sagPanelFonksiyonlari.FontAl(comboBox,comboBox2,comboBox3,comboBox4);
        sagPanelFonksiyonlari.Sablondegis(button2,stage);
        
        //leftButtons.getChildren().addAll();
    }
    
}
