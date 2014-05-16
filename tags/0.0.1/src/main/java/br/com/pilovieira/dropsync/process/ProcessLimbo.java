package br.com.pilovieira.dropsync.process;

import java.io.File;


public class ProcessLimbo extends Process {
	
	public ProcessLimbo(File sourceFile, String targetPath) {
		super(sourceFile, targetPath);
	}

	@Override
	protected String makeStringPath() {
		return targetPath + "\\" + DropFile.getAno(sourceFile) + "\\Celular";
	}
}
