package ru.krokhalev;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.*;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;


import java.awt.*;
import java.io.InputStream;
import java.util.Collection;
import java.util.logging.Level;

public class MainApp extends Application {
    final static Logger logger = Logger.getLogger(MainApp.class);

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FlowPane root = new FlowPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);

        // Button 1
        Button button1 = new Button("Button with Text");
        for (int i=1;i<=5;i++){
            root.getChildren().add(new CheckBox("ЧБ"+i));
            logger.info("создаем ЧБ N"+i);

            //пробуем юзать json
            // ObjectMapper mapper = new ObjectMapper();
            //mapper.writeValue(new FileOutputStream(filepath, user);
            LogFile logFile = new LogFile();
            logFile.pathTo="pathTo";
            logFile.pathFrom="pathFrom";
            ObjectMapper mapper = new ObjectMapper();


            try {
// Выводим в json файл
                mapper.writeValue(new FileOutputStream(System.getProperty("user.dir") + File.separator + "user.json"), logFile);
                // Выводим на консоль
                System.out.println(mapper.writeValueAsString(logFile));
            } catch (IOException ex) {
                logger.error("ошибка при записи файла на диск " + ex);
            }





        }



        root.getChildren().addAll(button1);

        stage.setTitle("Java Button (o7planning.org)");

        Scene scene = new Scene(root, 350, 150);
        stage.setScene(scene);
        stage.show();


    }
}