//import required classes and packages  
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;
import java.io.IOException;
import java.lang.Exception;  
import java.sql.*;  

class CreateLoginForm extends JFrame implements ActionListener  {  
    //initialize button, panel, label, and text field  
    private JButton b1;  
    private JPanel contentPane = new JPanel();
    private JPanel loginPanel;  
    private JPanel loggedInPanel;
    private JPanel restrictedPanel;
    private JLabel userLabel, passLabel;  

    private JLabel loggedInUser, loggedInRole;
    private JLabel restrictedText;
    private JButton backButton;
    private JButton logOut;
    private JButton restrictedButton;
    final JTextField  textField1, textField2;  
      
    //calling constructor  
    CreateLoginForm() {     
        //create label for username   
        userLabel = new JLabel();  
        userLabel.setText("Username");      //set label value for textField1  
          
        //create text field to get username from the user  
        textField1 = new JTextField(15);    //set length of the text  
  
        //create label for password  
        passLabel = new JLabel();  
        passLabel.setText("Password");      //set label value for textField2  
          
        //create text field to get password from the user  
        textField2 = new JPasswordField(15);    //set length for the password  
          
        //create submit button  
        b1 = new JButton("Submit"); //set label to button  
          
        //create panel to put form elements  
        loginPanel = new JPanel(new GridLayout(3, 1));  
        contentPane.setLayout(new CardLayout());
        loginPanel.add(userLabel);    //set username label to panel  
        loginPanel.add(textField1);   //set text field to panel  
        loginPanel.add(passLabel);    //set password label to panel  
        loginPanel.add(textField2);   //set text field to panel  
        loginPanel.add(b1);           //set button to panel  


        loggedInPanel = new JPanel(new GridLayout(3, 1));

        loggedInUser = new JLabel();
        loggedInRole = new JLabel();

        // Button/link for only managerial roles to see/press
        restrictedButton = new JButton(new AbstractAction("Restricted Link"){
            @Override
            public void actionPerformed( ActionEvent e ) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Restricted Panel");
            }
        });

        // Back button for the restricted page back to logged in page
        backButton = new JButton(new AbstractAction("Back"){
            @Override
            public void actionPerformed( ActionEvent e ) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Logged In Panel");
            }
        });

        // Logout button to bring user back to login page
        logOut = new JButton(new AbstractAction("Log Out"){
            @Override
            public void actionPerformed( ActionEvent e ) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Login Panel");
            }
        });


        loggedInPanel.add(loggedInUser);
        loggedInPanel.add(loggedInRole);
        loggedInPanel.add(restrictedButton);
        loggedInPanel.add(logOut);
        
        restrictedPanel = new JPanel(new GridLayout(3, 1));
        restrictedText = new JLabel();
        restrictedText.setText("This page is only meant to be viewed by Managers");
        restrictedText.setForeground(Color.white);
        restrictedPanel.add(restrictedText);
        restrictedPanel.add(backButton);
        restrictedPanel.setBackground(Color.RED.darker().darker());

        contentPane.add(loginPanel, "Login Panel"); 
        contentPane.add(loggedInPanel, "Logged In Panel");
        contentPane.add(restrictedPanel, "Restricted Panel");
        
        //set border to panel   
        add(contentPane, BorderLayout.CENTER);  
          
        //perform action on button click   
        b1.addActionListener(this);     //add action listener to button  
        setTitle("Login Form");         //set title to the login form  
    }  
      
    //define abstract method actionPerformed() which will be called on button click   
    public void actionPerformed(ActionEvent ae){     //pass action listener as a parameter   
        String userValue = textField1.getText();        //get user entered username from the textField1  
        String passValue = textField2.getText();        //get user entered pasword from the textField2  
          
        
        User userObj;
        
        userObj = new User(userValue, passValue);
        
        boolean successLogin = false;
        try {
            successLogin = LoginController.authenticate(userObj);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(successLogin){
            loggedInUser.setText("User: "+ userObj.getUsername());
            loggedInRole.setText("Role: " + userObj.getRole());
            if(userObj.getRole().equals("Manager")){
                restrictedButton.setVisible(true);
            }
            else{
                restrictedButton.setVisible(false);
            }
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, "Logged In Panel");

        }else{
            //show error message  
            System.out.println("Invalid userid or password, please enter valid username and password");
        }
        
    }  
}  
//create the main class  
class LoginFormDemo  
{  
    //main() method start  
    public static void main(String arg[])  
    {  
        try  
        {  
            //create instance of the CreateLoginForm  
            CreateLoginForm form = new CreateLoginForm();  
            form.setSize(400,200);  //set size of the frame  
            form.setVisible(true);  //make form visible to the user  
        }  
        catch(Exception e)  
        {     
            //handle exception   
            JOptionPane.showMessageDialog(null, e.getMessage());  
        }  
    }  
}  