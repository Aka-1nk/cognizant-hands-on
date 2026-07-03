package com.example;

public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public int getApiStatus() {
        return externalApi.getStatusCode();
    }

    public String getUserInfo(String userId) {
        if (userId == null || userId.isEmpty()) {
            return "Invalid user ID";
        }
        return externalApi.fetchUserData(userId);
    }

    public boolean checkApiAvailability() {
        return externalApi.isAvailable();
    }

    public String processData(String input) {
        String data = externalApi.getData();
        return data + " - " + input;
    }
}