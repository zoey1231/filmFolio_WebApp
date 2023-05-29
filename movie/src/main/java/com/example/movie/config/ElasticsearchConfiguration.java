//package com.example.movie.config;
//
//import co.elastic.clients.elasticsearch.ElasticsearchClient;
//import co.elastic.clients.json.jackson.JacksonJsonpMapper;
//import co.elastic.clients.transport.ElasticsearchTransport;
//import co.elastic.clients.transport.rest_client.RestClientTransport;
//import com.google.api.gax.core.CredentialsProvider;
//import org.apache.http.HttpHost;
//
//import org.apache.http.auth.AuthScope;
//import org.apache.http.auth.UsernamePasswordCredentials;
//import org.apache.http.impl.client.BasicCredentialsProvider;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestClientBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ElasticsearchConfiguration {
//    //Enterprise Search: filmfoliodeployment.ent.us-central1.gcp.cloud.es.io
//    private static final String ELASTICSEARCH_HOST = "filmfoliodeployment.es.us-central1.gcp.cloud.es.io";
//    private static final int ELASTICSEARCH_PORT = 9243;
//    private static final String ELASTICSEARCH_SCHEME = "https";
//    private static final String ELASTICSEARCH_USERNAME = "elastic";
//    private static final String ELASTICSEARCH_PASSWORD = "yYIRNpeQ1ilzHvdWn80z2muW";
//    @Bean
//    public ElasticsearchClient elasticsearchClient() {
//
//        final CredentialsProvider credentialsProvider =
//                (CredentialsProvider) new BasicCredentialsProvider();
//        ((BasicCredentialsProvider) credentialsProvider).setCredentials(AuthScope.ANY,
//                new UsernamePasswordCredentials(ELASTICSEARCH_USERNAME, ELASTICSEARCH_PASSWORD));
//
//        RestClient restClient = RestClient.builder(
//                            new HttpHost(ELASTICSEARCH_HOST, ELASTICSEARCH_PORT, ELASTICSEARCH_SCHEME))
//                    .setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder.setDefaultCredentialsProvider((org.apache.http.client.CredentialsProvider) credentialsProvider)).build();
//
//            // Create the transport with a Jackson mapper
//            ElasticsearchTransport transport = new RestClientTransport(
//                    restClient, new JacksonJsonpMapper());
//
//            // And create the API client
//            ElasticsearchClient client = new ElasticsearchClient(transport);
//            return client;
//
//    }
//}
