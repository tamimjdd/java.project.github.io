package accounting.software.final_classes;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.Optional;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author tamimwasif
 */
public class AfterController implements Initializable {
    public int[] arr=new int[100];
    public int Ledgerflag;
    public int balancesheettableval;
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    int flag=0;
    public static final ObservableList name = FXCollections.observableArrayList();
    public static final ObservableList nameoftables = FXCollections.observableArrayList();  
    LedgermainController obarraysending=new LedgermainController(); 
    //methods for table creation type -> 
    public int val=0;
    After_class objectpass=new After_class();
    Random rand=new Random();
    public int  mtemp = rand.nextInt(1000) + 1;
    @FXML
    private CheckBox check1;
    @FXML
    private CheckBox check2;
    @FXML
    private CheckBox check3;
    @FXML
    private CheckBox check4;
    @FXML
    private CheckBox check5;
    @FXML
    private CheckBox check6;
    @FXML
    private Button button2;
    @FXML
    private Button buttonadd;
    @FXML
    private Button button1;
    @FXML
    private TextField text1;
    @FXML
    private TextField text2;
    @FXML
    private MenuItem asset1;
    @FXML
    private MenuItem libility1;
    @FXML
    private MenuItem revenue1;
    @FXML
    private MenuItem expence1;
    @FXML
    private MenuItem oc1;
    @FXML
    private MenuItem od1;
    @FXML
    private Button button3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {}   
    
    public void method(String tablename,String valueoftabletype){
    Properties prop = new Properties();
    OutputStream output = null;
    try {

    output = new FileOutputStream("D://config3.properties",true);

    // set the properties value
    prop.setProperty("tablenames"+val,tablename);
    prop.setProperty("tabletype"+val,valueoftabletype);
    val++;
    // save properties to project root folder
    prop.store(output, null);
    } catch (IOException io) {
    io.printStackTrace();
    } finally {
    if (output != null) {
    try {
    output.close();
    } catch (IOException e) {
    e.printStackTrace();
    }
    }

}
}
    

    
    public void Method2(int x1) throws FileNotFoundException, IOException{
     Properties prop = new Properties();
     InputStream input = null;
     input = new FileInputStream("D://config3.properties");
     prop.load(input);
    
     for(int i=0;i<x1;i++){
     objectpass.stringarr[i]=prop.getProperty("tablenames"+i);
     Integer x2=Integer.valueOf(prop.getProperty("tabletype"+i));
     
     objectpass.tablearrayforbutton[i]=x2;
     }
     
     objectpass.indxarr=x1;
     objectpass.indxarrforbutton=x1;
        
               
}
    
    
    
    
     @FXML
    private void asse1(ActionEvent event) {
         try{
    Properties prop = new Properties();
    InputStream input = null;
    input = new FileInputStream("D://accounting/new.properties");
    prop.load(input);
    String vals=prop.getProperty("valueanother");
    Integer x1=0;
    x1= Integer.valueOf(vals);
        
    if(objectpass.indxarr==0  &&  x1!=0){
        
    this.val=this.val+x1;
    Method2(this.val);
    
}

    objectpass.tablearrayforbutton[objectpass.indxarrforbutton]=1;
    objectpass.indxarrforbutton++;
    objectpass.stringarr[objectpass.indxarr]=text1.getText();
    objectpass.indxarr++;
  

method(text1.getText(),"1");
for(int i=0;i<objectpass.indxarr;i++){
System.out.println(objectpass.tablearrayforbutton[i]);
}
    }
    catch(Exception e){
    objectpass.tablearrayforbutton[objectpass.indxarrforbutton]=1;
    objectpass.indxarrforbutton++;
    objectpass.stringarr[objectpass.indxarr]=text1.getText();
    objectpass.indxarr++;
  
method(text1.getText(),"1");
for(int i=0;i<objectpass.indxarr;i++){
System.out.println(objectpass.tablearrayforbutton[i]);
}
    }
}

    @FXML
    private void libility1(ActionEvent event) {
         objectpass.tablearrayforbutton[objectpass.indxarrforbutton]=2;
         objectpass.indxarrforbutton++;
         objectpass.stringarr[objectpass.indxarr]=text1.getText();
         objectpass.indxarr++;
         method(text1.getText(),"2");
         
    }

