package net.hilaryoi.four.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TextUtil {

	String charIndex;
	Image[] letters;

	int[] spacings;
	int letterHeight;

	int kerning;

	public TextUtil(String spriteSheetPath, int spriteHeight, int scale, int kerning) throws IOException {

		this.kerning = kerning;
		letterHeight = spriteHeight * scale;

		charIndex = "abcdefghijklmnopqrstuvwxyz?!. ";

		int[] spriteSpacings = new int[] { //
				3, 3, 3, 3, 3, 3, 3, 3, 3, 3, //
				3, 3, 5, 4, 4, 3, 5, 3, 4, 3, //
				3, 3, 5, 3, 3, 3, 3, 1, 1, 2 };

		ImageUtil iu = new ImageUtil();

		BufferedImage[] rawLetters;

		try {
			rawLetters = iu.getUnresizedSprites("/alphabet-05.png", spriteHeight);

		} catch (IOException e) {
			e.printStackTrace();
			return;

		}

		letters = new Image[rawLetters.length];

		spacings = new int[spriteSpacings.length];

		// scale spacings
		for (int i = 0; i < spriteSpacings.length; i++) {

			spacings[i] = spriteSpacings[i] * scale;

		}

		for (int i = 0; i < rawLetters.length; i++) {
			letters[i] = rawLetters[i].getSubimage(0, 0, spriteSpacings[i], 5).getScaledInstance(spacings[i], spriteHeight * scale, 0);

		}

	}

	public void drawString(Graphics2D g2d, String string, int x, int y) {

		int currX = x;

		for (int i = 0; i < string.length(); i++) {

			int letterIndex = charIndex.indexOf(string.charAt(i));

			g2d.drawImage(letters[letterIndex], currX + kerning, y, null);

			currX += spacings[letterIndex];

			currX += kerning;

		}

	}

	public void drawLines(Graphics2D g2d, String string, int x, int y) {

		String[] lines = string.split("\n");

		// loops thru lines
		for (int i = 0; i < lines.length; i++) {

			// TODO: should we have to add kerning every time? No
			drawString(g2d, lines[i], x, y + (i * (letterHeight + kerning)));

		}

	}

}
