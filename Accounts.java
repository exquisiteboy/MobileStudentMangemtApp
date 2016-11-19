/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Accounts;

import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.table.TableLayout;

/**
 *
 * @author HSS
 */
public class Accounts {
    


    
    
 public void hjgjhg(Form hi){
 hi.removeAll();
 
 
 TableLayout tl;
int spanButton = 2;
if(Display.getInstance().isTablet()) {
    tl = new TableLayout(7, 2);
} else {
    tl = new TableLayout(14, 1);
    spanButton = 1;
}
tl.setGrowHorizontally(true);
hi.setLayout(tl);

TextField Name = new TextField("", "First Name", 20, TextArea.ANY);
TextField Fathername = new TextField("", "FatherName", 20, TextArea.ANY);
TextField email = new TextField("", "E-Mail", 20, TextArea.EMAILADDR);
TextField Password= new TextField("", "Password", 20, TextArea.PASSWORD);
TextField phone = new TextField("", "Phone", 20, TextArea.PHONENUMBER);

//TextField num1 = new TextField("", "1234", 4, TextArea.NUMERIC);
//TextField num2 = new TextField("", "1234", 4, TextArea.NUMERIC);
//TextField num3 = new TextField("", "1234", 4, TextArea.NUMERIC);
//TextField num4 = new TextField("", "1234", 4, TextArea.NUMERIC);

Button submit = new Button("Submit");
Button submitt = new Button("Submit");
TableLayout.Constraint cn = tl.createConstraint();
cn.setHorizontalSpan(spanButton);
cn.setHorizontalAlign(Component.RIGHT);
hi.add("First Name").add(Name).
        add("Surname").add(Fathername).
        add("E-Mail").add(email).
        add("Password").add(Password).
        add("Phone").add(phone).
//        add("Credit Card").
//                add(GridLayout.encloseIn(4, num1, num2, num3, num4)).
        add(GridLayout.encloseIn(2, submit,submitt));

 
 
 }   
    
    
    
public void SignUP(Form hi){
hi.removeAll();




TableLayout t1;
int spanButton=2;

if(Display.getInstance().isTablet()){

t1=new TableLayout(7,2);


}
else{

t1=new TableLayout(14,1);
spanButton=1;

}
t1.setGrowHorizontally(true);
hi.setLayout(t1);
   
   Label Name=new Label("Name");
Label FatherName=new Label("FatherName");
Label CNIC=new Label("C.N.I.C");
Label Mob=new Label("Mobile#");
Label Email=new Label("Email");
Label Password=new Label("Password");


// testfield intialization 
TextField UName=new TextField("","UserName",20,TextArea.ANY);
TextField FName=new TextField("","FatherName",20,TextArea.ANY);
TextField CNICC=new TextField("","CNIC",20,TextArea.NUMERIC);
TextField MOB=new TextField("","Mobile",20,TextArea.NUMERIC);
TextField EMAIL=new TextField("","EMail",20,TextArea.EMAILADDR);
TextField PASSWORD=new TextField("","Passwoord",20,TextArea.PASSWORD);




// initalizing buttons 

Button backButton=new Button("Back");




Button SignupUserButton=new Button("Singup");


// adding action listneer to the button clicks

/*
*  adding action listener to the signup button 
*
*
*/
SignupUserButton.addActionListener(e->{
String name=UName.getText();
String Fname=FName.getText();
Long Cnic=Long.parseLong(CNICC.getText());
Long mobile=Long.parseLong(MOB.getText());
String email=Email.getText();
String passwrd=Password.getText();


new AccountsDB().addUserAccount(name, Fname, Cnic, mobile, email, passwrd);

e.consume();
});

// Back Buuton ActionLIstener

backButton.addActionListener(e->{

Log.p("Do you wanna go back");

e.consume();

});
TableLayout.Constraint cn =t1.createConstraint();
cn.setHorizontalSpan(spanButton);
cn.setHorizontalAlign(Component.RIGHT);

hi.addComponent(Name);
hi.add(UName);
        hi.addComponent(FatherName);
        hi.addComponent(FName);
        hi.addComponent(CNIC);
        hi.addComponent(CNICC);
        hi.addComponent(Mob);
        hi.addComponent(MOB);
        hi.addComponent(Email);
        hi.addComponent(EMAIL);
        hi.addComponent(Password);
        hi.addComponent(PASSWORD);
        hi.add(GridLayout.encloseIn(2, SignupUserButton,backButton));
        

}







}
