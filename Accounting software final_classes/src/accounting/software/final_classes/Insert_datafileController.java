package accounting.software.final_classes;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class Insert_datafileController implements Initializable {
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    @FXML
    private Button button1;
    @FXML
    private Button button2;

    
    @Override
public void initialize(URL url, ResourceBundle rb) {}    

    
    
    
    
    
    
    @FXML
private void handlebuttonAction1(ActionEvent event) throws SQLException, IOException {
        Parent news=FXMLLoader.load(getClass().getResource("after_insert_datafile.fxml"));
        Scene scene=new Scene(news);
       
        Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();

    }
        
    @FXML
private void handlebuttonAction2(ActionEvent event) throws IOException{
     Parent news=FXMLLoader.load(getClass().getResource("After.fxml"));
        Scene scene=new Scene(news);
       
        Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }
    
    
}
