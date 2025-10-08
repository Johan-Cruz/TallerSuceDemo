package com.challenge.utilities;

import com.challenge.models.UserData;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvToUserData {
    public static List<UserData> readFromResource(String resourcePath) {
        List<UserData> users = new ArrayList<>();
        try (InputStream is = CsvToUserData.class.getResourceAsStream(resourcePath)) {
            if (is == null) return users;
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                String line; boolean header = true;
                while ((line = br.readLine()) != null) {
                    if (header) { header = false; continue; }
                    String[] parts = line.split(",");
                    if (parts.length >= 2) {
                        users.add(new UserData(parts[0].trim(), parts[1].trim()));
                    }
                }
            }
        } catch (Exception ignored) {}
        return users;
    }
}
