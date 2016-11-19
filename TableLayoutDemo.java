/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.charts.util.ColorUtil;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.db.Database;
import com.codename1.io.Log;
import com.codename1.io.Util;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.myapp.Accounts.Accounts;
import com.mycompany.myapp.Accounts.AccountsDB;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author HSS
 */
public class TableLayoutDemo {
    
    
    String aa="very good";
  public   TableLayoutDemo(){
//
//Form hi = new Form("Table Layout 2x2", new TableLayout(1, 6));   
//
//hi.add(new Label("First")).
//add(new Label("Second")).
//add(new Label("Third")).
//add(new Label("Fourth")).
//add(new Label("Fifth")).
//
//add(new Label("six"));
//hi.show();


  
  
  
  }
  
  
  
public void showForm() {
//  Form hi = new Form("ComboBox", new BoxLayout(BoxLayout.Y_AXIS));
//  ComboBox<Map<String, Object>> combo = new ComboBox<> (
//          createListEntry("A Game of Thrones", "1996"),
//          createListEntry("A Clash Of Kings", "1998"),
//          createListEntry("A Storm Of Swords", "2000"),
//          createListEntry("A Feast For Crows", "2005"),
//          createListEntry("A Dance With Dragons", "2011"),
//          createListEntry("The Winds of Winter", "2016 (please, please, please)"),
//          createListEntry("A Dream of Spring", "Ugh"));
//  
//  combo.setRenderer(new GenericListCellRenderer<>(new MultiButton(), new MultiButton()));
//  hi.show();




Command command=new Command("hello");

Form hi = new Form("Welcome", new BoxLayout(BoxLayout.Y_AXIS));
Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
SpanLabel welcomeNote=new SpanLabel("welcome to the android DS Card App "
        + "it is very effective way to inform the parents about their childern"
        + "status wheter it arrives safely at school or not " );





Button SignIN_link=new Button("Login");
SignIN_link.getAllStyles().setBorder(Border.createEmpty());
SignIN_link.getAllStyles().setFgColor(ColorUtil.BLUE);
SignIN_link.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_UNDERLINE);


Button SignUP_link=new Button("SignUp");

SignUP_link.getAllStyles().setBorder(Border.createEmpty());
SignUP_link.getAllStyles().setFgColor(ColorUtil.BLUE);
SignUP_link.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_UNDERLINE);






 SignIN_link.addActionListener(e->{

AccountLogin( hi);
e.consume();

});
 
SignUP_link.addActionListener(e->{
hi.removeAll();
hi.setTitle("Sign Up");
new Accounts().SignUP(hi);
hi.revalidate();
e.consume();
});
 
FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_ACCOUNT_CIRCLE, s);
//hi.getToolbar().addCommandToLeftBar("Left", icon, (e) -> Log.p("Clicked"));
//hi.getToolbar().addCommandToRightBar("Right", icon, (e) -> Log.p("Clicked"));
//hi.getToolbar().addCommandToOverflowMenu("Overflow", icon, (e) -> Log.p("Clicked"));
//hi.getToolbar().addCommandToOverflowMenu("Olow", icon, (e) ->{ Log.p("Clicked");
//Log.p("top one is me");
//});


hi.getToolbar().addCommandToSideMenu("Account", icon, (e) -> {


    
Log.p("Clicked");


});
hi.getToolbar().addCommandToSideMenu("Sign In", icon, (e) ->{ 
    
    
    Log.p("Clicked");
    
AccountLogin(hi);
e.consume();


});

hi.getToolbar().addCommandToSideMenu("SignUp", icon, (e) -> {
hi.removeAll();
hi.setTitle("Sign Up");    
new Accounts().SignUP(hi);

hi.revalidate();
e.consume();

});
hi.add(welcomeNote); 
hi.addComponent(SignIN_link);
hi.addComponent(SignUP_link);

hi.show();    

}

//FontImage icoon = FontImage.createMaterial(FontImage.MATERIAL_BLOCK, s);
//Command cond=hi.getToolbar().addCommandToSideMenu("Sidemenu", icoon, (e) -> Log.p("Clicked"));
//hi.getToolbar().addCommandToSideMenu(command);

//System.out.println("printing form side meu command"+cond); 



