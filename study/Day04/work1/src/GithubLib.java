import org.kohsuke.github.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GithubLib{
    private static String _token;
    private String _repositoryName;

    GithubLib(String token, String repositoryName){
        _token = token;
        _repositoryName = repositoryName;
    }

    public GHRepository getRepository() throws IOException {
        GitHub github = new GitHubBuilder().withOAuthToken(_token).build();
        return github.getRepository(_repositoryName);
    }

    public List<GHIssue> getAllIssues(GHRepository repository) throws IOException {
        return repository.getIssues(GHIssueState.ALL);
    }

    public Set<String> getAllUserIDsInCommentsFromIssue(GHIssue issue) throws IOException {
        Set<String> userNameList = new HashSet<>();
        for(var comment : issue.getComments()){
            userNameList.add(comment.getUser().getLogin());
        }
        return userNameList;
    }
}