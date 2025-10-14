package com.ems.algasensors.temperature.processing.api.controller;

import com.ems.algasensors.temperature.processing.api.model.TemperatureLogOutput;
import com.ems.algasensors.temperature.processing.common.IdGenerator;
import io.hypersistence.tsid.TSID;
import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/api/sensors/{sensorId}/temperatures/data")
@Slf4j
@Validated
public class TemperatureProcessingController {

    @PostMapping(consumes = MediaType.TEXT_PLAIN_VALUE)
    public void data(@PathVariable TSID sensorId,
                     @RequestBody @Pattern(regexp = "\\d+\\.\\d+", message = "Only numbers in this format is allowed: 12.34") String temperature) {
        TemperatureLogOutput logOutput = TemperatureLogOutput.builder()
                .id(IdGenerator.generateTimeBasedUUID())
                .sensorId(sensorId)
                .value(Double.valueOf(temperature))
                .registeredAt(OffsetDateTime.now())
                .build();

        log.info(logOutput.toString());
    }

}
