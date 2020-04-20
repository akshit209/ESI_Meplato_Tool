package com.example.ESI_Tool.urlSession;

import com.example.ESI_Tool.FileStore.FileStore;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class UrlSessionService {
    private static List<URL> urlSession = new ArrayList<URL>();
    private final FileStore fileStore;

    public UrlSessionService(FileStore fileStore) {
        this.fileStore = fileStore;
    }

    static {
        try {
            URL url1 = new URL("http://test.com/testapp/test.do?test_id=1&test_name=SS");
            urlSession.add(url1);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            URL url2 = new URL("https://www.google.com/");
            urlSession.add(url2);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            URL url3 = new URL("https://www.facebook.com/");
            urlSession.add(url3);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            URL url4 = new URL("https://mail.google.com/mail/u/0/#inbox");
            urlSession.add(url4);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public List<URL> findAll() {
        return urlSession;
    }

    void uploadUrlInDatabase(UrlSession url)
    {
        fileStore.save(url);
    }
}
