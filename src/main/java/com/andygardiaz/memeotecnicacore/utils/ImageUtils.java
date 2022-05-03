package com.andygardiaz.memeotecnicacore.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import org.springframework.stereotype.Component;

@Component

public class ImageUtils {
    public String saveImageBase64(String dir, String imageB64) {
		System.out.println(imageB64);
		String[] parts = imageB64.split(",");
		String base64 = parts.length > 1 ? parts[1] : parts[0];
		String fileName = System.currentTimeMillis() + ".png";
		BufferedImage image;
		
		byte[] imageByte = Base64.getDecoder().decode(base64);
		try {
			Path pathDir = Paths.get("public", "images", dir);
			if(!Files.exists(pathDir)) {
				Files.createDirectory(pathDir);
			}
			
			image = ImageIO.read(new ByteArrayInputStream(imageByte));
			Path path = Paths.get("public", "images", dir, fileName);
			ImageIO.write(image, "png", path.toFile());
			return "images" + "/" + dir + "/" + fileName;
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return "";
		}
	}
}
