/********************************************************************************
 * Copyright (c) 2023 Robert Bosch Manufacturing Solutions GmbH
 * Copyright (c) 2023 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ********************************************************************************/
package org.eclipse.tractusx.discoveryfinder.service;

import java.util.List;

import org.eclipse.tractusx.discoveryfinder.dto.EndpointCollectionDto;
import org.eclipse.tractusx.discoveryfinder.model.Endpoint;
import org.eclipse.tractusx.discoveryfinder.repository.EndpointRepository;
import org.eclipse.tractusx.discoveryfinder.service.utils.UuidUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
public class DiscoveryFinderService {
   private final EndpointRepository endpointRepository;

   public DiscoveryFinderService( final EndpointRepository endpointRepository ) {
      this.endpointRepository = endpointRepository;
   }

   public void deleteEndpoint( String resourceId ) {
      UuidUtils.validateUUID( resourceId );
      Endpoint endpointDb = endpointRepository.findEndpointByResourceId( resourceId )
            .orElseThrow( () -> new EntityNotFoundException( String.format( "Discovery Endpoint for the resourceId %s not found.", resourceId ) ) );
      endpointRepository.deleteById( endpointDb.getId() );
   }

   @Transactional( readOnly = true )
   public EndpointCollectionDto findDiscoveryEndpoints( List<String> types ) {
      List<Endpoint> endpoints = (types == null || types.isEmpty() ? endpointRepository.findAll() : endpointRepository.findEndpointByTypeIn( types ));
      return EndpointCollectionDto.builder().endpoints( endpoints ).build();
   }

   public Endpoint findDiscoveryEndpointByTypeAndAddress( String type, String address ) {
      return endpointRepository.findEndpointByTypeAndEndpointAddress( type, address );
   }

   @Transactional
   public Endpoint save( Endpoint endpoint ) {
      return endpointRepository.save( endpoint );
   }
}
