package com.example.powersorter.Enums;

import java.util.Objects;

public enum FolderViewTabs {
    Basic("Basic", "Basic Folder"),
    Filter("Filter", "Filter Folder"),
    Categorised("Categorised", "Categorised Folder");


    public final String code;
    public final String name;

    FolderViewTabs(String code, String name)
    {
        this.code = code;
        this.name = name;
    }

    /**
     * return the tab enum value of the tab with the desired name
     * @param targetName the name iof the desired tab
     * @return the tabs enum value
     */
    public static FolderViewTabs getByName(String targetName)
    {
        for (FolderViewTabs tab: FolderViewTabs.values())
        {
            if (Objects.equals(tab.name, targetName))
            {
                return tab;
            }
        }
        return null;
    }
}
