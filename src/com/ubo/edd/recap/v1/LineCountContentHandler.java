package com.ubo.edd.recap.v1;

import com.ubo.edd.recap.ContentHandler;

public class LineCountContentHandler implements ContentHandler {

	private int pageCount = 0;

	@Override
	public void defaultLine(String content) {
		pageCount++;
	}

	public int getPageCount() {
		return pageCount;
	}
}
