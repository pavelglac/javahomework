/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahw;

import java.util.ArrayList;

/**
 *
 * @author pavel
 */
public class Castle
        implements ICastle
{

    private IPlace region;
    private ArrayList<IPlace> listOfRegions;
    private ArrayList<String> exportedRegionsHelp;
    private String[] exportedRegions;

    
    public Castle()
    {
        
        listOfRegions = new ArrayList<IPlace>();
        
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
             
        Place plzen = new Place("Plzeňský kraj",
                new String[]{"Hrad Kašperk", "/javahw/img/plzen/kasperk.jpg"},
                new String[]{"Hrad Klenová", "/javahw/img/plzen/klenova.jpg"},
                new String[]{"Hrad Švihov", "/javahw/img/plzen/svihov.jpg"},
                new String[]{"Zámek Bezdružice", "/javahw/img/plzen/bezdruzice.jpg"},
                new String[]{"Zámek Bor", "/javahw/img/plzen/bor.jpg"});
            registerRegion(plzen);   

       
        setRegion(hradec);
    }
    
    public IPlace getRegion()
    {
        
        return region;
        
    }
    
    public void setRegion(IPlace place)
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
            IPlace item = getRegions().get(i);
            exportedRegionsHelp.add(item.getName());
            
        }
        
        String[] exportedRegions = new String[exportedRegionsHelp.size()];
        exportedRegions = exportedRegionsHelp.toArray(exportedRegions);
        
        return exportedRegions;
        
    }
    
    @Override
    public ArrayList<IPlace> getRegions()
    {
        
        return listOfRegions;
        
    }
}
