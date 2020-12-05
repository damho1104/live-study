import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

class GithubLibTest {
    private GithubLib githubLib;
    private String token;
    private String repositoryName;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        token = "INSERT_YOUR_TOKEN";
        repositoryName = "damho1104/java-study-day4";
        githubLib = new GithubLib(token, repositoryName);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void isNotNull(){
        assert githubLib != null;
    }

    @org.junit.jupiter.api.Test
    void testGetRepository() throws IOException {
        var repository = githubLib.getRepository();
        assert repository != null;
    }

    @org.junit.jupiter.api.Test
    void testGetAllIssues() throws IOException {
        var repository = githubLib.getRepository();
        var issues = githubLib.getAllIssues(repository);
        // 테스트 레포지토리에는 issue 가 2개 있음
        assert issues.size() == 2;
    }

    @org.junit.jupiter.api.Test
    void testGetAllUserNamesInCommentsFromIssue() throws IOException {
        var repository = githubLib.getRepository();
        Set<String> userIDList = new HashSet<>();
        for(var issue : githubLib.getAllIssues(repository)){
            userIDList.addAll(githubLib.getAllUserIDsInCommentsFromIssue(issue));
        }
        // 2개의 issue 에는 동일한 user 의 comment 가 있음
        assert userIDList.size() == 1;

        // 동일한 user 의 ID 는 damho1104
        for(var userId : userIDList){
            assert userId.equals("damho1104");
        }
    }
}