package br.com.pilovieira.dropsync;

import java.io.File;

public class ProcessLimbo extends Process {
	
	public ProcessLimbo(File sourceFile, String targetPath) {
		super(sourceFile, targetPath);
	}

	@Override
	protected File makePath(File file) {
		File limboPath = new File(targetPath + "\\Celular");
		limboPath.mkdirs();
		
		return limboPath;
	}
}
