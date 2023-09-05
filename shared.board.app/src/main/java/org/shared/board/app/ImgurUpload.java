package org.shared.board.app;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.xerces.impl.dv.util.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImgurUpload {
    public static String uploadImage(String filePath){
        String link = "";

        try {
            URL url = new URL("https://api.imgur.com/3/image");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            File file = new File(filePath);
            BufferedImage image = ImageIO.read(file);
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();

            Path path = Path.of(filePath);
            String fileName = path.getFileName().toString();
            int dotIndex = fileName.lastIndexOf('.');

            if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
                String imageFormat = fileName.substring(dotIndex + 1);

                if ("png".compareTo(imageFormat) == 0
                        || "jpg".compareTo(imageFormat) == 0){
                    ImageIO.write(image, imageFormat, byteArray);
                    byte[] byteImage = byteArray.toByteArray();
                    String dataImage = Base64.encode(byteImage);

                    String data = URLEncoder.encode("image", "UTF-8") + "="
                            + URLEncoder.encode(dataImage, "UTF-8");

                    // Set headers & connect
                    conn.setDoOutput(true);
                    conn.setDoInput(true);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Authorization", "Client-ID " + "eae95290510293a");
                    conn.setRequestProperty("Content-Type",
                            "application/x-www-form-urlencoded");
                    conn.connect();

                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                    wr.write(data);
                    wr.flush();

                    // Get the response
                    BufferedReader rd = new BufferedReader(
                            new InputStreamReader(conn.getInputStream()));

                    String line;

                    // Get link from response
                    while ((line = rd.readLine()) != null) {
                        if (line.contains("link")) {
                            Pattern pattern = Pattern.compile("\"link\":\"(.*?)\"");
                            Matcher matcher = pattern.matcher(line);
                            if (matcher.find()) {
                                link = StringEscapeUtils.unescapeJava(matcher.group(1));
                            }
                        }
                    }

                    wr.close();
                    rd.close();
                } else {
                    System.out.println("Image is in an invalid format!");
                }
            } else {
                System.out.println("Image path is invalid!");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }

        return link;
    }
}
