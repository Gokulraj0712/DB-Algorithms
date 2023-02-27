package com.exercise3.vinny.vinu;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class recursiveFileSearch 
{

	//recursive function to search files in the directory
    public static List<File> searchFiles(File root, String filename) 
    {
        List<File> resultList = new ArrayList<File>();
        if (root.isDirectory()) 
        {
            File[] fileList = root.listFiles(); //get names of all files in directory
            if (fileList != null) 
            {
                for (File file : fileList) 
                {
                    if (file.isDirectory()) 
                    {
                        resultList.addAll(searchFiles(file, filename));
                    } else if (filename.equalsIgnoreCase(file.getName())) {
                        resultList.add(file);
                    }
                }
            }
        }
        return resultList;
    }

    public static void main(String[] args) 
    {
        String path = "/Users/vinny/Documents";
        String filename = "test.txt";
        List<File> result = searchFiles(new File(path), filename);
        for (File file : result) 
        {
            System.out.println(file.getAbsolutePath());
        }
    }
}
