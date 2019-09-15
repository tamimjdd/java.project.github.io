package accounting.software.final_classes;
import static accounting.software.final_classes.TrialBalanceController.data3;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.JOptionPane;
import java.util.Random;
import javafx.scene.control.Button;






public class Balance_SheetController implements Initializable {

    @FXML
    private MenuItem button1;
    @FXML
    private MenuItem button2;
    @FXML
    private MenuItem button3;
    @FXML
    private TableView table3;
    @FXML
    private Button button22;
  
    Random rand = new Random();
    public int  m = rand.nextInt(1000) + 1;
    public static final ObservableList data = 
    FXCollections.observableArrayList();
    
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
   
   
   
   
    
public int  Balance_Sheet(){
        try{
        String Sql="Create table BalanceSheet"+this.m+ 
               
        "(" +
        "Debit"+(this.m+3)+"   bigInt," +
        "Credit"+(this.m+4)+"  bigInt)";
     
        data.add(this.m);
     
        
        con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Accounts;user=tamimdb;password=tamim");
        pst=con.prepareStatement(Sql);
       
        pst.executeUpdate();
                              
        }catch(Exception se){
           System.out.println(se);
           
        }
       return this.m;
}
   
public void Income_Statement(){
      
   try{
   String Sql="Create table Income_Statement"+this.m+ 
   "(" +
   "Debit"+(this.m+1)+" bigInt," +
   "Credit"+(this.m+2)+" bigInt)";
   con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Accounts;user=tamimdb;password=tamim");
   pst=con.prepareStatement(Sql);
   pst.executeUpdate();
   }catch(Exception se){
   System.out.println(se);        
   }
}
  
public void Balance_sheet_rev(String s1){

           try{
           String Sql="insert into Income_Statement"+data.get(0)+" values(?,?)";
           con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Accounts;user=tamimdb;password=tamim");
           pst=con.prepareStatement(Sql);
           pst.setString(1,s1);
           pst.setString(2,""); 
           pst.executeUpdate();
           }catch(Exception exx){
           System.out.println(exx);
           }
}
    
public void Balance_sheet_exp(String s1){
   
           try{ 
           String Sql="insert into Income_Statement"+data.get(0)+" values(?,?)";
           con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Accounts;user=tamimdb;password=tamim");
           pst=con.prepareStatement(Sql);
           pst.setString(1,"");
           pst.setString(2,s1);
           pst.executeUpdate();
           }catch(Exception exx){
           System.out.println(exx);
           }
   
}
     
public void Balance_sheet_Asset_Owners_drawing(String s1){
   
           try{ 
           String Sql="insert into BalanceSheet"+data.get(0)+" values(?,?)";
           con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Accounts;user=tamimdb;password=tamim");
           pst=con.prepareStatement(Sql);   
           pst.setString(1,s1);
           pst.setString(2,"");
           pst.executeUpdate();
           }catch(Exception exx){
           System.out.println(exx);
           }
   
   }
      
public void Balance_sheet_Libility_Owners_capital(String s1){
         try{
         String Sql="insert into BalanceSheet"+data.get(0)+" values(?,?)";
         con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Accounts;user=tamimdb;password=tamim");
         pst=con.prepareStatement(Sql);
         pst.setString(1,"");
         pst.setString(2,s1);
         pst.executeUpdate();
         }catch(Exception exx){
         System.out.println(exx);
         }
   
}
  
public void buildData(String s1){
          Connection c ;
          ObservableList<Object> data = FXCollections.observableArrayList();
          try{
          c = DBConnect.connect();
          //SQL FOR SELECTING ALL OF CUSTOMER
          String SQL = "SELECT * from "+s1+""+this.data.get(0);
            
          //ResultSet
          ResultSet rs = c.createStatement().executeQuery(SQL);

          /**********************************
          * TABLE COLUMN ADDED DYNAMICALLY *
          **********************************/
          for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
          //We are using non property style for making dynamic table
          final int j = i;                
          TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
          col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
          public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
          return new SimpleStringProperty(param.getValue().get(j).toString());                        
          }                    
          });

          table3.getColumns().addAll(col);
               
          //System.out.println("Column ["+i+"] ");
          }

          /********************************
          * Data added to ObservableList *
          ********************************/
          while(rs.next()){
          //Iterate Row
          ObservableList<String> row = FXCollections.observableArrayList();
          for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
          //Iterate Column
          row.add(rs.getString(i));
          }
          //  System.out.println("Row [1] added "+row );
          data.add(row);
          }
          //FINALLY ADDED TO TableView
          table3.setItems(data);
          }catch(Exception e){
          e.printStackTrace();
          System.out.println("Error on Building Data");             
          }

   
}
   
    @Override
public void initialize(URL url, ResourceBundle rb) {}    

    @FXML
private void handlebuttonoaction1(ActionEvent event) { 
        buildData("Income_Statement");
    }

    @FXML
private void handlebuttonoaction2(ActionEvent event) {
        buildData("BalanceSheet");
    }

    @FXML
private void handlebuttonoaction3(ActionEvent event) throws IOException {
        Parent news=FXMLLoader.load(getClass().getResource("After.fxml"));
        Scene scene=new Scene(news);
        Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }
    
    @FXML
private void handlebuttonoaction4(ActionEvent event) throws IOException {
        table3.getColumns().clear();   
    }
    
    
}
