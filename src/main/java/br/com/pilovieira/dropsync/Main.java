package br.com.pilovieira.dropsync;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		if (args.length != 2)
			throw new RuntimeException("Invalid argument numbers.");
		
        ProcessRunner.execute(args[0], args[1]);
    }
}