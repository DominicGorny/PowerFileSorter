package com.example.powersorter.lowLevelActions;

import java.util.ArrayList;

/**
 * this object is in charge of collecting all actions to be performed
 * on the bottom end and executes them when prompted to
 * This is a singleton class
 */
public class lowLevelActionManager {

    private ArrayList<lowLevelAction> actions = new ArrayList<>();
    private static lowLevelActionManager appManager = null;

    /**
     * returns the actionManager and creates it if it does not exist
     * @return actionManager reference
     */
    public lowLevelActionManager getManager()
    {
        if (appManager == null)
        {
            appManager = new lowLevelActionManager();
        }
        return appManager;
    }

    public void addAction(lowLevelAction newAction)
    {
        actions.add(newAction);
    }




}
