package shared;

import utils.TestCasesInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.Collection;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hooks {

    private Optional<String> testCaseIDOptional;
    private int status = 0;
    private String testCase;
    private final Pattern pattern = Pattern.compile("C[1-9]+");
    private Matcher matcher;

    @Before
    public void beforeScenario(Scenario sc) {
        Collection<String> tags = sc.getSourceTagNames();
        this.testCaseIDOptional = tags.stream().findFirst();
    }

    @After
    public void afterScenario(Scenario sc) {
        if (this.testCaseIDOptional.isPresent()) {
            matcher = pattern.matcher(this.testCaseIDOptional.toString());
            if (matcher.find()) {
                this.status = sc.isFailed() ? 5 : 1;
                this.testCase = this.testCaseIDOptional.toString().replaceAll("\\[", "")
                    .replaceAll("\\]", "");
                this.testCase = this.testCase.split("C")[1];
                TestCasesInstance.getInstance().setData(this.testCase, this.status);
                TestCasesInstance.getInstance().getData().get(this.testCase);
            }
        }
    }
}
