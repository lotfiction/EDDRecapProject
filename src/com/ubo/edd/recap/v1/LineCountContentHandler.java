package com.ubo.edd.recap.v1;

import com.ubo.edd.recap.ContentHandler;

public class LineCountContentHandler implements ContentHandler {

	private int lineCount = 0;
	private int commCount = 0;

	public int getLineCount() {
		return lineCount;
	}

	public int getCommCount() {
		return commCount;
	}

	@Override
	public void defaultLine(String content) {
		commentLine(content);
		lineCount++;
	}

	@Override
	public void commentLine(String comment) {
		if (comment.startsWith("#")) {
			commCount++;
		}
	}

}
