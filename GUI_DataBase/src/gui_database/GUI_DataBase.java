package gui_database;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.sql.DataSource;

public class GUI_DataBase extends Application {

    private boolean updateFlag = true;
    private void printData(GUIMianFrameBase root,ResultSet resultSet) throws SQLException{
        root.idField.setText(""+resultSet.getInt(1));
        root.fNameField.setText(resultSet.getString(2));
        root.mNameField.setText(resultSet.getString(9));
        root.lNameField.setText(resultSet.getString(3));
        root.phoneField.setText(resultSet.getString(7));
        root.emailField.setText(resultSet.getString(10));
    }
    @Override
    public void start(Stage primaryStage) {
        
        GUIMianFrameBase root = new GUIMianFrameBase();
        
         try {
            ResultSet resultSet= getResultSet();
            resultSet.next();
            printData(root,resultSet);
            root.prevBtn.setDisable(true);
            root.firstBtn.setOnAction((event) -> {
                root.nextBtn.setDisable(false);
                try {
                   resultSet.first();
                   printData(root,resultSet);
                   root.prevBtn.setDisable(true);
                } catch (SQLException ex) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error ");
                    alert.setContentText(ex.getMessage());
                    alert.showAndWait();
                    System.out.println(ex.getMessage());
                }
            });
            root.lastBtn.setOnAction((event) -> {
                try {
                    resultSet.last();
                     printData(root,resultSet);
                     root.prevBtn.setDisable(false);
                     root.nextBtn.setDisable(true);
                } catch (SQLException ex) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error ");
                    alert.setContentText(ex.getMessage());
                    alert.showAndWait();

                    System.out.println(ex.getMessage());
                }
            });
            root.nextBtn.setOnAction((event) -> {
                try {
                    root.prevBtn.setDisable(false);
                    if (!resultSet.isLast()) {
                        resultSet.next();
                         printData(root,resultSet);
                         root.prevBtn.setDisable(false);
                    }else{
                        root.nextBtn.setDisable(true);
                         Alert alert = new Alert(AlertType.ERROR);
                         alert.setTitle("Error ");
                         alert.setContentText("this the last emp");
                         alert.showAndWait();
                    }
                } catch (SQLException ex) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error ");
                    alert.setContentText(ex.getMessage());
                    alert.showAndWait();

                   System.out.println(ex.getMessage());
                }
            });
            root.prevBtn.setOnAction((event) -> {
                try {
                    root.nextBtn.setDisable(false);
                    if (!resultSet.isFirst()) {
                        root.prevBtn.setDisable(false);
                        resultSet.previous();
                        printData(root,resultSet);
                    }else{
                      root.prevBtn.setDisable(true);
                       Alert alert = new Alert(AlertType.ERROR);
                       alert.setTitle("Error ");
                       alert.setContentText("this the first emp");
                       alert.showAndWait();
                    }

                } catch (SQLException ex) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error ");
                    alert.setContentText(ex.getMessage());
                    alert.showAndWait();
                    System.out.println(ex.getMessage());
                }
            });
            root.newBtn.setOnAction((event) -> {
                root.idField.setText("");
                root.fNameField.setText("");
                root.mNameField.setText("");
                root.lNameField.setText("");
                root.emailField.setText("");
                root.phoneField.setText("");
                updateFlag = false  ; 
            });
        //=============== UPDATE ===================
        root.updateBtn.setOnAction((event) -> {
            System.out.println("The State of Update Flag is : " + updateFlag);
            if (updateFlag)
            {
            try {
                //resultSet.updateString("id", root.idField.getText());
                resultSet.updateString("F_Name", root.fNameField.getText());
                resultSet.updateString("M_Name", root.mNameField.getText());
                resultSet.updateString("L_Name", root.lNameField.getText());
                resultSet.updateString("email", root.emailField.getText());
                resultSet.updateString("Phone_Number", root.phoneField.getText());
                resultSet.updateRow();
                } catch (SQLException e) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error ");
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                    System.out.println(e.getMessage());
                }
            }
            else 
            {
                try {
                resultSet.moveToInsertRow();
                resultSet.updateString("id","0");
                resultSet.updateString("F_Name", root.fNameField.getText());
                resultSet.updateString("M_Name", root.mNameField.getText());
                resultSet.updateString("L_Name", root.lNameField.getText());
                resultSet.updateString("email", root.emailField.getText());
                resultSet.updateString("Phone_Number", root.phoneField.getText());
                resultSet.insertRow();
                updateFlag = true  ; // So that No New Insertion 
                } catch (SQLException e) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error ");
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                    System.out.println(e.getMessage());
                }
            }
                              
        }); 
          root.deleteBtn.setOnAction((event) -> {
            try {
            resultSet.deleteRow();
            root.idField.setText("");
            root.fNameField.setText("");
            root.mNameField.setText("");
            root.lNameField.setText("");
            root.emailField.setText("");
            root.phoneField.setText("");
       
            
            if (resultSet.isAfterLast())
            {
                resultSet.previous();
                printData(root, resultSet);
            }
            else  if (resultSet.isBeforeFirst())
            {
              resultSet.next(); 
              printData(root, resultSet);
            }
            else {
                resultSet.next() ; 
                printData(root, resultSet);
            }
            
            } catch (SQLException e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error ");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
                System.out.println(e.getMessage());
            }
       
        }); // updateButton Event END  == DELETE
           

        } catch (SQLException ex) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error ");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            System.out.println(ex.getMessage());
        }
           
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("DataBase App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void setPropFile(){
        Properties prop = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream("connection.properties");
            prop.setProperty("BD_URL", "jdbc:mysql://localhost:3306/user");
            prop.setProperty("BD_USERNAME", "root");
            prop.setProperty("BD_PASSWORD", "PeterITI");
            prop.store(output, null);
        }catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
        }
    }
 
    public static Connection dataBaseConn() throws SQLException {
        DataSource ds = DataSourceFactory.getMySQLDataSource();
        Connection conn = ds.getConnection();
        return conn;
    }
    public static ResultSet getResultSet() throws SQLException {
    Connection conn = dataBaseConn();
    java.sql.Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_UPDATABLE , ResultSet.HOLD_CURSORS_OVER_COMMIT);
    ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
    return resultSet;
    }
    public static void main(String[] args){
       setPropFile();
       try {
          ResultSet resultSet = getResultSet();
       }catch(SQLException e){
           System.out.println(e.getMessage());
       }
       launch(args);
    }
    
}
