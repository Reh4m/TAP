package sample.proyectoloteria.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Parser extends Stage {
    private Scene scene;
    private VBox v_box;
    private ToolBar tool_bar_menu;
    private TextArea txt_input, txt_output;
    private FileChooser flc_file;
    private Button btn_open;

    public Parser() {
        createUI();
        this.setTitle("Traductor de código morse");
        this.setScene(scene);
        this.show();
    }

    private void createUI() {
        v_box = new VBox();
        tool_bar_menu = new ToolBar();
        btn_open = new Button("Click");

        tool_bar_menu.getItems().addAll(btn_open);
        v_box.getChildren().addAll(tool_bar_menu);
        scene = new Scene(v_box, 500, 300);
    }
}
