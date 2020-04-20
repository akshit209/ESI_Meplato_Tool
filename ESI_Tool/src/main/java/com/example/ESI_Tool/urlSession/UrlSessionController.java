package com.example.ESI_Tool.urlSession;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin("*")
public class UrlSessionController {

        @Autowired
        private UrlSessionService urlSessionService;
        private String urlModel;

        @GetMapping("/instructors/{username}/urlSession")
        public List<URL> getAllMyCourses(@PathVariable String username) {
            return urlSessionService.findAll();
        }

        @PostMapping("/instructors/{username}/urlSession")
        public String createCourse(@PathVariable String username, @RequestBody String urlSession,
                                 HttpServletRequest request, HttpServletResponse response) throws IOException {

                if(urlSession.length() != 0){
                    int firstOccurence = urlSession.indexOf("username");
                    String directedURL = urlSession.substring(0,firstOccurence);
                    String credential = urlSession.substring(firstOccurence);

                    urlModel = urlSession;
                    String DecodeUrl = "";
                    try {
                         DecodeUrl = URLDecoder.decode(directedURL, "UTF-8");
                        urlModel = DecodeUrl+credential;
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }

                    URL url_test = null;
                    try {
                        url_test = new URL(urlModel);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    UrlSession urlSession1 = new UrlSession();
                    urlSession1.setId(UUID.randomUUID().toString());
                    urlSession1.setUrl(new URL(urlModel));
                    urlSessionService.uploadUrlInDatabase(urlSession1);

                    String masterdecodeurl = "http://akshit.com:8080/instructors/ESI_Tool/urlSession4";
                    String master = urlModel + "&HOOK_URL=" + masterdecodeurl;
                    String checkResponse = "https://www.google.com/";
                    return master;

                }
                String res="";
                return res;
        }

        @PostMapping("/instructors/{username}/urlSession4")
        public String createCourse2(HttpServletRequest request, HttpServletResponse response)
        {
            Gson object = new Gson();
            Map<String , String[]> hashmap = request.getParameterMap();
            String value = object.toJson(hashmap);
            System.out.println(value);
            return value;
        }
}
