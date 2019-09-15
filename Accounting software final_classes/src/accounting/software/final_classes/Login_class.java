package accounting.software.final_classes;
import java.io.IOException;
import java.util.Objects;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;




public class Login_class {
    public String name;
    public String password;
    
public Login_class(String name1,String password1){
    this.name=name1;
    this.password=password1;
    }

public boolean check(){
       
       System.out.println(this.name);
       System.out.println(this.password);
    if(Objects.equals(this.name, "tamim")==true && Objects.equals(this.password,"wasif")==true){return true;}
    else if(Objects.equals(this.name, "nahid")==true && Objects.equals(this.password,"shafee")==true){return true;}
    else if(Objects.equals(this.name, "Oishee")==true && Objects.equals(this.password,"zaman")==true){return true;}    
    {return false;}
    }

}
