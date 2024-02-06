package com.example.powersorter.actions.topLevelActions;

import com.example.powersorter.actions.ActionInterface;

/**
 * interface that prescribes action functions for lowLevelActions.
 */
public interface TopLevelAction extends ActionInterface {

    /**
     * returns true if this action uses legal parameters
     * @return action validity state
     */
    boolean getActionValid();

}
