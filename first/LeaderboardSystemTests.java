import java.util.List;

public class LeaderboardSystemTests {

    public void TestGetTopScores() {
        int[] scores = {1, 2, 3, 4, 5, 6, 7};
        int m = 3;
        List<Integer> scoreList = LeaderboardSystem.GetTopScores(scores, m);
        System.out.println(scoreList);
    }

    public static void main(String[] args) {
        LeaderboardSystemTests leaderboardSystemTests = new LeaderboardSystemTests();
        leaderboardSystemTests.TestGetTopScores();
    }

}