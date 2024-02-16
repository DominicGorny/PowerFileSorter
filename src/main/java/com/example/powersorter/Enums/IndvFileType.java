package com.example.powersorter.Enums;

public enum IndvFileType {
    LoadedFile, //a normal file found when discovering files using FileCollector
    Directory, // a basic folder
    Origin, //the top level directory PowerSorter uses to store loaded files (does not exist in file system)
    CommandDirectory //A directory created in power sorter that can claim files (e.g a filter folder can automatically
                     //grab files from the directory it is in
}
