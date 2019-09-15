package accounting.software.final_classes;
import java.util.Objects;
import java.util.Scanner;


public class Ledger_class {
   public String Acctname;
   public int index,index2;

   int tos=0;
   String[][] arr=new String[1][5000];

public int checkif(Ledger_class ob){
int flag=0;
int i;
for(i=1;i<ob.tos;i++){
if(Objects.equals(ob.Acctname, ob.arr[0][i])){
    ob.index2=i;
    
flag=1;
break;
}
}
System.out.println(flag);
if(flag==1){return ob.index2;}
else {return 0;}
}

public void push(Ledger_class ob){
ob.arr[0][ob.tos]=ob.Acctname;
ob.tos++;
}

}
