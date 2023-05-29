//package com.example.movie.config;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
//@Configuration
//public class FirebaseConfig {
//
////    @Value("${C:\\Users\\Zhuoy\\OneDrive\\Documents\\CornellTech\\startupSystem\\M3\\movie\\src\\main\\resources\\firebase_config.json}")
////    private String firebaseConfigPath;
//
//    @Bean//src/main/java/com/example/movie/config/firebase_config.json
//    public FirebaseApp firebaseApp() throws IOException {
//        FileInputStream serviceAccount = new FileInputStream("movie/src/main/resources/firebase_config.json");
//
//
//        FirebaseOptions options = FirebaseOptions.builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .setProjectId("filmfolio-f39fe")
//                .build();
//
//        return FirebaseApp.initializeApp(options);
//    }
//}
