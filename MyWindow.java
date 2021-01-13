package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyWindow extends JFrame {


    private JButton btnLogin = new JButton("Login");

    private String inputPassword="";
    private String inputUsername="";

    public MyWindow() {
        super("Window Connection");
        System.out.println("début création mywindow");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(new Dimension(600, 400));
        this.setLocationRelativeTo(null);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new GridLayout(3,2, 20,120));

        JButton btnUser = new JButton("User Name");
        contentPane.add(btnUser);

        JTextField txtWriteUserName = new JTextField("");
        contentPane.add(txtWriteUserName);

        JButton btnPassword = new JButton("Password");
        contentPane.add(btnPassword);


        JPasswordField txtWritePassword = new JPasswordField();
        txtWritePassword.setEchoChar('*');
        contentPane.add(txtWritePassword);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Login");
                Connect c = new Connect();
                ArrayList<DataAuthentification> allUsers = c.getAllUsersinDB();
                //allUsers.get(0).getInputUsername()
                inputPassword = String.valueOf(txtWritePassword.getPassword());
                inputUsername = txtWriteUserName.getText();
                System.out.println("fin du click");

                JFrame popup = new JFrame();
                JOptionPane.showMessageDialog(popup, "Are You Sure to Connect ?");

                boolean loginOk = false;
                boolean passwordOk = false;

               for ( int u = 0; u < allUsers.size(); u++) {

                   if (inputUsername.equals(allUsers.get(u).getInputUsername())) {
                       loginOk = true;
                       if(inputPassword.equals(allUsers.get(u).getInputPassword())) {
                           passwordOk = true;
                       }

                   }
               }

               if (loginOk == true) {
                   if (passwordOk == true) {
                       JOptionPane.showMessageDialog(popup, "Successfully Connected");
                   } else {
                       JOptionPane.showMessageDialog(popup, "Password Error?");
                   }
               } else {
                   JOptionPane.showMessageDialog(popup, "user doesn't exist in our database");
               }


            }
            });
        contentPane.add(btnLogin);
        System.out.println("fin création mywindow");
    }

    public String getInputPassword() {
        return inputPassword;
    }

    public void setInputPassword(String inputPassword) {
        this.inputPassword = inputPassword;
    }

    public String getInputUsername() {
        return inputUsername;
    }

    public void setInputUsername(String inputUsername) {
        this.inputUsername = inputUsername;
    }
}


