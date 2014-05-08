package br.com.pilovieira.dropsync.process;

import static br.com.pilovieira.dropsync.process.DropFile.getAno;

import java.io.File;


public class ProcessAlbum extends Process {
	
	public ProcessAlbum(File sourceFile, String targetPath) {
		super(sourceFile, targetPath);
	}

	@Override
	protected String makeStringPath() {
    	return targetPath + "\\" + getAno(sourceFile) + "\\" + DropFile.getData(sourceFile);
	}
}
