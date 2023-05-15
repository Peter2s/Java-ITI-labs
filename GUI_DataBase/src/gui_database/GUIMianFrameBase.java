package gui_database;

import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.*;


public  class GUIMianFrameBase extends Pane {

    protected final Text text;
    protected final TextField idField;
    protected final Text text0;
    protected final TextField fNameField;
    protected final Text text1;
    protected final TextField mNameField;
    protected final Text text2;
    protected final TextField lNameField;
    protected final Text text3;
    protected final TextField emailField;
    protected final Text text4;
    protected final TextField phoneField;
    protected final Button newBtn;
    protected final Button updateBtn;
    protected final Button deleteBtn;
    protected final Button firstBtn;
    protected final Button prevBtn;
    protected final Button nextBtn;
    protected final Button lastBtn;
    protected final Separator separator;
    protected final Separator separator0;
    protected final Separator separator1;
    protected final Separator separator2;
    protected final Separator separator3;
    protected final Text text5;
   

    public GUIMianFrameBase() {

        text = new Text();
        idField = new TextField();
        text0 = new Text();
        fNameField = new TextField();
        text1 = new Text();
        mNameField = new TextField();
        text2 = new Text();
        lNameField = new TextField();
        text3 = new Text();
        emailField = new TextField();
        text4 = new Text();
        phoneField = new TextField();
        newBtn = new Button();
        updateBtn = new Button();
        deleteBtn = new Button();
        firstBtn = new Button();
        prevBtn = new Button();
        nextBtn = new Button();
        lastBtn = new Button();
        separator = new Separator();
        separator0 = new Separator();
        separator1 = new Separator();
        separator2 = new Separator();
        separator3 = new Separator();
        text5 = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
            
        text.setLayoutX(64.0);
        text.setLayoutY(83.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("ID");
        text.setFont(new Font("System Bold", 14.0));
        
     
        idField.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        idField.setLayoutX(164.0);
        idField.setLayoutY(65.0);
        idField.setPrefHeight(26.0);
        idField.setPrefWidth(196.0);
        idField.setDisable(true);

        text0.setLayoutX(44.0);
        text0.setLayoutY(128.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("First Name");
        text0.setFont(new Font("System Bold", 14.0));

        fNameField.setLayoutX(164.0);
        fNameField.setLayoutY(110.0);
        fNameField.setPrefHeight(26.0);
        fNameField.setPrefWidth(323.0);

        text1.setLayoutX(35.0);
        text1.setLayoutY(173.0);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("Middle Name");
        text1.setFont(new Font("System Bold", 14.0));

        mNameField.setLayoutX(164.0);
        mNameField.setLayoutY(155.0);
        mNameField.setPrefHeight(26.0);
        mNameField.setPrefWidth(323.0);

        text2.setLayoutX(45.0);
        text2.setLayoutY(218.0);
        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);
        text2.setText("Last Name");
        text2.setFont(new Font("System Bold", 14.0));

        lNameField.setLayoutX(164.0);
        lNameField.setLayoutY(200.0);
        lNameField.setPrefHeight(26.0);
        lNameField.setPrefWidth(323.0);


        text3.setLayoutX(54.0);
        text3.setLayoutY(263.0);
        text3.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text3.setStrokeWidth(0.0);
        text3.setText("Email");
        text3.setFont(new Font("System Bold", 14.0));

        emailField.setLayoutX(164.0);
        emailField.setLayoutY(245.0);
        emailField.setPrefHeight(26.0);
        emailField.setPrefWidth(323.0);

        text4.setLayoutX(51.0);
        text4.setLayoutY(308.0);
        text4.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text4.setStrokeWidth(0.0);
        text4.setText("Phone");
        text4.setFont(new Font("System Bold", 14.0));

        phoneField.setLayoutX(164.0);
        phoneField.setLayoutY(290.0);
        phoneField.setPrefHeight(26.0);
        phoneField.setPrefWidth(196.0);

        newBtn.setLayoutX(74.0);
        newBtn.setLayoutY(336.0);
        newBtn.setMinHeight(10.0);
        newBtn.setMnemonicParsing(false);
        newBtn.setPrefHeight(33.0);
        newBtn.setPrefWidth(58.0);
        newBtn.setText("New");

        updateBtn.setLayoutX(144.0);
        updateBtn.setLayoutY(336.0);
        updateBtn.setMinHeight(10.0);
        updateBtn.setMnemonicParsing(false);
        updateBtn.setPrefHeight(33.0);
        updateBtn.setPrefWidth(58.0);
        updateBtn.setText("Update");

        deleteBtn.setLayoutX(213.0);
        deleteBtn.setLayoutY(336.0);
        deleteBtn.setMinHeight(10.0);
        deleteBtn.setMnemonicParsing(false);
        deleteBtn.setPrefHeight(33.0);
        deleteBtn.setPrefWidth(58.0);
        deleteBtn.setText("Delete");

        firstBtn.setLayoutX(280.0);
        firstBtn.setLayoutY(336.0);
        firstBtn.setMinHeight(10.0);
        firstBtn.setMnemonicParsing(false);
        firstBtn.setPrefHeight(33.0);
        firstBtn.setPrefWidth(58.0);
        firstBtn.setText("First");

        prevBtn.setLayoutX(347.0);
        prevBtn.setLayoutY(336.0);
        prevBtn.setMinHeight(10.0);
        prevBtn.setMnemonicParsing(false);
        prevBtn.setPrefHeight(33.0);
        prevBtn.setPrefWidth(58.0);
        prevBtn.setText("Previous");
        prevBtn.setFont(new Font(10.0));

        nextBtn.setLayoutX(414.0);
        nextBtn.setLayoutY(336.0);
        nextBtn.setMinHeight(10.0);
        nextBtn.setMnemonicParsing(false);
        nextBtn.setPrefHeight(33.0);
        nextBtn.setPrefWidth(58.0);
        nextBtn.setText("Next");

        lastBtn.setLayoutX(482.0);
        lastBtn.setLayoutY(336.0);
        lastBtn.setMinHeight(10.0);
        lastBtn.setMnemonicParsing(false);
        lastBtn.setPrefHeight(33.0);
        lastBtn.setPrefWidth(58.0);
        lastBtn.setText("Last");

        separator.setLayoutX(9.0);
        separator.setLayoutY(24.0);
        separator.setPrefHeight(3.0);
        separator.setPrefWidth(100.0);

        separator0.setLayoutX(240.0);
        separator0.setLayoutY(25.0);
        separator0.setPrefHeight(3.0);
        separator0.setPrefWidth(334.0);

        separator1.setLayoutX(11.0);
        separator1.setLayoutY(23.0);
        separator1.setOrientation(javafx.geometry.Orientation.VERTICAL);
        separator1.setPrefHeight(357.0);
        separator1.setPrefWidth(6.0);

        separator2.setLayoutX(13.0);
        separator2.setLayoutY(381.0);
        separator2.setPrefHeight(3.0);
        separator2.setPrefWidth(561.0);

        separator3.setLayoutX(574.0);
        separator3.setLayoutY(25.0);
        separator3.setOrientation(javafx.geometry.Orientation.VERTICAL);
        separator3.setPrefHeight(357.0);
        separator3.setPrefWidth(6.0);

        text5.setLayoutX(132.0);
        text5.setLayoutY(33.0);
        text5.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text5.setStrokeWidth(0.0);
        text5.setText("Person Info");
        text5.setWrappingWidth(89.99999999999994);
        text5.setFont(new Font("System Italic", 14.0));
                
        getChildren().add(text);
        getChildren().add(idField);
        getChildren().add(text0);
        getChildren().add(fNameField);
        getChildren().add(text1);
        getChildren().add(mNameField);
        getChildren().add(text2);
        getChildren().add(lNameField);
        getChildren().add(text3);
        getChildren().add(emailField);
        getChildren().add(text4);
        getChildren().add(phoneField);
        getChildren().add(newBtn);
        getChildren().add(updateBtn);
        getChildren().add(deleteBtn);
        getChildren().add(firstBtn);
        getChildren().add(prevBtn);
        getChildren().add(nextBtn);
        getChildren().add(lastBtn);
        getChildren().add(separator);
        getChildren().add(separator0);
        getChildren().add(separator1);
        getChildren().add(separator2);
        getChildren().add(separator3);
        getChildren().add(text5);

    }
}
