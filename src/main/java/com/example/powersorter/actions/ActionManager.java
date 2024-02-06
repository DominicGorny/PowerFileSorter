package com.example.powersorter.actions;

import com.example.powersorter.actions.topLevelActions.TopLevelAction;

import java.util.ArrayList;

/**
 * this object is in charge of collecting all actions to be performed
 * on the bottom end and executes them when prompted to
 * This is a singleton class
 */
public class ActionManager {

    private ArrayList<TopLevelAction> actions = new ArrayList<>();
    private static ActionManager appManager = null;

    /**
     * returns the actionManager and creates it if it does not exist
     * @return actionManager reference
     */
    public static ActionManager getManager()
    {
        if (appManager == null)
        {
            appManager = new ActionManager();
        }
        return appManager;
    }

    public void addAction(TopLevelAction newAction)
    {
        actions.add(newAction);
    }

    public boolean executeAll()
    {
        for (TopLevelAction action: actions)
        {
            action.executeAction();
        }
        return true;
    }




}
