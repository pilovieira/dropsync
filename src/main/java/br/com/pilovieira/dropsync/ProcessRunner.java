package br.com.pilovieira.dropsync;

import java.io.File;

public class ProcessRunner {
	
	public static void execute(String sourcePath, String targetPath) {
        File source = new File(sourcePath);
        
        for (File file : source.listFiles())
        	if (isValid(file))
        		getProcess(source, file, targetPath).run();
        
        for (File file : source.listFiles())
        	file.delete();
    }
	
    private static boolean isValid(File file) {
    	return file.getName().matches("\\d{4}-\\d{2}-\\d{2} .*");
    }
    
	private static Process getProcess(File source, File file, String targetPath) {
		System.out.println("processing file: " + file.getName());
		
		if (isForAlbum(file, source))
			return new ProcessAlbum(file, targetPath);
		
		return new ProcessLimbo(file, targetPath);
	}
	
	private static boolean isForAlbum(File file, File source) {
		String data = file.getName().split(" ")[0];
		
		int i = 0;
		for (File f: source.listFiles())
			if (f.getName().contains(data))
				i++;
		
		return i > 2;
	}
}
