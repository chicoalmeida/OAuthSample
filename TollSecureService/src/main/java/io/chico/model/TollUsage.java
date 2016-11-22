package io.chico.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Francisco Almeida
 */
@Data
@AllArgsConstructor
@Builder
public class TollUsage {
    private String id;
    private String stationId;
    private String licensePlate;
    private String timestamp;

}
