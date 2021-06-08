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

    static JFrame jFrame = getFrame(); // создание форы
    static JPanel jPanel = new JPanel(); // и панели

    public static void main(String[] args) {
	    jFrame.add(jPanel); // панель на форму
        ((JButton)jPanel.add(new JButton("submit"))).addActionListener(new ActionListener() { // из панели, кнопку с действием
            @Override
            public void actionPerformed(ActionEvent e) { // действие
                try {
                    FileOpenService service = (FileOpenService) ServiceManager.lookup("javax.jnlp.FileContents"); // открыть
                    FileContents fileContents =service.openFileDialog(".", new String[]{"txt"}); // отобразить файлы данной категории
                    if (fileContents!=null){
                        System.out.println(fileContents); // вывод в кносоль
                    }
                } catch (UnavailableServiceException | IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    static JFrame getFrame(){ // наша форма
        JFrame jFrame = new JFrame(){}; // новая
        jFrame.setVisible(true); // видимость
        jFrame.setBounds(750,250,500,500); // размеры
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрытие
        return jFrame;
    }
}

// Необходимо скачать:
// https://docs.oracle.com/javase/tutorial/deployment/webstart/deploying.html
