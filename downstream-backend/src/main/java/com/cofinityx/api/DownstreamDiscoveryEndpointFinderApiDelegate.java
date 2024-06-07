package com.cofinityx.api;

import org.eclipse.tractusx.discoveryfinder.api.FinderApiDelegate;
import org.eclipse.tractusx.discoveryfinder.service.DiscoveryFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("downstreamDelegate")
public class DownstreamDiscoveryEndpointFinderApiDelegate implements FinderApiDelegate {

    //if we need to implement a different Service version the same strategy can be applied here
    // DownstreamService implements DiscoveryFinderService
    private DiscoveryFinderService discoveryFinderService;

    public DownstreamDiscoveryEndpointFinderApiDelegate(@Autowired DiscoveryFinderService discoveryFinderService){
        this.discoveryFinderService = discoveryFinderService;
    }

    @Override
    public ResponseEntity<Void> deleteDiscoveryEndpointByResourceId(String resourceId) {
        discoveryFinderService.deleteEndpoint( resourceId );
        return new ResponseEntity<>( HttpStatus.NO_CONTENT );
    }
}