    @FXML
    private void revenue1(ActionEvent event) throws FileNotFoundException, IOException {
         Properties prop = new Properties();
	        InputStream input = null;
		input = new FileInputStream("D://config3.properties");
		prop.load(input);
                String vals=prop.getProperty("value");
                
                Integer x1 = Integer.valueOf(vals);
                System.out.println(x1);
if(objectpass.indxarr==0 && x1!=0){
Method2(this.val);
}
                objectpass.tablearrayforbutton[objectpass.indxarrforbutton]=3;
                objectpass.indxarrforbutton++;
                objectpass.stringarr[objectpass.indxarr]=text1.getText();
                objectpass.indxarr++;
         method(text1.getText(),"3");
    }

    @FXML
    private void expence1(ActionEvent event) {
         objectpass.tablearrayforbutton[objectpass.indxarrforbutton]=4;
         objectpass.indxarrforbutton++;
         objectpass.stringarr[objectpass.indxarr]=text1.getText();
         objectpass.indxarr++;
                  method(text1.getText(),"4");
    }

    @FXML
    private void oc1(ActionEvent event) {
        objectpass.tablearrayforbutton[objectpass.indxarrforbutton]=5;
        objectpass.indxarrforbutton++;
        objectpass.stringarr[objectpass.indxarr]=text1.getText();
        objectpass.indxarr++;
         method(text1.getText(),"5");
    }

    @FXML
    private void od1(ActionEvent event) {
        objectpass.tablearrayforbutton[objectpass.indxarrforbutton]=6;
        objectpass.indxarrforbutton++;
        objectpass.stringarr[objectpass.indxarr]=text1.getText();
        objectpass.indxarr++;
        method(text1.getText(),"6");

    }




