package org.eclipse.tractusx.discoveryfinder.service;

import org.eclipse.tractusx.discoveryfinder.model.Endpoint;
import org.eclipse.tractusx.discoveryfinder.repository.EndpointRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DiscoveryFinderServiceTest {

    @Mock
    EndpointRepository repository;

    Endpoint endpoint = new Endpoint(UUID.randomUUID(), "type", "description", "address", "documentation", UUID.randomUUID(), 10);

    @InjectMocks
    DiscoveryFinderService service;

    @Test
    @DisplayName("Given UUID is valid when delete endpoint is invoked then no exception is thrown")
    void deleteEndpoint() {
        when(repository.findEndpointByResourceId(anyString())).thenReturn(Optional.of(endpoint));
        service.deleteEndpoint(UUID.randomUUID().toString());
        verify(repository, times(1)).deleteById(any(UUID.class));
    }
}