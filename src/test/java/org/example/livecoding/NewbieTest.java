package org.example.livecoding;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NewbieTest {
    private static final TaskMap TASK_MAP = new TaskMap();

    @Test
    void makeThisDoneTest() {
        Map<Object, Object> map = getMap();
        TASK_MAP.preProcess(map);

        Assertions.assertEquals(2, ((List<Map>) map.get("ADVERTISING_DATA")).size());
        Assertions.assertNotNull(map.get("START_AFTER_2008"));
        Assertions.assertEquals(9, map.size());
    }

    @Test
    void makeThisDone2Test() {
        Map<Object, Object> map = getMap();
        map.put("PROD.TYPE", "SOME_TYPE_4");
        TASK_MAP.preProcess(map);

        Assertions.assertEquals("Y", (map.get("EXTRA")));
    }

    @ParameterizedTest
    @CsvSource({
            "Y, DC01",
            "N, DC02",

    })
    void exceptionsTest(String value, String errName) {
        // make custom exception like (NotSatisfiedException) that should take ErrorCode only and place its name to message
        Map<Object, Object> map = getMap();
        map.put(271, value);
        try {
            TASK_MAP.preProcess(map);
            Assertions.fail("Should have thrown an exception");
        } catch (Throwable ex) {
            Assertions.assertEquals(errName, ex.getMessage());
        }
    }

    private Map<Object, Object> getMap() {
        Map p1 = Map.of("PURPOSE", "1", "DATA", "viber");
        Map p2 = Map.of("PURPOSE", "2", "DATA", "telegram");
        Map p3 = Map.of("PURPOSE", "8", "DATA", "email");

        Map<Object, Object> message = new HashMap<>();
        message.put("PROD.TYPE", "SOME_TYPE_1");
        message.put(new Date(), "Happy birthday");
        message.put("ADVERTISING_DATA", new ArrayList<>(Arrays.asList(p1, p2, p3))); // pure Arrays.asList - is unmodified
        message.put("CLIENT_ID", 1234567);
        message.put("DATE_START", new Date(1231200000000L));// 2009
        message.put(234, "Y");
        message.put(99, "Y");
        message.put(271, null);
        message.put(107, "N");
        message.put(11, null);
        message.put(12, "Y");
        return message;
    }
}
