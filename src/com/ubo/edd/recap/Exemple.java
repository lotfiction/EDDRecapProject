package com.ubo.edd.recap;

import java.io.File;
import java.io.FileNotFoundException;

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

	public static void main(String[] args) throws FileNotFoundException {
		new Exemple();
		FileParser f=new FileParser();
		if (f.check_xml("build.xml")) System.out.println("Ce ficher est un fichier xml");
		else System.out.println("Ce fichier n'est pas un fichier xml");

	}
}
