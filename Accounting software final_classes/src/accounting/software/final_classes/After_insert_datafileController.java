
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
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author TAMIM WASIF
 */
public class After_insert_datafileController implements Initializable {

    @FXML
    private TextField text1;
    @FXML
    private Button button1;
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {}    

    @FXML
    private void handlebuttonaction1(ActionEvent event) throws SQLException, IOException {
      
        String s1=text1.getText().toString();
        con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName="+s1+";user=tamimdb;password=tamim");
        JOptionPane.showMessageDialog(null, "You are connected");
        Parent news=FXMLLoader.load(getClass().getResource("After.fxml"));
        Scene scene=new Scene(news);
       
        Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }
    
}
