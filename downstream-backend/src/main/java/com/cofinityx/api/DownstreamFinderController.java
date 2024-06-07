package com.cofinityx.api;

import org.eclipse.tractusx.discoveryfinder.api.FinderApi;
import org.eclipse.tractusx.discoveryfinder.api.FinderApiDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
@RequestMapping("${openapi.discoveryFinder.base-path:/api/v1.1}")
public class DownstreamFinderController implements FinderApi {

    private final FinderApiDelegate delegate;

    public DownstreamFinderController(@Autowired(required = false) @Qualifier("downstreamDelegate") FinderApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new FinderApiDelegate() {});
    }

    @Override
    public FinderApiDelegate getDelegate() {
        return this.delegate;
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE,value = "/administration/connectors/discovery/{resourceId}")
    public ResponseEntity<Void> deleteDiscoveryEndpointByResourceId(@PathVariable("resourceId") String resourceId) {
        return getDelegate().deleteDiscoveryEndpointByResourceId(resourceId);
    }
}