    @FXML
    private void handlebuttonoactionadd(ActionEvent event) {
         int flag2=0,j=0;
             String s2=text1.getText();
    
             Balance_SheetController ob5=new Balance_SheetController();
        


     
         
             try{      
             String Sql="Create table " +text1.getText().toString()+
             "(Account_Title varchar(50)," +
             "Debit bigInt," +
             "Credit bigInt)";
        
        
               if(j>0){
             for(int i=0;i<=name.size();i++){
             if(name.get(i)==s2){
             flag2=1;
             }
             }
             }
              
           
        
             if(flag==0){    
             TrialBalanceController ob4=new TrialBalanceController();
             ob4.TrialBalanceController2();
             this.balancesheettableval=ob5.Balance_Sheet();
             ob5.Income_Statement();
             flag++;
             }

             con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Accounts;user=tamimdb;password=tamim");
             pst=con.prepareStatement(Sql);
             pst.executeUpdate();
             
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setHeaderText("Results:");
             alert.setContentText("Created table"+text1.getText());
             alert.showAndWait();
        
             LedgermainController ob2=new LedgermainController(s2);
             this.name.add(s2);
              
               if(flag2==0){
             TrialBalanceController ob3=new TrialBalanceController();
             ob3.TrialBalanceController3(s2);
             flag2++;
             }
              
              
             }
              

                  
        
catch(Exception se){
               int x;          
                
               if(check6.isSelected()){//owners drawings
               x=6;
               
               LedgermainController ob=new LedgermainController(x);
               
               try{
               String Sql="insert into "+ text1.getText()+" values(?,?,?)";
               con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Accounts;user=tamimdb;password=tamim");
               pst=con.prepareStatement(Sql);
               pst.setString(1,text1.getText());
               pst.setString(2," ");
               pst.setString(3,text2.getText());
               pst.executeUpdate();
               
               
               
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setHeaderText("Results:");
               alert.setContentText("Inserted successfully");
               alert.showAndWait();
               
               try{
                   System.out.println("yes its in try");
               Properties prop = new Properties();
               InputStream input = null;
               input = new FileInputStream("D://accounting/new.properties");
               prop.load(input);
               String vals=prop.getProperty("valueanother");
               Integer x1=0;
               x1= Integer.valueOf(vals);
               this.val=x1;
               System.out.println("the value of val is,this is 1st"+this.val);
               Method2(this.val);
                              obarraysending.method_for_TrialBalance(text1.getText(),this.val,objectpass.tablearrayforbutton,objectpass.stringarr,this.val);
               }catch(Exception fileex){
                                      System.out.println("yes its in catch now");
                                  System.out.println("the value of val is,this is in catch"+this.val);
                              obarraysending.method_for_TrialBalance(text1.getText(),this.val,objectpass.tablearrayforbutton,objectpass.stringarr,this.val);
               }

               
               }catch(Exception exx){
               System.out.println(exx);
               }
              }
              
              
              
              
              
              
              else if(check1.isSelected()){ //Assets
              x=1;
              LedgermainController ob=new LedgermainController(x);
              try{
            
              String Sql="insert into "+ text1.getText()+" values(?,?,?)";
              con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Accounts;user=tamimdb;password=tamim");
              pst=con.prepareStatement(Sql);
              pst.setString(1,text1.getText());
              pst.setString(2,text2.getText());
              pst.setString(3," ");
              pst.executeUpdate();
              
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setHeaderText("Results:");
              alert.setContentText("Inserted successfully");
              alert.showAndWait();
              obarraysending.method_for_TrialBalance(text1.getText(),objectpass.indxarr,objectpass.tablearrayforbutton,objectpass.stringarr,objectpass.indxarrforbutton);
              }catch(Exception exx){
              System.out.println("yessssss error");
              System.out.println(exx);
             }
            }
              
              
              
              else if(check2.isSelected()){//Libilities
              x=2;
              LedgermainController ob=new LedgermainController(x);
              try{
              String Sql="insert into "+ text1.getText()+" values(?,?,?)";
              con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Accounts;user=tamimdb;password=tamim");
              pst=con.prepareStatement(Sql);
              pst.setString(1,text1.getText());
              pst.setString(2," ");
              pst.setString(3,text2.getText());
              pst.executeUpdate();
              
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setHeaderText("Results:");
              alert.setContentText("Inserted successfully");
              alert.showAndWait();
              obarraysending.method_for_TrialBalance(text1.getText(),objectpass.indxarr,objectpass.tablearrayforbutton,objectpass.stringarr,objectpass.indxarrforbutton);
              }catch(Exception exx){    
              System.out.println(exx);
              }
              }
              
              
              
              
              else if(check3.isSelected()){//revenue
              x=3;
              LedgermainController ob=new LedgermainController(x);
              try{
              String Sql="insert into "+ text1.getText()+" values(?,?,?)";
              con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Accounts;user=tamimdb;password=tamim");
              pst=con.prepareStatement(Sql);
              pst.setString(1,text1.getText());
              pst.setString(2," ");
              pst.setString(3,text2.getText());
              pst.executeUpdate();
              
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setHeaderText("Results:");
              alert.setContentText("Inserted successfully");
              alert.showAndWait();
               obarraysending.method_for_TrialBalance(text1.getText(),objectpass.indxarr,objectpass.tablearrayforbutton,objectpass.stringarr,objectpass.indxarrforbutton);
              }catch(Exception exx){
                  
              System.out.println(exx);
              }
             }
              
              
              
              else if(check4.isSelected()){//expence
              x=4;
              LedgermainController ob=new LedgermainController(x);
              try{
              String Sql="insert into "+ text1.getText()+" values(?,?,?)";
              con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Accounts;user=tamimdb;password=tamim");
              pst=con.prepareStatement(Sql);
              pst.setString(1,text1.getText());
              pst.setString(2,text2.getText());
              pst.setString(3," ");
              pst.executeUpdate();
              
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setHeaderText("Results:");
              alert.setContentText("Inserted successfully");
              alert.showAndWait();
               obarraysending.method_for_TrialBalance(text1.getText(),objectpass.indxarr,objectpass.tablearrayforbutton,objectpass.stringarr,objectpass.indxarrforbutton);
              }catch(Exception exx){
                
              System.out.println(exx);
              }
             }
              
              
              
              
              
              else if(check5.isSelected()){//owners capital
              x=5;
              LedgermainController ob=new LedgermainController(x);
              try{
              String Sql="insert into "+ text1.getText()+" values(?,?,?)";
              con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Accounts;user=tamimdb;password=tamim");
              pst=con.prepareStatement(Sql);
              pst.setString(1,text1.getText());
              pst.setString(2,text2.getText());
              pst.setString(3," ");
              pst.executeUpdate();
               
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setHeaderText("Results:");
               alert.setContentText("Inserted successfully");
               alert.showAndWait();
              obarraysending.method_for_TrialBalance(text1.getText(),objectpass.indxarr,objectpass.tablearrayforbutton,objectpass.stringarr,objectpass.indxarrforbutton);
              }catch(Exception exx){
                
              System.out.println(exx);
              }
             }
        }
             
        
    }

