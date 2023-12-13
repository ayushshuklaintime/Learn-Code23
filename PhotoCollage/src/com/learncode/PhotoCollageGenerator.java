package com.learncode;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PhotoCollageGenerator {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter the number of photos required in the collage: ");
			int numberOfImages = scanner.nextInt();

			System.out.print("Enter the type of images (e.g., nature): ");
			String imageType = scanner.next();
			
			String apiKey = "UCmypRke7nyzUhXquX23wdkv5TuePe2bhg5m6oWPTozjkYFtAwtidvfM";

			try {
			    List<String> imageIds = fetchImageIdsFromPexels(apiKey, imageType, numberOfImages);
			    if (imageIds != null && !imageIds.isEmpty()) {
			    	displayImagesInHtml(apiKey, imageIds);
			    } else {
			        System.out.println("No image IDs found.");
			    }
			} catch (IOException e) {
			    e.printStackTrace();
			}
			scanner.close();
		}
    }

    private static List<String> fetchImageIdsFromPexels(String apiKey, String query, int numberOfImages) throws IOException {
        String apiUrl = "https://api.pexels.com/v1/search?query=" + query + "&per_page=" + numberOfImages;
    	URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "YOUR_USER_AGENT");
        connection.setRequestProperty("Authorization", apiKey);

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                
                reader.close();
                String jsonResponse = response.toString();
                return parseImageIdsFromJson(jsonResponse);
            }
        } else {
            System.out.println("Failed to fetch images. Response Code: " + responseCode);
            return null;
        }
    }

    private static List<String> parseImageIdsFromJson(String jsonResponse) {
        List<String> imageIds = new ArrayList<>();

        JsonArray photosArray = JsonParser.parseString(jsonResponse).getAsJsonObject().getAsJsonArray("photos");
        for (int i = 0; i < photosArray.size(); i++) {
            JsonObject photoObject = photosArray.get(i).getAsJsonObject();
            String imageId = photoObject.get("id").getAsString();
            imageIds.add(imageId);
        }
        return imageIds;
    }

    private static void displayImagesInHtml(String apiKey, List<String> imageIds) {
        StringBuilder htmlContent = new StringBuilder("<html><body>");

        for (String imageId : imageIds) {
            try {
                String apiUrl = "https://api.pexels.com/v1/photos/" + imageId;
                URL url = new URL(apiUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("User-Agent", "YOUR_USER_AGENT");
                connection.setRequestProperty("Authorization", apiKey);

                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    reader.close();
                    connection.disconnect();

                    String jsonResponse = response.toString();
                    String imageUrl = parseImageUrlFromJson(jsonResponse);
                    htmlContent.append("<img src='").append(imageUrl).append("' width='300' height='200'/>");
                } else {
                    System.out.println("Failed to fetch image with ID " + imageId + ". Response Code: " + responseCode);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        htmlContent.append("</body></html>");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("photo_collage.html"))) {
            writer.write(htmlContent.toString());
            System.out.println("HTML file created: photo_collage.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String parseImageUrlFromJson(String jsonResponse) {
        JsonObject photoObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonObject srcObject = photoObject.getAsJsonObject("src");
        return srcObject.get("original").getAsString() + "?auto=compress&cs=tinysrgb&w=300&h=200";
    }
}
