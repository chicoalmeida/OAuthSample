package io.chico.controller;

import io.chico.model.TollUsage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static java.util.Arrays.asList;

/**
 * @author Francisco Almeida
 */
@RestController
public class TollController {

    @RequestMapping("tolldata")
    public Collection<TollUsage> getTollData() {
        return asList(
                TollUsage.builder().id("100").stationId("station150").licensePlate("GGG1111").timestamp("2016-11-22T06:31:22").build(),
                TollUsage.builder().id("101").stationId("station119").licensePlate("ABC1234").timestamp("2016-11-22T07:31:22").build(),
                TollUsage.builder().id("102").stationId("station114").licensePlate("NSI0001").timestamp("2016-11-22T08:31:22").build(),
                TollUsage.builder().id("103").stationId("station099").licensePlate("GGG1111").timestamp("2016-11-22T09:31:22").build()
        );
    }

}
