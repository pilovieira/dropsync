package br.com.pilovieira.dropsync.process;

import java.io.File;

public class DropFile {

	public static String getAno(File file) {
		return file.getName().split("-")[0];
	}

	public static String getData(File file) {
		return file.getName().split(" ")[0];
	}
	
    public  static boolean isValid(File file) {
    	return file.getName().matches("\\d{4}-\\d{2}-\\d{2} .*");
    }
}
