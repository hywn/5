package net.hilaryoi.four.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtil {

	public Image fetchResizedImage(String fileName, int scale) throws IOException {
		// length = x
		// width = y

		Image orig = fetchImage(fileName);

		return orig.getScaledInstance(orig.getWidth(null) * scale, orig.getHeight(null) * scale, 0);

	}

	public BufferedImage fetchImage(String fileName) throws IOException {
		return ImageIO.read(this.getClass().getResourceAsStream(fileName));

	}

	public Image[] getLRSprites(BufferedImage spriteSheet, int size, int newSize) {

		int height = spriteSheet.getHeight() / size;

		int width = spriteSheet.getWidth() / size;

		Image[] sprites = new Image[width * height];

		for (int iY = 0; iY < height; iY++) {

			for (int iX = 0; iX < width; iX++) {

				sprites[(iY * width) + iX] = spriteSheet.getSubimage(iX * size, iY * size, size, size)
						.getScaledInstance(newSize, newSize, 0);

			}

		}

		return sprites;

	}

	public BufferedImage[] getUnresizedSprites(String fileName, int size) throws IOException {

		BufferedImage spriteSheet = fetchImage(fileName);

		int height = spriteSheet.getHeight() / size;

		int width = spriteSheet.getWidth() / size;

		BufferedImage[] sprites = new BufferedImage[width * height];

		for (int iY = 0; iY < height; iY++) {

			for (int iX = 0; iX < width; iX++) {

				sprites[(iY * width) + iX] = spriteSheet.getSubimage(iX * size, iY * size, size, size);

			}

		}

		return sprites;

	}

	public Image[] getSprites(BufferedImage spriteSheet, int size, int newSize) {

		int height = spriteSheet.getHeight() / size;

		int width = spriteSheet.getWidth() / size;

		Image[] sprites = new Image[width * height];

		for (int iX = 0; iX < width; iX++) {

			for (int iY = 0; iY < height; iY++) {

				sprites[(iX * height) + iY] = spriteSheet.getSubimage(iX * size, iY * size, size, size)
						.getScaledInstance(newSize, newSize, 0);

			}

		}

		return sprites;

	}

	@Deprecated
	public Image[] makeAnimationStrip(BufferedImage spriteSheet, int size, int newSize) {

		Image[] finishedStrip = new Image[spriteSheet.getHeight() / size];

		for (int i = 0; i < spriteSheet.getHeight() / size; i++) {

			finishedStrip[i] = spriteSheet.getSubimage(0, i * size, size, size).getScaledInstance(newSize, newSize, 0);

		}

		return finishedStrip;

	}

	public double rescale(double origWidth, double origHeight, double newWidth) {
		return (origHeight * newWidth) / origWidth;

	}

}
