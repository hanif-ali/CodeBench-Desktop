package sample;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class FileSend {
    private  String route;
    private String token;
    private String filename;

    FileSend(String route){
        this.route=route;
    }
    FileSend(String route,String token,String filename){
        this.route=route;
        this.token=token;
        this.filename=filename;
    }

    public void sendFile() {
        URLConnection urlconnection = null;
        try {
            File file = new File(filename);
            URL url = new URL("http://127.0.0.1:5000/"+route);

            urlconnection = url.openConnection();
            urlconnection.setRequestProperty("Authorization", "Bearer " + token);
            urlconnection.setDoOutput(true);
            urlconnection.setDoInput(true);

            if (urlconnection instanceof HttpURLConnection) {
                ((HttpURLConnection) urlconnection).setRequestMethod("POST");
                ((HttpURLConnection) urlconnection).setRequestProperty("Content-type", "text/plain");
                ((HttpURLConnection)urlconnection).setRequestProperty("Accept","text/plain");
                ((HttpURLConnection) urlconnection).connect();
            }

            BufferedOutputStream bos = new BufferedOutputStream(urlconnection.getOutputStream());
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            int i;
            // read byte by byte until end of stream
            while ((i = bis.read()) > 0) {
                bos.write(i);
            }
            bis.close();
            bos.close();
            System.out.println(((HttpURLConnection) urlconnection).getResponseMessage());
        } catch (Exception e) {
            System.out.println("Okay");
            e.printStackTrace();
        }
        try {

            InputStream inputStream;
            int responseCode = ((HttpURLConnection) urlconnection).getResponseCode();
            if ((responseCode >= 200) && (responseCode <= 202)) {
                inputStream = ((HttpURLConnection) urlconnection).getInputStream();
                try(BufferedReader br = new BufferedReader(
                        new InputStreamReader(((HttpURLConnection) urlconnection).getInputStream(), "utf-8"))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    System.out.println(response.toString());

                } catch (IOException e) {
                    e.printStackTrace();
                }

                ((HttpURLConnection) urlconnection).disconnect();

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }




}
