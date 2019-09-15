package accounting.software.final_classes;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.JOptionPane;


public class TrialBalanceController implements Initializable {
    
    Random rand = new Random();
    int ind=0;
    public String sumdr,sumcr;
    public int  n = rand.nextInt(1000) + 1;
    public int flag2=0;
    String Account_title,Debit,Credit;
    public static final ObservableList data2 =     FXCollections.observableArrayList();
    public static final ObservableList data3 =     FXCollections.observableArrayList();
    public static final ObservableList data4 =     FXCollections.observableArrayList();
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    @FXML
    private Button button4;
    @FXML
    private TextField debitsum;
    @FXML
    private TextField creditsum;
    @FXML
    private TableView table1;
   
public TrialBalanceController(String dr,String cr,String name) throws SQLException{
      
       try{
       String sql3="update TrialBalance"+this.data3.get(0)+" set Debit='"+dr+"', Credit='"+cr+"' where Account_Title='"+name+"'";
       con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Accounts;user=tamimdb;password=tamim");
       pst=con.prepareStatement(sql3);
       pst.executeUpdate();
       }catch(Exception se){
       System.out.println(se);
       }
}
  
public TrialBalanceController(){}
      
public void TrialBalanceController2(){
     
        try{
        String Sql="Create table TrialBalance"+n+ 
        "(Account_Title varchar(50)," +
        "Debit bigInt," +
        "Credit bigInt)";
        data3.add(n);
        con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Accounts;user=tamimdb;password=tamim");
        pst=con.prepareStatement(Sql);
        pst.executeUpdate();
        }catch(Exception se){
        System.out.println(se);
        }
}

public void TrialBalanceController3(String s2) {
           this.Account_title=s2;
           try{
           String Sql="insert into TrialBalance"+this.data3.get(0)+" values(?,?,?)";
           con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Accounts;user=tamimdb;password=tamim");
           pst=con.prepareStatement(Sql);
           pst.setString(1,this.Account_title);
           pst.setString(2,"0");
           pst.setString(3,"0");
           pst.executeUpdate();
           }catch(Exception exx){
           System.out.println(exx);
           }
}

    @Override
public void initialize(URL url, ResourceBundle rb) {}    
    
    @FXML
private void handlebuttonoactionbutton1(ActionEvent e) throws IOException{
      
        Parent news=FXMLLoader.load(getClass().getResource("After.fxml"));
        Scene scene=new Scene(news);
        Stage app_stage=(Stage) ((Node) e.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
}
    
public void buildData(){
           Connection c ;
           ObservableList<Object> data = FXCollections.observableArrayList();
           try{
           c = DBConnect.connect();
           //SQL FOR SELECTING ALL OF CUSTOMER
           String SQL = "SELECT * from TrialBalance"+this.data3.get(0);
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

           table1.getColumns().addAll(col);
               
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
            table1.setItems(data);
            }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");             
            }

   
}
     
     @FXML  
private void handlebuttonoactionbutton4(ActionEvent e) throws IOException, SQLException{
                    System.out.println(ind);
}
                 
    @FXML
private void handlebuttonoactionbutton2(ActionEvent e) throws IOException, SQLException{
        buildData();
        String sql="Select Sum(Debit) as sumdebit from TrialBalance"+this.data3.get(0);
        con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Accounts;user=tamimdb;password=tamim");
        pst=con.prepareStatement(sql);
        rs=pst.executeQuery();
         
        if(rs.next()){
        String sum = rs.getString("sumdebit");
        debitsum.setText(sum);
       }
                              
        String sql2="Select Sum(Credit) as sumcredit from TrialBalance"+this.data3.get(0);
        con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Accounts;user=tamimdb;password=tamim");
        pst=con.prepareStatement(sql2);
        rs=pst.executeQuery();
        
         if(rs.next()){
         String sum2 = rs.getString("sumcredit");
         creditsum.setText(sum2);
       }
}
       
     @FXML
private void handlebuttonoactionbutton3(ActionEvent e) throws IOException, SQLException{
     table1.getColumns().clear();   
     debitsum.clear();
     creditsum.clear();
}


}

