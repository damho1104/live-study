import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

class GithubLibTest {
    private GithubLib githubLib;
    private String token;
    private String repositoryName;

    @BeforeEach
    void setUp() {
        token = "INSERT_YOUR_TOKEN";
        repositoryName = "damho1104/java-study-day4";
        githubLib = new GithubLib(token, repositoryName);
    }

    @Test
    void isNotNull(){
        assert githubLib != null;
    }

    @Test
    void testGetRepository() throws IOException {
        var repository = githubLib.getRepository();
        assertNotNull(repository);
    }

    @Test
    void testGetAllIssues() throws IOException {
        var repository = githubLib.getRepository();
        var issues = githubLib.getAllIssues(repository);
        // 테스트 레포지토리에는 issue 가 2개 있음
        assertEquals(issues.size(), 2);
    }

    @Test
    void testGetAllUserNamesInCommentsFromIssue() throws IOException {
        var repository = githubLib.getRepository();
        Set<String> userIDList = new HashSet<>();
        for(var issue : githubLib.getAllIssues(repository)){
            userIDList.addAll(githubLib.getAllUserIDsInCommentsFromIssue(issue));
        }
        // 2개의 issue 에는 동일한 user 의 comment 가 있음
        assertEquals(userIDList.size(), 1);

        // 동일한 user 의 ID 는 damho1104
        for(var userId : userIDList){
            assertEquals("damho1104", userId);
        }
    }
}