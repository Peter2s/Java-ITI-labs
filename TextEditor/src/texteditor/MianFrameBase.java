package texteditor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;

public  class MianFrameBase extends BorderPane {

    protected final MenuBar menuBar;
    protected final Menu fileMenu;
    protected final MenuItem newMenuItem;
    protected final MenuItem openMenuItem;
    protected final MenuItem saveMenuItem;
    protected final SeparatorMenuItem separatorMenuItem;
    protected final MenuItem exitMenuItem;
    protected final Menu editMenu;
    protected final MenuItem cutMenuItem;
    protected final MenuItem copyMenuItem;
    protected final MenuItem pasteMenuItem;
    protected final MenuItem deleteMenuItem;
    protected final MenuItem selectAllMenuItem;
    protected final Menu helpMenu;
    protected final MenuItem aboutMenuItem;
    protected final TextArea textArea;

    public MianFrameBase() {

        menuBar = new MenuBar();
        fileMenu = new Menu();
        newMenuItem = new MenuItem();
        openMenuItem = new MenuItem();
        saveMenuItem = new MenuItem();
        separatorMenuItem = new SeparatorMenuItem();
        exitMenuItem = new MenuItem();
        editMenu = new Menu();
        cutMenuItem = new MenuItem();
        copyMenuItem = new MenuItem();
        pasteMenuItem = new MenuItem();
        deleteMenuItem = new MenuItem();
        selectAllMenuItem = new MenuItem();
        helpMenu = new Menu();
        aboutMenuItem = new MenuItem();
        textArea = new TextArea();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);

        fileMenu.setMnemonicParsing(false);
        fileMenu.setText("File");

        newMenuItem.setMnemonicParsing(false);
        newMenuItem.setText("New");
        newMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
        newMenuItem.setOnAction(event -> { // exit app
            if(textArea.getText().trim().length() == 0)
                textArea.clear();
            else{
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle(" notepad");
                alert.setHeaderText("");
                alert.setContentText("Do you want save change");
                ButtonType dontSaveBtn = new ButtonType("dont save'");
                ButtonType saveBtn = new ButtonType("SAVE");
                ButtonType buttonCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
                alert.getButtonTypes().setAll(saveBtn, dontSaveBtn, buttonCancel);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == saveBtn){
                 save();
                 textArea.clear();
                }else if(result.get() == dontSaveBtn){
                    textArea.clear();
                }else{
                    
                }
                
            }
         });

        openMenuItem.setMnemonicParsing(false);
        openMenuItem.setText("Open");
        openMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
        //open
        openMenuItem.setOnAction((e)->{
            FileChooser openFileChooser = new FileChooser();
            openFileChooser.setTitle("Open File");
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("(*.txt)", "*.txt");
            openFileChooser.getExtensionFilters().add(extFilter);
            File file = openFileChooser.showOpenDialog(null);

            if (file != null) {
                 try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line = null;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line + "\n");
                    }
                    bufferedReader.close();
                    textArea.setText(stringBuilder.toString());
                } catch (IOException ex) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error ");
                    alert.setContentText("can't open this file");
                    alert.showAndWait();
                }

            }
        });
        
        
        saveMenuItem.setMnemonicParsing(false);
        saveMenuItem.setText("Save");
        saveMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        saveMenuItem.setOnAction((e)->{ //save
           save();
        });
        
        separatorMenuItem.setMnemonicParsing(false);

        exitMenuItem.setMnemonicParsing(false);
        exitMenuItem.setText("exit");
        exitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
        exitMenuItem.setOnAction(event -> { // exit app
            Platform.exit();
         });

        editMenu.setMnemonicParsing(false);
        editMenu.setText("Edit");
      

        cutMenuItem.setMnemonicParsing(false);
        cutMenuItem.setText("Cut");
        cutMenuItem.setOnAction(event -> {
            textArea.cut();
        });

        copyMenuItem.setMnemonicParsing(false);
        copyMenuItem.setText("Copy");
        copyMenuItem.setOnAction(event -> {
            textArea.copy();
        });
        

        pasteMenuItem.setMnemonicParsing(false);
        pasteMenuItem.setText("Paste");
        pasteMenuItem.setOnAction(event -> {
            textArea.paste();
        });
        

        deleteMenuItem.setMnemonicParsing(false);
        deleteMenuItem.setText("Delete");
        deleteMenuItem.setOnAction(event -> {
          textArea.deleteText(textArea.getSelection().getStart(),textArea.getSelection().getEnd());
        });
        

        selectAllMenuItem.setMnemonicParsing(false);
        selectAllMenuItem.setText("Select All");
        selectAllMenuItem.setOnAction(event -> {
            textArea.selectAll();
        });
        

        helpMenu.setMnemonicParsing(false);
        helpMenu.setText("Help");
       

        aboutMenuItem.setMnemonicParsing(false);
        aboutMenuItem.setText("About");
        aboutMenuItem.setOnAction(event -> {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About APP");
        alert.setHeaderText(null);
            alert.setContentText("this my notepad app");
        alert.showAndWait();
        });
        setTop(menuBar);

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setPrefHeight(200.0);
        textArea.setPrefWidth(200.0);
        setCenter(textArea);

        fileMenu.getItems().add(newMenuItem);
        fileMenu.getItems().add(openMenuItem);
        fileMenu.getItems().add(saveMenuItem);
        fileMenu.getItems().add(separatorMenuItem);
        fileMenu.getItems().add(exitMenuItem);
        menuBar.getMenus().add(fileMenu);
        editMenu.getItems().add(cutMenuItem);
        editMenu.getItems().add(copyMenuItem);
        editMenu.getItems().add(pasteMenuItem);
        editMenu.getItems().add(deleteMenuItem);
        editMenu.getItems().add(selectAllMenuItem);
        menuBar.getMenus().add(editMenu);
        helpMenu.getItems().add(aboutMenuItem);
        menuBar.getMenus().add(helpMenu);

    }
    public void save(){
        FileChooser saveFileChooser = new FileChooser();
        saveFileChooser.setTitle("Save File");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("(*.txt)", "*.txt");
        saveFileChooser.getExtensionFilters().add(extFilter);
        File file = saveFileChooser.showSaveDialog(null);
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(textArea.getText());
            fileWriter.close();
        } catch (IOException ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error ");
            alert.setContentText("can't save this file");
            alert.showAndWait();
        }
    }
}
