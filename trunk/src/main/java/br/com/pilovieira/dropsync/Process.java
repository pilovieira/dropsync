package br.com.pilovieira.dropsync;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public abstract class Process {
	    
	protected String targetPath;
	private File sourceFile;
	
	public Process(File sourceFile, String targetPath) {
		this.sourceFile = sourceFile;
		this.targetPath = targetPath;
	}
		
    public void run() {
    	String destinationPath = makePath(sourceFile).getAbsolutePath();
    	File destinationFile = new File(destinationPath + "\\" + sourceFile.getName());
    	
    	try {
			copyFile(sourceFile, destinationFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	protected abstract File makePath(File file);
	    
	private void copyFile(File source, File destination) throws IOException {
		if (destination.exists())
			return;

		FileChannel sourceChannel = null;
		FileChannel destinationChannel = null;

		try {
			sourceChannel = new FileInputStream(source).getChannel();
			destinationChannel = new FileOutputStream(destination).getChannel();
			sourceChannel.transferTo(0, sourceChannel.size(),
					destinationChannel);
		} finally {
			if (sourceChannel != null && sourceChannel.isOpen())
				sourceChannel.close();
			if (destinationChannel != null && destinationChannel.isOpen())
				destinationChannel.close();
		}
	}
}
