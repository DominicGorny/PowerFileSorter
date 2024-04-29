package com.example.powersorter.FileStructures.CommandStructures;

import com.example.powersorter.FileStructures.IndvFile;

/**
 * Defines the functionality of a filter folder,
 * A filter folder will take all files in it's directory that match the filter that it has been set up
 * For example there might be a filter folder that takes all .env files and stores them within itself.
 */
public class FilterFolder extends CommandDirectory{
    @Override
    public boolean offer(IndvFile offeredFile) {
        return false;
    }
}