public void AccountLogin(Form hi){
AccountsDB dbOBj = new AccountsDB();

hi.removeAll();

Label IDLabel=new Label("EMail");

TextField email=new TextField("","Email",20,TextArea.EMAILADDR);

Label PassLabel=new Label("Password");

TextField Password=new TextField("","Password",20,TextArea.PASSWORD);
    
Button SigIn=new Button("SingIn");

SigIn.addActionListener((e)->{
    
    String Email=email.getText();
    String password=Password.getText();
    
    password=password.toString();
    System.out.println("Email"+Email+"Password"+Password);
    
   // ArrayList<String> array=new ArrayList<>(5);
   
    dbOBj.getLoggedInUserInfo(Email, password);
    e.consume();
//    if (!array.isEmpty()){
//        hi.removeAll();
//        TextField use=new TextField(array.get(0));
//        TextField pass=new TextField(array.get(1));
//        
//        hi.add(new Label("Email")).
//                add(use).add(new Label("password")).add(pass);
//        hi.revalidate();
//        e.consume();
//        
//    }
//    else{
//        
//        ToastBar.showMessage("No results found", FontImage.MATERIAL_BLOCK,50);
//
//    }
//    System.out.println("The value at index "+array.get(0)+array.get(1));

});


hi.setTitle("Login");
hi.add(IDLabel);
hi.add(email);
hi.add(PassLabel);
hi.add(Password);
hi.add(SigIn);
hi.revalidate();

} 
    
  public void MainForm(){
  
  Form MainForm =new Form("Digital Student Card",new BoxLayout(BoxLayout.Y_AXIS));
  
  Button btn=new Button("AddStudent");
  Button show=new Button("show");
  Button delete=new Button("delete from table");
  
  Button table=new Button("Table Layout");
  
  table.addActionListener(e->{
  
  TableLayoutDemo object=new TableLayoutDemo();
  
  object.showForm();
  
  });
  
  
  
  
  delete.addActionListener(e->{
  
  DatabaseSQLite object=new DatabaseSQLite();
  object.DeleteStudents();
      
  
  });
  
  show.addActionListener(e->{
  
 new  MyApplication().showDatabase();
  
  
  });
  btn.addActionListener(e->{
 
 StudentClass object=new StudentClass();     
      object.AddStudentForm();
 e.consume();
  });
  
  
  Button btn2=new Button("Welcome");
  btn2.addActionListener(e->{
new MyApplication().HelloWorldForm();
 e.consume();
  });
 
  Button three=new Button("create Db");
  
  three.addActionListener(e->{
  
  //CreateDatbase();
  
  
e.consume();
  
  });
  
  
  
 MainForm.addComponent(btn);
 MainForm.addComponent(btn2);
 MainForm.addComponent(three);
 MainForm.addComponent(show);
 MainForm.addComponent(delete); 
 MainForm.addComponent(table);
 MainForm.show();
  
  
  } 

  
public void signUp_Form(){
// removing elements previously showing on the form

// declaring varibale of buutons and Label & textfield
//Label Name,FatherName,CNIC,Mob,Email,Password;
//Button backButton,SignupUserButton;    
//TextField UName,FName,CNICC,MOB,EMAIL,PASSWORD;
//setting the title of the bar mainwindow

// label intialization   
/*
*
*
*
*/
Form form=new Form("Sign Up",new BoxLayout(BoxLayout.Y_AXIS));
Label Name=new Label("Name");
Label FatherName=new Label("FatherName");
Label CNIC=new Label("C.N.I.C");
Label Mob=new Label("Mobile#");
Label Email=new Label("Email");
Label Password=new Label("Password");


// testfield intialization 
TextField UName=new TextField("UserName",TextArea.INITIAL_CAPS_SENTENCE);
TextField FName=new TextField("FatherName",TextArea.ANY);
TextField CNICC=new TextField("CNIC",TextArea.NUMERIC);
TextField MOB=new TextField("Mobile",TextArea.PHONENUMBER);
TextField EMAIL=new TextField("EMail",TextArea.EMAILADDR);
TextField PASSWORD=new TextField("Passwoord",TextArea.PASSWORD);




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



Log.p("Sing me up");

e.consume();
});

// Back Buuton ActionLIstener

backButton.addActionListener(e->{

Log.p("Do you wanna go back");

e.consume();

});

form.setTitle("Sign Up");
form.addComponent(Name);
        form.addComponent(FatherName);
        form.addComponent(FName);
        form.addComponent(CNIC);
        form.addComponent(CNICC);
        form.addComponent(Mob);
        form.addComponent(MOB);
        form.addComponent(Email);
        form.addComponent(EMAIL);
        form.addComponent(Password);
        form.addComponent(PASSWORD);
        form.addComponent(SignupUserButton);
        form.addComponent(backButton);
form.show();
}  
  
  
  

}



//private void Login(){
//   Style s = UIManager.getInstance().getComponentStyle("");
//    FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_SD_CARD, s);
//   Form login=new Form("Login ",new BoxLayout(BoxLayout.Y_AXIS));
//   login.getToolbar().addCommandToOverflowMenu("signup", icon, e->{
//   Label id=new Label("Enter Your ID");
//   TextField Uid=new TextField("");
//   
//   Label password=new Label("Enter Your Password");
//    Label pword=new Label("Enter Your Password");
//     Label psword=new Label("Enter Your Password");
//      Label pswrd=new Label("Enter Your Password");
//       Label pwrd=new Label("Enter Your Password");
//        Label pd=new Label("Enter Your Password");
//         Label pord=new Label("Enter Your Password"); 
//         Label pssword=new Label("Enter Your Password");
//          Label pwd=new Label("Enter Your Password");
//           Label pswor=new Label("Enter Your Password");
//         
//   TextField Password=new TextField();
//   
//   Password.setConstraint(TextArea.PASSWORD);
//   Button singin=new Button("sign in");
//   singin.addActionListener((lambda)->{
//   
//   MainForm();
//   lambda.consume();
//   
//   });
//   login.removeAll();
//   login.add(id);
//   login.add(Uid);
//   login.add(password);
//   login.add(Password);
//   login.add(singin);
//   login.revalidate();
//   e.consume();
//   
//   });
//   login.getToolbar().addCommandToLeftBar("Login", icon, e->{
//   
//   Label id=new Label("Enter Your ID");
//   TextField Uid=new TextField("");
//   
//   Label password=new Label("Enter Your Password");
//   
//   TextField Password=new TextField("Password");
//   
//   Password.setConstraint(TextArea.PASSWORD);
//   login.removeAll();
//   login.add(id);
//   login.add(Uid);
//   login.add(password);
//   login.add(Password);
//   login.revalidate();
//   });
//   
//   login.show();
//   
//   }



















//private Map<String, Object> createListEntry(String name, String date) {
//    Map<String, Object> entry = new HashMap<>();
//    entry.put("Line1", name);
//    entry.put("Line2", date);
//    return entry;
//}