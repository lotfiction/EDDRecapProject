package com.ubo.edd.recap;

import java.io.File;

public class Exemple {

	private FileParser parser;
	private ContentHandler handler;
	private File file;

	void exp01() {
		file = new File("tests/test.txt");
		handler = new LineCountContentHandler();
		parser.parse(file, handler);
	}

	void exp02(String[] params) {
		file = new File("tests/test.txt");
		handler = new LineCountContentHandler(params);
		parser.parse(file, handler);
	}

	public Exemple(String[] args) {
		parser = new FileParser(args);
		System.out.println("Exemple d'utlisation de FileParser :");
		if (args.length == 0) {
			exp01();
		} else {
			exp02(args);
		}
	}

	public static void main(String[] args) {
		new Exemple(args);
	}
}
