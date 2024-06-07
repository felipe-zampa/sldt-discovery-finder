package com.cofinityx.service;

import com.cofinityx.api.DownstreamFinderController;
import org.eclipse.tractusx.discoveryfinder.model.Endpoint;
import org.eclipse.tractusx.discoveryfinder.repository.EndpointRepository;
import org.eclipse.tractusx.discoveryfinder.service.DiscoveryFinderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DownstreamDiscoveryFinderServiceTest {

    @Mock
    EndpointRepository repository;

    @InjectMocks
    DownstreamDiscoveryFinderService service;

    @Test
    @DisplayName("Given Downstream class has no implementation when delete method is invoked then there aren't interactions with repository")
    void deleteEndpoint() {
        service.deleteEndpoint(UUID.randomUUID().toString());
        verify(repository, times(0)).deleteById(any(UUID.class));
        verify(repository, times(0)).findEndpointByResourceId(anyString());
    }
}