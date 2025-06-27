package com.example.MockitoProject2;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class VerifyInteractionTest {
    @Test
    public void testVerifyInteraction() {
    	ExternalApi mockApi = Mockito.mock(ExternalApi.class);
    	MyService service = new MyService(mockApi);
    	service.fetchData();
    	verify(mockApi).getData();
    }
}
