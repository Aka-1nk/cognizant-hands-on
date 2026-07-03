package com.example;



import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    private ExternalApi mockApi;
    private MyService service;

    @Before
    public void setUp() {
        mockApi = mock(ExternalApi.class);
        service = new MyService(mockApi);
    }

    @Test
    public void testFetchData() {
        when(mockApi.getData()).thenReturn("Mock Data");
        String result = service.fetchData();
        assertEquals("Mock Data", result);
        verify(mockApi, times(1)).getData();
    }

    @Test
    public void testGetApiStatus() {
        when(mockApi.getStatusCode()).thenReturn(200);
        int status = service.getApiStatus();
        assertEquals(200, status);
        verify(mockApi, times(1)).getStatusCode();
    }

    @Test
    public void testGetUserInfo_ValidUserId() {
        String userId = "user123";
        when(mockApi.fetchUserData(userId)).thenReturn("John Doe");
        String result = service.getUserInfo(userId);
        assertEquals("John Doe", result);
        verify(mockApi, times(1)).fetchUserData(userId);
    }

    @Test
    public void testGetUserInfo_InvalidUserId() {
        String result = service.getUserInfo("");
        assertEquals("Invalid user ID", result);
        verify(mockApi, never()).fetchUserData(anyString());
    }

    @Test
    public void testCheckApiAvailability() {
        when(mockApi.isAvailable()).thenReturn(true);
        boolean result = service.checkApiAvailability();
        assertTrue(result);
        verify(mockApi, times(1)).isAvailable();
    }

    @Test
    public void testProcessData() {
        when(mockApi.getData()).thenReturn("API Data");
        String result = service.processData("User Input");
        assertEquals("API Data - User Input", result);
        verify(mockApi, times(1)).getData();
    }
}