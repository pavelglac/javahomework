package javahw;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pavel
 */
public interface IObserver
        extends ICastle
{
    
public void setObserver(IUpdateObserver observer);

public void removeObserver(IUpdateObserver observer);

public void updateObserver();

    
}
