/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author pavel
 */
public class Castle
        implements IObserver
{

    private List<IUpdateObserver> listOfObservers;
    private Place region;
    private ArrayList<Place> listOfRegions;
    private ArrayList<String> exportedRegionsHelp;
    private String[] exportedRegions;

    
    public Castle()
    {
        
        listOfRegions = new ArrayList<Place>();
        
        Place hradec = new Place("Královéhradecký kraj",
                new String[]{"Zámek Častolovice", "/javahw/img/hradec/castolovice.jpg"},
                new String[]{"Zámek Náchod", "/javahw/img/hradec/nachod.jpg"},
                new String[]{"Zámek Ratibořice", "/javahw/img/hradec/ratiborice.jpg"},
                new String[]{"Zámek Dětenice", "/javahw/img/hradec/detenice.jpg"},
                new String[]{"Hrad Potštejn", "/javahw/img/hradec/potstejn.jpg"});
            registerRegion(hradec);
            
        Place pardubice = new Place("Pardubický kraj",
                new String[]{"Zámek Letohrad", "/javahw/img/pardubice/letohrad.jpg"},
                new String[]{"Hrad Svojanov", "/javahw/img/pardubice/svojanov.jpg"},
                new String[]{"Hrad Rychmburk", "/javahw/img/pardubice/rychmburk.jpg"},
                new String[]{"Zámek Choltice", "/javahw/img/pardubice/choltice.jpg"},
                new String[]{"Zámek Jaroměřice", "/javahw/img/pardubice/jaromerice.jpg"});
            registerRegion(pardubice);
            
        Place plzen = new Place("Plzeňský kraj", new String[]{"Zámek Plzeň jedna", "img"}, new String[]{"Zámek Plzeň dva", "img"});
            registerRegion(plzen);        
       
        setRegion(hradec);
    }
    
    public Place getRegion()
    {
        
        return region;
        
    }
    
    public void setRegion(Place place)
    {
        
        region = place;
        
    }
    
    public void registerRegion(Place place)
    {
        
        listOfRegions.add(place);
        
    }
    
    @Override
    public String[] getRegionsNames()
    {
        exportedRegionsHelp = new ArrayList<String>();
        
        for (int i = 0; i < getRegions().size(); i++)
        {
            Place item = getRegions().get(i);
            exportedRegionsHelp.add(item.getName());
            
        }
        
        String[] exportedRegions = new String[exportedRegionsHelp.size()];
        exportedRegions = exportedRegionsHelp.toArray(exportedRegions);
        
        return exportedRegions;
        
    }
    
    @Override
    public ArrayList<Place> getRegions()
    {
        
        return listOfRegions;
        
    }

    @Override
    public void setObserver(IUpdateObserver observer)
    {
        
        listOfObservers.add(observer);
        
    }

    @Override
    public void removeObserver(IUpdateObserver observer)
    {
        
        listOfObservers.remove(observer);
        
    }

    @Override
    public void updateObserver()
    {
        
        for (IUpdateObserver observer : listOfObservers)
        {
            
            observer.update();
            
        }
        
    }

}
