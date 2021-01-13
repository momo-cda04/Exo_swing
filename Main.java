package com.company;

import javax.management.Query;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.ErrorManager;

public class Main {


    public static void main(String[] args) throws Exception {
        //affichage de la windows
        System.out.println("début du main");
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        MyWindow myWindow = new MyWindow();
        myWindow.setVisible(true);

        Connect c = new Connect();
        ArrayList<DataAuthentification> allUsers = c.getAllUsersinDB();
        String inputPassword = myWindow.getInputPassword();
        String inputUsername= myWindow.getInputUsername();
        System.out.println(inputUsername);
        System.out.println("fin du main");




    }

    }

