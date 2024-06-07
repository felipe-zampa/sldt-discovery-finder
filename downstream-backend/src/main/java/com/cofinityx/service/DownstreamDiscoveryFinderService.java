package com.cofinityx.service;

import org.eclipse.tractusx.discoveryfinder.repository.EndpointRepository;
import org.eclipse.tractusx.discoveryfinder.service.DiscoveryFinderService;
import org.springframework.stereotype.Service;

@Service("downstreamService")
public class DownstreamDiscoveryFinderService extends DiscoveryFinderService {

    public DownstreamDiscoveryFinderService(EndpointRepository endpointRepository) {
        super(endpointRepository);
    }

    @Override
    public void deleteEndpoint(String resourceId) {
        //own downstream implementation for the delete method
    }
}
