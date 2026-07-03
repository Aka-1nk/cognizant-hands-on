package com.example;

import org.mockito.InOrder;
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

    // ===== EXERCISE 2: Verifying Interactions =====

    @Test
    public void testVerifyInteraction() {
        // ACT: Call the method
        service.fetchData();

        // VERIFY: getData() was called exactly once
        verify(mockApi).getData();
    }

    @Test
    public void testVerifyInteractionWithTimes() {
        // ACT: Call the method 3 times
        service.fetchData();
        service.fetchData();
        service.fetchData();

        // VERIFY: getData() was called exactly 3 times
        verify(mockApi, times(3)).getData();
    }

    @Test
    public void testVerifyInteractionWithSpecificArgument() {
        // ACT: Call with specific argument
        service.getUserInfo("user123");

        // VERIFY: Called with "user123"
        verify(mockApi).fetchUserData("user123");
    }

    @Test
    public void testVerifyInteractionWithAnyArgument() {
        // ACT: Call with any argument
        service.getUserInfo("anyUserId");

        // VERIFY: Called with ANY String
        verify(mockApi).fetchUserData(anyString());
    }

    @Test
    public void testVerifyNoInteraction() {
        // ACT: Don't call any methods

        // VERIFY: No interactions happened
        verifyNoInteractions(mockApi);
    }

    @Test
    public void testVerifyNeverCalled() {
        // ACT: Call a different method
        service.fetchData();

        // VERIFY: fetchUserData was NEVER called
        verify(mockApi, never()).fetchUserData(anyString());
    }

    @Test
    public void testVerifyAtLeastOnce() {
        // ACT: Call the method multiple times
        service.fetchData();
        service.fetchData();

        // VERIFY: getData() was called at least once
        verify(mockApi, atLeastOnce()).getData();
    }

    @Test
    public void testVerifyAtLeast() {
        // ACT: Call the method 3 times
        service.getUserInfo("user1");
        service.getUserInfo("user2");
        service.getUserInfo("user3");

        // VERIFY: fetchUserData() was called at least 2 times
        verify(mockApi, atLeast(2)).fetchUserData(anyString());
    }

    @Test
    public void testVerifyAtMost() {
        // ACT: Call the method twice
        service.fetchData();
        service.fetchData();

        // VERIFY: getData() was called at most 3 times
        verify(mockApi, atMost(3)).getData();
    }

    @Test
    public void testVerifyOrderOfInteractions() {
        // ACT: Call methods in a specific order
        service.fetchData();        // 1st
        service.getApiStatus();     // 2nd
        service.checkApiAvailability(); // 3rd

        // VERIFY: Order of method calls
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).getData();        // 1st call
        inOrder.verify(mockApi).getStatusCode();  // 2nd call
        inOrder.verify(mockApi).isAvailable();    // 3rd call
    }
}