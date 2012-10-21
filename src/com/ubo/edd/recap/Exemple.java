package com.ubo.edd.recap;

import java.io.File;

import com.ubo.edd.recap.v1.LineCountContentHandler;

public class Exemple {

	private FileParser parser;
	private ContentHandler handler;
	private File file;

	void exp01() {
		file = new File("tests/test.txt");
		handler = new LineCountContentHandler();
		parser.parse(file, handler);
	}

	public Exemple() {
		parser = new FileParser();
		System.out.println("Test");
		System.out.println("Exemple d'utlisation de FileParser :");
		exp01();
	}

	public static void main(String[] args) {
		new Exemple();
	}
}
