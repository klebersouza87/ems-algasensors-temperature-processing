package com.ems.algasensors.temperature.processing;

import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import static com.ems.algasensors.temperature.processing.UUIDv7Utils.extractOffsetDateTime;
import static org.assertj.core.api.Assertions.assertThat;

class UUIDv7Test {

    @Test
    void testShouldGenerateUUIDv7() {
        UUID uuid1 = IdGenerator.generateTimeBasedUUID();
        UUID uuid2 = IdGenerator.generateTimeBasedUUID();
        UUID uuid3 = IdGenerator.generateTimeBasedUUID();
        UUID uuid4 = IdGenerator.generateTimeBasedUUID();

        System.out.println(uuid1);
        System.out.println(uuid2);
        System.out.println(uuid3);
        System.out.println(uuid4);

        System.out.println();
        System.out.println(extractOffsetDateTime(uuid1));
        System.out.println(extractOffsetDateTime(uuid2));
        System.out.println(extractOffsetDateTime(uuid3));
        System.out.println(extractOffsetDateTime(uuid4));

        UUID uuidV7 = IdGenerator.generateTimeBasedUUID();
        OffsetDateTime uuidDateTime = extractOffsetDateTime(uuidV7).truncatedTo(ChronoUnit.MINUTES);
        OffsetDateTime currentDateTime = OffsetDateTime.now().truncatedTo(ChronoUnit.MINUTES);

        System.out.println();
        System.out.println(uuidV7);
        System.out.println(uuidDateTime);
        System.out.println(currentDateTime);

        assertThat(uuidDateTime).isEqualTo(currentDateTime);
    }

}
