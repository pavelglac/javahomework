/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahw;

import java.util.Collection;
import static java.util.Collections.list;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author pavel
 */
public class Javahomework
        extends Application
{

    private BorderPane borderPane;
    private Castle region;
    private ListOfCastles listOfCastles;
    int order;

    @Override
    public void start(Stage primaryStage)
    {

        borderPane = new BorderPane();
        Button btn = new Button();
        region = new Castle();
        VBox vbox = new VBox();
        Scene scene = new Scene(borderPane, 300, 250);
        ToggleGroup group = new ToggleGroup();


        String[] regions = region.getRegionsNames();
        RadioButton[] buttons = new RadioButton[regions.length];;
        
        for (int i = 0; i < regions.length; i++) {

            buttons[i] = new RadioButton(regions[i].toString());
            buttons[i].setToggleGroup(group);
            vbox.getChildren().add(buttons[i]);
            
            int help = i;
            buttons[i].setOnAction(new EventHandler<ActionEvent>()
            {

                @Override
                public void handle(ActionEvent event)
                {
                    Place list = region.getRegions().get(help);
                    region.setRegion(list);
                    listOfCastles = new ListOfCastles(region.getRegion());
                    listOfCastles.update();
                    borderPane.setRight(listOfCastles.getList());
                    
                    


                }
            });

        }
        
        
        btn.setText("Hádej");

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
            }
        });

        borderPane.setTop(btn);
        borderPane.setCenter(vbox);

        primaryStage.setTitle("Kde domov můj");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
