package com.gledsonafonso.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public abstract class ImageUtils {
  public static byte[] getImageAsByteArray(String imageUrl, String subtitle) {
    try {
      InputStream inputStream = new URL(imageUrl).openStream();
      var originalImage = ImageIO.read(inputStream);
      int originalWidth = originalImage.getWidth();
      int originalHeight = originalImage.getHeight();
      int newHeight = originalHeight + 200;

      var newImage = new BufferedImage(originalWidth, newHeight, BufferedImage.TRANSLUCENT);
      var graphics = (Graphics2D) newImage.getGraphics();
      graphics.drawImage(originalImage, 0, 0, null);
      graphics.setColor(Color.YELLOW);
      graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 64));
      graphics.drawString(subtitle, 100, newHeight - 100);

      return bufferedImagetoByteArray(newImage, "png");
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    }
  }

  private static byte[] bufferedImagetoByteArray(BufferedImage bufferedImage, String format) throws IOException {
    var outputStream = new ByteArrayOutputStream();
    ImageIO.write(bufferedImage, format, outputStream);
    return outputStream.toByteArray();
  }
}
