package com.cofinityx;

import org.eclipse.tractusx.discoveryfinder.DiscoveryFinderApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DownstreamDiscoveryFinderApplication extends DiscoveryFinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DownstreamDiscoveryFinderApplication.class, args);
    }
}