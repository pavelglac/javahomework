/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahw;



/**
 *
 * @author pavel
 */
public class Place
    implements IPlace
{

    private final String name;    
    private final String[][] castles;
    
    

    Place(String name, String[]... itemNames)
    {
        
        this.name = name;
        this.castles = itemNames;
       
        
    }
       
    
    
    @Override
    public String getName()
    {
        
        return name;
        
    }
       

    @Override    
    public String[][] getCastles()
    {
        
        return castles;
        
    }

}
