import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Work1Test {

    private String token;
    private String repositoryName;
    private GithubLib githubLib;
    private GHRepository repository;
    private List<GHIssue> issues;

    private String userID;
    private Work1 test;

    @BeforeEach
    void setUp() throws IOException {
        token = "INSERT_YOUR_TOKEN";
        repositoryName = "damho1104/java-study-day4";
        githubLib = new GithubLib(token, repositoryName);
        repository = githubLib.getRepository();
        issues = githubLib.getAllIssues(repository);

        userID = "damho1104";
        test = new Work1();
    }

    @Test
    void testGetParticipantMap() throws IOException {
        var map = test.getParticipantMap(githubLib, issues);
        assert map.size() == 1;
        assert map.containsKey("damho1104");
    }

    @Test
    void testInsertParticipantIntoMap() {
        Map<String, Integer> testMap = new HashMap<>();
        test.insertParticipantIntoMap(userID, testMap);

        assert testMap.containsKey(userID);
        assert (Integer)testMap.get(userID) == 1;
    }

    @Test
    void testGetStringRatePerUserID() {
        assert "damho1104: 11.11%".equals(test.getStringRatePerUserID(userID, 11.11));
    }
}