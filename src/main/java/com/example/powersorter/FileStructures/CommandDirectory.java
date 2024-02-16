package com.example.powersorter.FileStructures;

/**
 * An interface that defines the implementation of commandDirectories
 * these are directories that accept files based on pre-determined rules.
 * E.g if a filter folder exist in a directory it can have a criteria of files it accepts, files it accepts that are moved
 * toi the same parent directory as it can be moved into the filter folder itself.
 */
public interface CommandDirectory {

    /**
     * gets the age of the commandDirectory, older commandDirectories in the same parent directory should get the chance
     * to accept a new file before younger ones do.
     * @return the age of the directory, as a serial number (lower numbers are older)
     */
    public long getAge();

    /**
     * queries a command directory if it accepts a specific file, if this file is accepted it should be moved
     * to within the command directory (though the moving is not done in the implementation of this methode);
     * @param offeredFile file checked to see if it matches the commandDirectories requirements
     * @return wether the file is accepted into the command directory or not.
     */
    public boolean offer(IndvFile offeredFile);
}
