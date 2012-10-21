package com.ubo.edd.recap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

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
					+ ((LineCountContentHandler) handler).getLineCount()
					+ " ligne(s).");
			System.out.println("Dont "
					+ ((LineCountContentHandler) handler).getCommCount()
					+ " commentaire(s).");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public String getbalise(Scanner ss){
		LineCountContentHandler handler=new LineCountContentHandler();
		 String mot=null;
		while(ss.hasNext()){
		 mot = ss.next();
			if((mot.startsWith("<") || mot.startsWith("</")) && mot.endsWith(">")){
				handler.callback(mot);
					return mot;}}
		return null;
		
		
	}
	public Boolean check_xml(String file) throws FileNotFoundException{
		Scanner ss=new Scanner(new File(file));
		LinkedList<String>  Pile=new LinkedList<String>();
		
		if (file.endsWith(".xml")){
			if(ss.nextLine().contains("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")){
				String balise =getbalise(ss);
				if (balise == null) return true;
				else{
				Pile.addFirst(balise);
				
				while(ss.hasNext() && !Pile.isEmpty())
				{ String bb=getbalise(ss);
					if (Pile.getFirst().equals(bb.replace("/", "")))
						Pile.removeFirst();
					else Pile.addFirst(bb);
				
					
					
				}
				
				
			}
				
				
			return Pile.isEmpty();
			
			
			}
			return false; 
			
		}return false;
		
		
		
		
	}
}
