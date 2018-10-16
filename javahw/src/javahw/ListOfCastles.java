/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahw;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

/**
 *
 * @author pavel
 */
public class ListOfCastles
    implements IUpdateObserver
{
    
    private Place place;
    ListView<String> list;
    
    public ListOfCastles(Place place) {
        this.place = place;
        list = new ListView<>();
        list.setPrefWidth(200);

    }
    
        private void init() {
//        place = new Castle();
//        list = new ListView<>();
//        String[][] castles =  place.getRegion().getCastles();
//        for (int i = 0; i < castles.length; i++)
//        {
//            String item = castles[i][0];
//            list.getItems().add(item);
//            
//        }
        
    }
    
    @Override
    public void update() {
        list.getItems().clear();
        String[][] castles =  place.getCastles();
        for (int i = 0; i < castles.length; i++)
        {
            String item = castles[i][0];
            list.getItems().add(item);
            
        }

    }
    
    public ListView<String> getList() {
        return list;
    }
    
}
