package com.ubo.edd.recap;

public class LineCountContentHandler implements ContentHandler {

	private int lineCount = 0;
	private int emptyLine = 0;
	private int commCount = 0;
	private String[] params;

	public LineCountContentHandler() {
		super();
	}

	public LineCountContentHandler(String[] params) {
		super();
		this.params = params;
	}

	@Override
	public void defaultLine(String content) {
		if (params != null
				&& (params[0].equals("-e") || params[0].equals("--empty"))) {
			if (content.trim().equals("")) {
				emptyLine++;
			} else {
				lineCount++;
			}
		} else {
			lineCount++;
		}
		commentLine(content);
	}

	@Override
	public void commentLine(String comment) {
		if (comment.startsWith("#")) {
			commCount++;
		}
	}

	public int getLineCount() {
		return lineCount;
	}

	public int getCommCount() {
		return commCount;
	}

	public int getEmptyLine() {
		return emptyLine;
	}

}
