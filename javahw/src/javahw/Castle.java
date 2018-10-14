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
    private static final  String[] exportedRegions = {"Královéhradecký kraj","Pardubický kraj","Plzeňský kraj"};
    private ArrayList<Place> listOfRegions;

    
    public Castle()
    {
        
        listOfRegions = new ArrayList<Place>();
        
        Place hradec = new Place(exportedRegions[0], new String[]{"Zámek jedna", "img"}, new String[]{"Zámek dva", "img"},new String[]{"Zámek tři", "img"});
            registerRegion(hradec);
            
        Place pardubice = new Place(exportedRegions[1], new String[]{"Zámek Pardubice jedna", "img"}, new String[]{"Zámek Pardubice dva", "img"});
            registerRegion(pardubice);
            
        Place plzen = new Place(exportedRegions[2], new String[]{"Zámek Plzeň jedna", "img"}, new String[]{"Zámek Plzeň dva", "img"});
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
