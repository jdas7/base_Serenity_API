package utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestCasesInstance {

    private static TestCasesInstance INSTANCE;
    private Map<String, Integer> dataTestRail =
        Collections.synchronizedMap(new HashMap<>());

    private TestCasesInstance() {
    }

    public static TestCasesInstance getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TestCasesInstance();
        }
        return INSTANCE;
    }

    public Map getData() {
        return dataTestRail;
    }

    public void setData(String testCase, int testCaseStatus) {
        this.dataTestRail.put(testCase, testCaseStatus);
    }

}
