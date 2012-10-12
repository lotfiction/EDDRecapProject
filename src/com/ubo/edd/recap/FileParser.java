package com.ubo.edd.recap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.ubo.edd.recap.v1.LineCountContentHandler;

public class FileParser {

	public FileParser() {
		// TODO Auto-generated constructor stub
	}

	public void parse(File file, ContentHandler handler) {
		BufferedReader bufferFile;
		try {
			bufferFile = new BufferedReader(new FileReader(file));
			String line;
			do {
				line = bufferFile.readLine();
				if (line != null) {
					handler.defaultLine(line);
				}
			} while (line != null);
			System.out.println("Le fichier \"" + file + "\" contient "
					+ ((LineCountContentHandler) handler).getPageCount()
					+ " ligne(s).");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
