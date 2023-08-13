
package com.crio.qeats.exchanges;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetRestaurantsRequest {

    @NotNull
    @Max(90)
    @Min(-90)
    Double latitude;
  
    @NotNull
    @Max(180)
    @Min(-180)
    Double longitude;
    
  
    
    String searchFor = "";
  
    public GetRestaurantsRequest(Double latitude, Double longitude) {
      this.latitude = latitude;
      this.longitude = longitude;
    }
  
    
}

