package br.com.pilovieira.dropsync;

import java.io.File;

public class ProcessAlbum extends Process {
	
	public ProcessAlbum(File sourceFile, String targetPath) {
		super(sourceFile, targetPath);
	}

	@Override
	protected File makePath(File file) {
		String ano = file.getName().split("-")[0];
    	String data = file.getName().split(" ")[0];
    	
    	File directory = new File(targetPath + "\\" + ano + "\\" + data);
		directory.mkdirs();
		
		return directory;
	}

}
