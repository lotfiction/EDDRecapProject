package com.ubo.edd.recap.v1;

import com.ubo.edd.recap.ContentHandler;

/**
 * 
 * classe pocalculer le nombre des lignes
 * 
 * @author ELMAATAOUI YASSINE DOSI
 * 
 */
public class LineCountContentHandler implements ContentHandler {

	private int pageCount = 0;

	/**
	 * compteur de ligne pour le fichier
	 */
	@Override
	public void defaultLine(String content) {
		pageCount++;
	}

	/**
	 * retourner le nombre des lignes
	 * 
	 * @return
	 */
	public int getPageCount() {
		return pageCount;
	}
}
