package accounting.software.final_classes;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;
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
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author tamimwasif
 */
public class LedgermainController implements Initializable {

    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    public int k=0,L=0;
    public static final ObservableList tabletype =  FXCollections.observableArrayList();
    Random rand=new Random();
    public int  m = rand.nextInt(1000) + 1;
    public int incrementfortable=0,incrementfortablename=0;
    String s2;
    ActionEvent es;
    public int[] array=new int[100];
    public String[] nameoftablescopy=new String[100];
    public long veriable;
    public static final ObservableList tablenames = 
    FXCollections.observableArrayList();
    public int indx=0;
    @FXML
    private AnchorPane pane;
    @FXML
    private Button button2;
    @FXML
    private TableView table2;
    @FXML
    private TextField text1;
    @FXML
    private MenuItem button1;
    @FXML
    private MenuItem button4;
    @FXML
    private MenuItem button3;

      
    
    public LedgermainController(int flag){
    tabletype.add(flag);
}
    
    public LedgermainController(String ob2) throws SQLException, ClassNotFoundException, IOException{
    this.s2=ob2;
    tablenames.add(this.s2);
}
 
    public void Ledgermain2(String nameoftables[],int lengthof2ndarray){
    System.arraycopy(nameoftables, 0, nameoftablescopy, 0, lengthof2ndarray);
}
    
    public LedgermainController(){}
    
    
    public void methodfromfile(int val){
	Properties prop = new Properties();
	InputStream input = null;

	try {

        input = new FileInputStream("D://config.properties");

		// load a properties file
	prop.load(input);

		// get the property value and print it out
	System.out.println(prop.getProperty("tablenames"+val));
	} catch (IOException ex) {
	ex.printStackTrace();
	} finally {
	if (input != null) {
	try {
	input.close();
	} catch (IOException e) {
	e.printStackTrace();
	}
	}
	}
}
    
    
    public void method_for_TrialBalance(String tablename,int indxarr,int array[],String array2[],int arr2indx) throws SQLException, ClassNotFoundException, IOException{
    
                                    
                                    for(int j=0;j<indxarr;j++){
                                    System.out.println(array[j]);
                                    }
                                    for(int k=0;k<arr2indx;k++){
                                    System.out.println(array2[k]);
                                    }
                                    
                                    
                               int valueoftable=0;
                               for(int i=0;i<indxarr;i++){
                               
                               if(Objects.equals(tablename, array2[i])==true){
                               valueoftable=array[i];
                               
                               break;
                               }
                               }
                               
                          try{
                          String sql="select sum(Debit) as ledger1,sum(Credit) as ledger2 from "+tablename;
                          
                          con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Accounts;user=tamimdb;password=tamim");
                          
                          pst=con.prepareStatement(sql);
                          rs=pst.executeQuery();
                          
                          if(rs.next()){
                               String sum = rs.getString("ledger1");
                               String sum2 = rs.getString("ledger2");
                               
                               BigInteger debit=new BigInteger(sum);
                               BigInteger credit=new BigInteger(sum2);
                               BigInteger ans3=BigInteger.ZERO;
                               
                               
                               ans3=ans3.add(debit);
                               ans3=ans3.subtract(credit);
                               
                               
                               String ansmain=String.valueOf(ans3);
                               
                               
                               
                               
                               if(valueoftable==1){
                               TrialBalanceController ob=new TrialBalanceController(ansmain,"0",tablename);
                               
                               
                               
                               }
                               
                               else if(valueoftable==2){
                               TrialBalanceController ob=new TrialBalanceController(ansmain,"0",tablename);
                               
                               
                               
                               }
                               
                               else if(valueoftable==3){
                               TrialBalanceController ob=new TrialBalanceController("0",ansmain,tablename);
                               
                               
                               
                               }
                               
                               else if(valueoftable==4){
                               TrialBalanceController ob=new TrialBalanceController(ansmain,"0",tablename);
                               
                               
                               
                               }
                               
                               else if(valueoftable==5){
                               TrialBalanceController ob=new TrialBalanceController("0",ansmain,tablename);
                               
                               
                               
                               }
                               
                               else if(valueoftable==6){
                               TrialBalanceController ob=new TrialBalanceController(ansmain,"0",tablename);
                               
                               
                               
                               }
                          }
    }catch(Exception e1){
    System.out.println(e1);

    }
    


}
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {}    

    @FXML
    private void handlebuttonoaction2(ActionEvent event) throws IOException {
        
        Parent news=FXMLLoader.load(getClass().getResource("After.fxml"));
        Scene scene=new Scene(news);
        Stage app_stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
        
    }

    @FXML
    private void handlebuttonaction1(ActionEvent event) {
            Connection c ;
            ObservableList<Object> data = FXCollections.observableArrayList();
    
            try{
            c = DBConnect.connect();
            //SQL FOR SELECTING ALL OF CUSTOMER
      //    System.out.println(object.arr[0][1]);
            String SQL = "SELECT * from "+this.tablenames.get(k);
            
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

            table2.getColumns().addAll(col);
               
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
              
            data.add(row);
            }

            //FINALLY ADDED TO TableView
            table2.setItems(data);
            //data.clear();
            }catch(Exception ea){
            JOptionPane.showMessageDialog(null, ea);
            System.out.println("Error on Building Data");             
            }
             try{
             String sql="select sum(Debit) as ledger1,sum(Credit) as ledger2 from "+this.tablenames.get(this.k);
           
             con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Accounts;user=tamimdb;password=tamim");
 
             pst=con.prepareStatement(sql);
             rs=pst.executeQuery();
                          
             if(rs.next()){
             String sum = rs.getString("ledger1");
             String sum2 = rs.getString("ledger2");
                               
             BigInteger debit=new BigInteger(sum);
             BigInteger credit=new BigInteger(sum2);
             BigInteger ans3=BigInteger.ZERO;
                               
                               
              ans3=ans3.add(debit);
              ans3=ans3.subtract(credit);
                               
                               
              String ansmain=String.valueOf(ans3);
                               
              text1.setText(ansmain);  
                               
              }
              }catch(Exception e1){
              System.out.println(e1);

              }
    
              this.k++;
         
    }

    @FXML
    private void handlebuttonaction3(ActionEvent event) {
        if(k==0){JOptionPane.showMessageDialog(null,"no more decriment allowed");}
    else{
    k--;
    }
    }

    @FXML
    private void handlebuttonaction5(ActionEvent event) {
         table2.getColumns().clear();
    text1.clear();
    
    }
    
}
