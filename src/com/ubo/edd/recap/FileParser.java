package com.ubo.edd.recap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileParser {
	private String[] args;

	public FileParser() {
		// TODO Auto-generated constructor stub
	}

	public FileParser(String[] args) {
		this.args = args;
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
			System.out.print("Le fichier \"" + file + "\" contient "
					+ ((LineCountContentHandler) handler).getLineCount()
					+ " ligne(s) ");
			System.out.println("dont "
					+ ((LineCountContentHandler) handler).getCommCount()
					+ " ligne(s) de commentaire(s).");
			if (args != null && args.length > 0
					&& (args[0].equals("-e") || args[0].equals("--empty"))) {
				System.out.println("Et "
						+ ((LineCountContentHandler) handler).getEmptyLine()
						+ " ligne(s) vide(s).");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
