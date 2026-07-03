package com.example;

public interface ExternalApi {
    String getData();
    int getStatusCode();
    String fetchUserData(String userId);
    boolean isAvailable();
}