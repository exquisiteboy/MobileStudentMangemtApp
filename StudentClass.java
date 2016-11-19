/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.charts.util.ColorUtil;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;

/**
 *
 * @author HSS
 */
public class StudentClass {

 private Button click;
    private TextField name;
    private TextField FatherName;
    private TextField Address;
    private TextField Mobile;
    private TextField Sex;
    private TextField Qualification;    


public void AddStudentForm(){
 
      
    Form hi = new Form("ADD Student",new BoxLayout(BoxLayout.Y_AXIS));
   
    Style style=new Style();
    style.setFgColor(ColorUtil.GREEN);
    style.setBorder(Border.createDashedBorder(4, ColorUtil.CYAN));
    
    Label status=new Label();
    
    Button Back=new Button("Back");
       Back.addActionListener(e->{
       
           MyApplication object=new MyApplication();
        
           object.MainForm();  
           e.consume();
       
       
       
       });
        name=new TextField(); 
       
        FatherName=new TextField();
        Address=new TextField();
        Mobile=new TextField();
        Sex=new TextField();
        
        Qualification=new TextField();
        
        click=new Button("Add Student");
        
        click.addActionListener(e->{
       
            
       String Name=name.getText();
       String FName=FatherName.getText();
       String Addr=Address.getText();
       String Mob=Mobile.getText();
       String Sexx=Sex.getText();
       String Qualifications=Qualification.getText();
   
       System.out.println("getting value of mobile is ");
       
       double mobile =Double.parseDouble(Mob);
double id=50;
       
      System.out.println("value of  mobile is "+mobile);
       
       try{
         DatabaseSQLite object=new DatabaseSQLite();
         
     object.addStudent(id,Name, FName, Addr, mobile,Sexx, Qualifications);
}catch(Exception ex){

    Log.e(ex);

}
       
            System.out.println("you clicked Add student with the following informtion \n");
            
            System.out.println("Name \t FAtherName \t Address \t Mobile# \t Gender \t Qualification ");
            System.out.println(Name+"\t"+FName+" \t"+Addr+" \t"+Mob+"     \t"+Sexx+"       \t"+Qualifications);
            
            status.setUnselectedStyle(style);
           status.setText("information add successfuly");
           hi.revalidate();
            
                 
        });
        
        
        
        hi.addComponent(new Label("Student Name"));
        hi.addComponent(name);
        hi.addComponent(new Label());
        hi.addComponent(new Label("Student FatherName"));
        hi.addComponent(FatherName);
        hi.addComponent(new Label("Address"));
        hi.addComponent(Address);
        hi.addComponent(new Label("Mobile#"));
        hi.addComponent(Mobile);
        hi.addComponent(new Label("Gender"));
        hi.addComponent(Sex);
        hi.addComponent(new Label("Qualification"));
        hi.addComponent(Qualification);
        
        hi.addComponent(click);
        hi.addComponent(Back);
        
        
        hi.add(status);
        hi.show();
 
} 


}
