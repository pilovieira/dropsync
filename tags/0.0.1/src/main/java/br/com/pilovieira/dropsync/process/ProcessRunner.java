package br.com.pilovieira.dropsync.process;

import static br.com.pilovieira.dropsync.process.DropFile.getData;
import static br.com.pilovieira.dropsync.process.DropFile.isValid;

import java.io.File;

public class ProcessRunner {
	
	public static void execute(String sourcePath, String targetPath) {
        File source = new File(sourcePath);
        
        for (File file : source.listFiles())
        	if (isValid(file))
        		getProcess(source, file, targetPath).run();
        
        deleteValidFiles(source);
    }

	private static void deleteValidFiles(File source) {
		for (File file : source.listFiles())
        	if (isValid(file))
        		file.delete();
	}
		
	private static Process getProcess(File source, File file, String targetPath) {
		System.out.println("processing file: " + file.getName());
		
		if (isForAlbum(file, source))
			return new ProcessAlbum(file, targetPath);
		
		return new ProcessLimbo(file, targetPath);
	}
	
	private static boolean isForAlbum(File file, File source) {
		int i = 0;
		for (File f: source.listFiles())
			if (f.getName().contains(getData(file)))
				i++;
		
		return i > 2;
	}
}
