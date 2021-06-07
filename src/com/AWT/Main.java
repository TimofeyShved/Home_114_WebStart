package com.AWT;

import javax.jnlp.FileContents;
import javax.jnlp.FileOpenService;
import javax.jnlp.ServiceManager;
import javax.jnlp.UnavailableServiceException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main { // Java Web Start

    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();

    public static void main(String[] args) {
	    jFrame.add(jPanel);
        ((JButton)jPanel.add(new JButton("submit"))).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileOpenService service = (FileOpenService) ServiceManager.lookup("javax.jnlp.FileContents");
                    FileContents fileContents =service.openFileDialog(".", new String[]{"txt"});
                    if (fileContents!=null){
                        System.out.println(fileContents);
                    }
                } catch (UnavailableServiceException | IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    static JFrame getFrame(){
        JFrame jFrame = new JFrame(){};
        jFrame.setVisible(true);
        jFrame.setBounds(750,250,500,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}

// Необходимо скачать:
// https://docs.oracle.com/javase/tutorial/deployment/webstart/deploying.html
