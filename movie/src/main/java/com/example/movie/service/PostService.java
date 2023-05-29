//package com.example.movie.service;
//
//import com.example.movie.model.Post;
//import com.google.api.core.ApiFuture;
//import com.google.cloud.firestore.Firestore;
//import com.google.cloud.firestore.QueryDocumentSnapshot;
//import com.google.cloud.firestore.QuerySnapshot;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.cloud.FirestoreClient;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//@Service
//public class PostService {
//    private final Firestore db;
//
//    public PostService(FirebaseApp firebaseApp) {
//        db = FirestoreClient.getFirestore(firebaseApp);
//    }
//
//    // A method to get all posts from the database
//    public List<Post> getAllPosts() throws Exception {
//        List<Post> posts = new ArrayList<>();
//        ApiFuture<QuerySnapshot> future = db.collection("posts").get();
//        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
//        for (QueryDocumentSnapshot document : documents) {
//            System.out.println(document.getId() + " => " + document.toObject(Post.class));
//            Post post = document.toObject(Post.class);
//            posts.add(post);
//        }
//        return posts;
//    }
//}
