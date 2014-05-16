package br.com.pilovieira.dropsync.process;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public abstract class Process {
	    
	protected String targetPath;
	protected File sourceFile;
	
	public Process(File sourceFile, String targetPath) {
		this.sourceFile = sourceFile;
		this.targetPath = targetPath;
	}
		
    public void run() {
    	File destinationFile = makeDestinationFile();
    	try {
			copyFile(sourceFile, destinationFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	protected abstract String makeStringPath();
	    
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

	private File makeDestinationFile() {
		String destinationPath = makePathDirs().getAbsolutePath();
		File destinationFile = new File(destinationPath + "\\" + sourceFile.getName());
		return destinationFile;
	}

	private File makePathDirs() {
		File directory = new File(makeStringPath());
		directory.mkdirs();
		return directory;
	}
}
