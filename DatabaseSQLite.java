/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.ToastBar;
import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.db.Row;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.Log;
import com.codename1.io.Util;
import com.codename1.ui.Display;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author HSS
 */
public class DatabaseSQLite {
    
   String LoggedUserName=null;
   String LoggedUserPassword=null;

    public void createDatabase() throws IOException{
    
    Database db=null;
   
        try {
            db=Display.getInstance().openOrCreate("students.db");
            db.execute("create table clStudent(id long,Name varchar(50),FatherName varchar(50),Address varchar(100),mobile long,gender char(50),Qualification varchar(50))");
  
        } catch (IOException ex) {
            
            db.close();
            Util.cleanup(db);
            System.out.println("sdfsdfsdfsadf"+ex);
            Log.e(ex);
        }
        db.close();
        Util.cleanup(db);
    
    
    }

    
  public String getUserName(){
  
      
      
      
      return LoggedUserName;
  }  
    
    public String getUserPass(){
    
    
  return LoggedUserPassword;  
    }
    
 public void createLoginDB(){
 
 
 Database db=null;
 
        try {
          db=Display.getInstance().openOrCreate("Account.db");
        db.execute("create table UserAuth (Uid long,Password Varchar(100))");
        } catch (IOException ex) {
        Log.e(ex);
        }
 
 
 
 }
 
    
    
 public void addStudent(Double id,String name,String Fathername,String Address,Double Mob,String Gender,String Qualification) throws IOException{
 
 Database db=null;
 Cursor cur=null;


System.out.println("creating array");

Object[]param=new Object[7];
 param[0]=id;
 param[1]=name;
 param[2]=Fathername;
 param[3]=Address;        
 param[4]=Mob;
 param[5]=Gender;
 param[6]=Qualification;
 
 try{

     db=Display.getInstance().openOrCreate("students.db");
 
     System.out.println("trying to insert");
    
        
    
         db.execute("insert into clStudent values(?,?,?,?,?,?,?)", (Object[])param) ;
     
    System.out.println("inserted to insert");
     
 ToastBar.showErrorMessage("inserted Successfulyy",5000);
    
 }   
 
 
 
 catch (IOException ex) {
   
     db.close();
     Util.cleanup(db);
     ToastBar.showErrorMessage("cannot insert into the table because :"+ex);
    }
 finally{
 //db.close();
Util.cleanup(db);
 }
 }
 
 
 
public void New_ADD_Student(String id,String Name,String FatherName,String Addr,String Mob,String Gender,String Qualification) throws IOException 
    
{

    
Database db=null;
Object[]param=new Object[9];
 param[1]=(Object)id;
 param[2]=(Object)Name;
 param[3]=(Object)FatherName;
 param[4]=(Object)Addr;        
 param[5]=(Object)Mob;
 param[6]=(Object)Gender;
 param[7]=(Object)Qualification;
    

          // ,Name,FatherName,Addr,Mob,Gender,Qualification};
    
    try{

     db=Display.getInstance().openOrCreate("students.db");
 
     System.out.println("trying to insert");
     
     db.execute("insert into clStudent values('?','?','?','?','?','?','?')",(Object[]) param[1]) ;
 System.out.println("inserted to insert");
     //(Object[]) param[1]
 
 } catch (IOException ex) {
   
     db.close();
     Util.cleanup(db);
     ToastBar.showErrorMessage("cannot insert into the table because :"+ex);
    }
catch(Exception ex1){
ToastBar.showErrorMessage("error is :"+ex1.getMessage());

}



}
    
public void DeleteStudents(){


    Database db=null;
    Cursor cur=null;
    
    
    try{
    db=Display.getInstance().openOrCreate("students.db");
    db.execute("delete from clStudent");
    
    }catch(IOException ex){
    Log.e(ex);
    
    }finally{
    
    Util.cleanup(db);
    
    }

}

public void SigUp(Long uid,String Pass){

Database db=null;
    Object [] param={uid,Pass};
    try{
    db=Display.getInstance().openOrCreate("Account.db");
    db.execute("insert into UserAuth values(?,?)",(Object[])param);
    }catch(IOException ex){
    
        Util.cleanup(db);
        ToastBar.showErrorMessage(ex.getMessage(), 50);
    
    
    }
    finally{
    
    Util.cleanup(db);
    
    }
    
}



public ArrayList getRegUsers(Long ID) throws IOException{

    ArrayList<String> list =new ArrayList<String>(5) ;
    String []array={String.valueOf(ID)};
    Object []Param={ID};
   Database db=null;
   Cursor cur=null;
 boolean val=false;
   try{
   
       ConnectionRequest r=new ConnectionRequest();
       
      
       db=Display.getInstance().openOrCreate("Account.db");
 
      // db.execute("select * from UserAuth where Uid=?",(Object[])Param);
 cur= db.executeQuery("select * from UserAuth where Uid=?",(String [])array);
 int   columns=cur.getColumnCount();
 
 
 if(columns > 0) {
     val=true;
       boolean next = cur.next();
                    
           while(next) {
          Row currentRow = cur.getRow();
      String     LoggedUserName=currentRow.getString(0);
      String     LoggedUserPassword=currentRow.getString(1);
      list.add(LoggedUserName);
      list.add(LoggedUserPassword);
          System.out.println(LoggedUserName +"    jj"+LoggedUserPassword);
                           next = cur.next();
                        }
 
      
                    }
 
   
   }catch(IOException ex)
   {
       Util.cleanup(db);
       Util.cleanup(cur);
       Log.e(ex);
   }
   
   finally{
   
   Util.cleanup(db);
   Util.cleanup(cur);
   
   }
  // System.out.println("coulm count is "+v);
   
return list;
}


    


}