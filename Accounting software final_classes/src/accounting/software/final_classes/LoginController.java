package accounting.software.final_classes;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.AccessibleAction;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class LoginController implements Initializable{

   
    @FXML
    private ImageView imageview;
    @FXML
    private TextField text1;
    @FXML
    private TextField text2;
    @FXML
    private AnchorPane pen1;
    @FXML
    private Button button1;
    
     
public void initialize(URL url, ResourceBundle rb) {
       
    }  
    int count=0;
    
    @FXML
private void handleButtonAction1(ActionEvent event) throws IOException {        
       String s1=text1.getText();
       String s2=text2.getText();
       Login_class ob=new Login_class(s1,s2);
       if(ob.check()==true){
           
        Parent news=FXMLLoader.load(getClass().getResource("insert_datafile.fxml"));
        Scene scene=new Scene(news);
       
        Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
       }
       else{
       
       if(count==10){

                          JOptionPane.showMessageDialog(null, "You have tried 10 times conteniously! you have been blocked, try  later");                     
        final Node source = (Node) event.getSource();
    final Stage stage = (Stage) source.getScene().getWindow();
    stage.close();
       }
       else{
           JOptionPane.showMessageDialog(null, "Sorry Wrong Password");
       count++;
       }
       }
    
   }

}
