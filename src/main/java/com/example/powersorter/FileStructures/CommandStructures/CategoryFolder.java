package com.example.powersorter.FileStructures.CommandStructures;

import com.example.powersorter.FileStructures.IndvFile;

/**
 * Class that defines the function of a category folder
 * Category folders take any items from their directory that matches a specific category
 * e.g There might be a category folder for file type, this means that each file is filed in such a way
 * that each file type has its own folder
 */
public class CategoryFolder extends CommandDirectory{
    @Override
    public boolean offer(IndvFile offeredFile) {
        return false;
    }
}
