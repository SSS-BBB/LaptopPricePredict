package Handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DataHandler {

    String[] dataList;

    float predictedPrice;

    public DataHandler(int size) {
        dataList = new String[size];
    }

    public void addData(int index, String data) {
        dataList[index] = data;
    }

    public void showData() {
        for (String data : dataList) {
            System.out.println(data);
        }
    }

    public void sendDataForPrediction() {
        try {
            URL url = new URL("http://localhost:3000/");
            try {
                // Connection
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Accept", "application/json");
                connection.setDoOutput(true);

                // Request
                String jsonDataInput = "{'name': 'Yo', 'age': '20'}";

                try (OutputStream os = connection.getOutputStream()) {
                    byte[] jsonByte = jsonDataInput.getBytes("utf-8");
                    os.write(jsonByte, 0, jsonByte.length);
                }

                // Response
                try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                        StringBuilder response = new StringBuilder();
                        String responseLine = null;
                        while ((responseLine = br.readLine()) != null) {
                            response.append(responseLine.trim());
                        }
                        System.out.println(response.toString());
                    }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public float getPredictedPrice() {
        return predictedPrice;
    }

    public void makeDummy() {
        // Create Dummy Datas for Testing
        dataList = new String[]{"HP", "Intel i7", "16", "2TB SSD", "Nvidia GTX 1650", "11.5", "1920x1080", "15", "2", "Windows"};
    }
    
}