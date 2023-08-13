
/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.qeats.services;

import com.crio.qeats.dto.Restaurant;
import com.crio.qeats.exchanges.GetRestaurantsRequest;
import com.crio.qeats.exchanges.GetRestaurantsResponse;
import com.crio.qeats.repositoryservices.RestaurantRepositoryService;
import com.crio.qeats.utils.FixtureHelpers;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class RestaurantServiceImpl implements RestaurantService {

  private final Double peakHoursServingRadiusInKms = 3.0;
  private final Double normalHoursServingRadiusInKms = 5.0;
  @Autowired
  private RestaurantRepositoryService restaurantRepositoryService;

  // TODO: CRIO_TASK_MODULE_RESTAURANTSAPI - Implement findAllRestaurantsCloseby.
  // Check RestaurantService.java file for the interface contract.
  @Override
  public GetRestaurantsResponse findAllRestaurantsCloseBy(
      GetRestaurantsRequest getRestaurantsRequest, LocalTime currentTime) {

        LocalTime lt1 = LocalTime.parse("07:59:59.99");
        LocalTime lt2 = LocalTime.parse("10:00:00.01");
        LocalTime lt3 = LocalTime.parse("12:59:59.99");
        LocalTime lt4 = LocalTime.parse("14:00:00.01");
        LocalTime lt5 = LocalTime.parse("18:59:59.99");
        LocalTime lt6 = LocalTime.parse("21:00:00.01");

        List<Restaurant> l;
        if((currentTime.isAfter(lt1) && currentTime.isBefore(lt2)) || (currentTime.isAfter(lt3) && currentTime.isBefore(lt4)) || (currentTime.isAfter(lt5) && currentTime.isBefore(lt6)))
        {
         l= restaurantRepositoryService.findAllRestaurantsCloseBy(getRestaurantsRequest.getLatitude(), getRestaurantsRequest.getLongitude(), currentTime,  peakHoursServingRadiusInKms);
        }
        else{
         l= restaurantRepositoryService.findAllRestaurantsCloseBy(getRestaurantsRequest.getLatitude(), getRestaurantsRequest.getLongitude(), currentTime,  normalHoursServingRadiusInKms);
        }
      
        GetRestaurantsResponse getRestaurantsResponse= new GetRestaurantsResponse(l);
        
     return getRestaurantsResponse;
  }


}

