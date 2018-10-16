/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahw;

import java.util.Collection;
import static java.util.Collections.list;
import java.util.Random;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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
    private Label label;
    private AnchorPane topAnchorPane;
    int order;

    @Override
    public void start(Stage primaryStage)
    {

        borderPane = new BorderPane();
        Button btn = new Button();
        region = new Castle();
        VBox vbox = new VBox();
        Scene scene = new Scene(borderPane, 1000, 600);
        ToggleGroup group = new ToggleGroup();
        Random rand = new Random();


        String[] regions = region.getRegionsNames();
        RadioButton[] buttons = new RadioButton[regions.length];;
        
        for (int i = 0; i < regions.length; i++) {

            buttons[i] = new RadioButton(regions[i].toString());
            buttons[i].setToggleGroup(group);
            vbox.getChildren().add(buttons[i]);
            
            topAnchorPane = new AnchorPane();            
            int help = i;
            buttons[i].setOnAction(new EventHandler<ActionEvent>()
            {

                @Override
                public void handle(ActionEvent event)
                {
                    borderPane.setRight(null);
                    borderPane.setLeft(null);
                    topAnchorPane.getChildren().clear();
                    Place list = region.getRegions().get(help);
                    region.setRegion(list);
//                    listOfCastles = new ListOfCastles(region.getRegion());
//                    listOfCastles.update();
//                    borderPane.setRight(listOfCastles.getList());
                    
//                    String[] neco = new String[region.getRegions().size()];
//                    neco = region.getRegions().toArray(neco);
                    String[][] castles =  region.getRegion().getCastles();
                    int x = 0;
                    
                    for (int i = 0; i < region.getRegion().getCastles().length; i++) {
                        
                        String img = castles[i][1];
                        String name = castles[i][0];
                        Label label = new Label(name);
//                        ImageView mapImageView = new ImageView(new Image(Javahomework.class.getResourceAsStream(img), 100, 100, false, false));
//                        mapImageView.setX(x);
                        label.setGraphic(new ImageView(new Image(Javahomework.class.getResourceAsStream(img), 100, 100, false, false)));
                        label.setLayoutY(x);
                        x = x + 100;
                        topAnchorPane.getChildren().add(label);
//                        borderPane.setLeft(topAnchorPane);
                    
                    }
                    
                  borderPane.setLeft(topAnchorPane);

                }
            });
            vbox.setAlignment(Pos.BASELINE_CENTER);
        }
        
        
        btn.setText("Hádej");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                    listOfCastles = new ListOfCastles(region.getRegion());
                    listOfCastles.update();
                    borderPane.setRight(listOfCastles.getList());
                    topAnchorPane.getChildren().clear();
                    
                    String[][] castles =  region.getRegion().getCastles();
                    int  n = rand.nextInt(region.getRegion().getCastles().length);
                    ImageView mapImageView = new ImageView(new Image(Javahomework.class.getResourceAsStream(castles[n][1]), 300, 300, false, false));
                    topAnchorPane.getChildren().add(mapImageView);
                    String[] neco = new String[region.getRegions().size()];
                    neco = region.getRegions().toArray(neco);
            }
        });

        borderPane.setBottom(btn);
        borderPane.setTop(vbox);

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
