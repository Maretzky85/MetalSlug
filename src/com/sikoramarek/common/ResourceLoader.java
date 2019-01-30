package com.sikoramarek.common;

import java.io.File;
import java.util.ArrayList;

public class ResourceLoader {

	public static ArrayList<String> load(String patch)
	{
		ArrayList<String> tempArray = new ArrayList<>();
		// create a file that is really a directory
		File aDirectory = new File(patch);
//		System.out.println(aDirectory);
		// get a listing of all files in the directory
		String[] filesInDir = aDirectory.list();

		// sort the list of files (optional)
		// Arrays.sort(filesInDir);

		// have everything i need, just print it now
		for ( int i=0; i<filesInDir.length; i++ )
		{
			tempArray.add(filesInDir[i]);
			System.out.println( "file: " + filesInDir[i] );
		}
		return tempArray;
	}
}