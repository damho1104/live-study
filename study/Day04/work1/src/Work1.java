import org.kohsuke.github.GHIssue;

import java.io.IOException;
import java.util.*;

public class Work1 {
    public static void main(String[] args) throws IOException {
        Work1 instance = new Work1();
        instance.start();
    }

    public void start() throws IOException {
        String token = "INSERT_YOUR_TOKEN";
        String repositoryName = "whiteship/live-study";

        GithubLib githubLib = new GithubLib(token, repositoryName);
        var repository = githubLib.getRepository();
        var issues = githubLib.getAllIssues(repository);
        int cntIssues = issues.size();

        SortedMap<String, Integer> participantMap = getParticipantMap(githubLib, issues);
        printParticipationRate(participantMap, cntIssues);
    }

    public SortedMap<String, Integer> getParticipantMap(GithubLib githubLib, List<GHIssue> issues) throws IOException {
        SortedMap<String, Integer> participantMap = new TreeMap<>();
        for (var issue : issues){
            Set<String> userIDSetFromIssue = githubLib.getAllUserIDsInCommentsFromIssue(issue);
            for (var userID : userIDSetFromIssue){
                insertParticipantIntoMap(userID, participantMap);
            }
        }
        return participantMap;
    }

    public void insertParticipantIntoMap(String userID, Map<String, Integer> participantMap){
        if(participantMap.containsKey(userID)){
            Integer count = participantMap.get(userID);
            participantMap.put(userID, ++count);
        }
        else{
            participantMap.put(userID, 1);
        }
    }

    public void printParticipationRate(SortedMap<String, Integer> participantMap, int cntIssues){
        System.out.println("Participation Rate-------");
        participantMap.forEach((userID, count)->{
            double participationRate = (double)(count*100) / cntIssues;
            System.out.println(getStringRatePerUserID(userID, participationRate));
        });
    }

    public String getStringRatePerUserID(String userID, double participationRate){
        return userID +
                ": " +
                String.format("%.2f", participationRate) +
                "%";
    }
}
