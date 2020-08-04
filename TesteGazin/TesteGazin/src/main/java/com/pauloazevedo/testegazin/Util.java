/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pauloazevedo.testegazin;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *
 * @author paulo
 */
public class Util {
    public static String consultaApiPost(String json, String urlApi) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String url = urlApi;

        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, json);
        //Request.Builder builder = new Request.Builder();
        //builder.url(url);
        //builder.post(body);
        Request request = new Request.Builder()
                .url(urlApi)
                .post(body)
                .build();
        //Response response = client.newCall(request).execute();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            String resposta = response.body().string();            
            return resposta;
        }
    }
    
    public static String consultaApiPostAutenticado(String json, String urlApi, String token) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String url = urlApi;

        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, json);
        Request request = new Request.Builder()
                .url(urlApi)
                .header("Authorization", "Bearer " + token)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            String resposta = response.body().string();            
            return resposta;
        }
    }
    
    public static String consultaApiPut(String json, String urlApi) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String url = urlApi;

        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, json);
        Request request = new Request.Builder()
                .url(urlApi)
                .put(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            String resposta = response.body().string();            
            return resposta;
        }
    }
    
    public static String consultaApiPutAutenticado(String json, String urlApi, String token) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String url = urlApi;

        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, json);
        Request request = new Request.Builder()
                .url(urlApi)
                .header("Authorization", "Bearer " + token)
                .put(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            String resposta = response.body().string();            
            return resposta;
        }
    }

    public static String consultaApiGet(String json, String urlApi) throws IOException {

//        ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
//                .tlsVersions(TlsVersion.TLS_1_2)
//                .cipherSuites(
//                        CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
//                        CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
//                        CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256)
//                .build();
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(urlApi)
                .build();

//        try (Response response = client.newCall(request).execute()) {
//            return response.body().string();
//        } catch (Exception ex) {
//            return "";
//        }
        Response response = client.newCall(request).execute();
        if (response.body() != null) {
            String jsonDeResposta = response.body().string();
            //System.out.println(jsonDeResposta);
            return jsonDeResposta;
        } else {
            return "";
        }
    }
    
        public static String consultaApiDelete(String json, String urlApi) throws IOException {

//        ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
//                .tlsVersions(TlsVersion.TLS_1_2)
//                .cipherSuites(
//                        CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
//                        CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
//                        CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256)
//                .build();
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(urlApi)
                .delete()
                .build();

//        try (Response response = client.newCall(request).execute()) {
//            return response.body().string();
//        } catch (Exception ex) {
//            return "";
//        }
        Response response = client.newCall(request).execute();
        if (response.body() != null) {
            String jsonDeResposta = response.body().string();
            //System.out.println(jsonDeResposta);
            return jsonDeResposta;
        } else {
            return "";
        }
    }
    
    public static String caminhoAPI() {
        return "http://localhost:8090";
    }
}
