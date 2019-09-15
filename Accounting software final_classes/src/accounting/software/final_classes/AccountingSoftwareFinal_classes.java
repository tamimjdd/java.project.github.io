
package accounting.software.final_classes;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.Properties;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class AccountingSoftwareFinal_classes extends Application{

    public static void main(String[] args) throws IOException{
    Application.launch(args);
    }
    public Stage mainStage;
    
        public void start(Stage stage) throws Exception {
        this.mainStage = stage;
        stage.setOnCloseRequest(confirmCloseEventHandler);
        
        Button closeButton = new Button("Close Application");
        closeButton.setOnAction(event ->
        stage.fireEvent(
        new WindowEvent(
        stage,
        WindowEvent.WINDOW_CLOSE_REQUEST)
        )
        );
        
        
        
        stage.setTitle("LOG IN");
        Parent root=FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    

        private EventHandler<WindowEvent> confirmCloseEventHandler = (WindowEvent event) -> {
        int flag=0;   
        
        
         Alert closeConfirmation = new Alert(
         Alert.AlertType.CONFIRMATION,
         "Are you sure you want to exit?"
                
        );
           
        Button exitButton = (Button) closeConfirmation.getDialogPane().lookupButton(
        ButtonType.OK
        );
                          

        exitButton.setText("Exit");
        closeConfirmation.setHeaderText("Confirm Exit");
        closeConfirmation.initModality(Modality.APPLICATION_MODAL);
        closeConfirmation.initOwner(mainStage);



        Optional<ButtonType> closeResponse = closeConfirmation.showAndWait();
        if (!ButtonType.OK.equals(closeResponse.get())) {
        event.consume();
        flag=1;
        }
        if(flag==0){
        Properties prop = new Properties();
        OutputStream output = null;
        OutputStream output2=null;
        try {
        output = new FileOutputStream("D://accounting/new.properties");
        output2=new FileOutputStream("D://config3.properties");
        }
        catch(Exception e){
        System.out.println(e);
        }
        prop.clear();
           
        }
};
}
    