    @FXML
    private void handlebuttonoactionbutton1(ActionEvent event) throws FileNotFoundException, IOException {
        try{ 
          Properties prop1 = new Properties();
          InputStream input = null;
          input = new FileInputStream("D://accounting/new.properties");
          prop1.load(input);
          String vals=prop1.getProperty("valueanother");
          Integer x1=0;
          x1= Integer.valueOf(vals);
        
    if(x1==0){
        Properties prop = new Properties();
	OutputStream output = null;
        output = new FileOutputStream("D://accounting/new.properties");
	prop.setProperty("valueanother",""+this.val);
        prop.store(output, null);
    }
        }catch(Exception filebalance){
        Properties prop = new Properties();
	OutputStream output = null;
        output = new FileOutputStream("D://accounting/new.properties");
	prop.setProperty("valueanother",""+this.val);
        prop.store(output, null);
        }
        
        
                
        Parent news=FXMLLoader.load(getClass().getResource("Trial Balance.fxml"));
        Scene scene=new Scene(news);
        Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
        TrialBalanceController ob=new TrialBalanceController();
        ob.buildData();
    }

   

    @FXML
    private void handlebuttonoactionbutton3(ActionEvent event) throws FileNotFoundException, IOException {
        try{ 
        Properties prop1 = new Properties();
          InputStream input = null;
          input = new FileInputStream("D://accounting/new.properties");
          prop1.load(input);
          String vals=prop1.getProperty("valueanother");
          Integer x1=0;
          x1= Integer.valueOf(vals);
        
    if(x1==0){
        Properties prop = new Properties();
	OutputStream output = null;
        output = new FileOutputStream("D://accounting/new.properties");
	prop.setProperty("valueanother",""+this.val);
        prop.store(output, null);
    }
        }catch(Exception filebalance){
        Properties prop = new Properties();
	OutputStream output = null;
        output = new FileOutputStream("D://accounting/new.properties");
	prop.setProperty("valueanother",""+this.val);
        prop.store(output, null);
        }
                
        Parent news=FXMLLoader.load(getClass().getResource("Balance_Sheet.fxml"));
        Scene scene=new Scene(news);
        
        Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setTitle("Ledger Tables");
        app_stage.setScene(scene);
        app_stage.show();
}
    
        @FXML
    private void handlebuttonoactionbutton2(ActionEvent event) throws FileNotFoundException, IOException {
               
                
          try{ 
          Properties prop1 = new Properties();
          InputStream input = null;
          input = new FileInputStream("D://accounting/new.properties");
          prop1.load(input);
          String vals=prop1.getProperty("valueanother");
          Integer x1=0;
          x1= Integer.valueOf(vals);
        
    if(x1==0){
        Properties prop = new Properties();
	OutputStream output = null;
        output = new FileOutputStream("D://accounting/new.properties");
	prop.setProperty("valueanother",""+this.val);
        prop.store(output, null);
    }
        }catch(Exception filebalance){
        Properties prop = new Properties();
	OutputStream output = null;
        output = new FileOutputStream("D://accounting/new.properties");
	prop.setProperty("valueanother",""+this.val);
        prop.store(output, null);
        }
                
                
                Parent news=FXMLLoader.load(getClass().getResource("Ledgermain.fxml"));
                Scene scene=new Scene(news);
        
                Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setTitle("Ledger Tables");
                app_stage.setScene(scene);
                app_stage.show();
    }
    
}
