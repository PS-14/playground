package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   04/06/22 8:01 PM  
   */

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TeamRanks {
    public String rankTeams(String[] votes) {
        TeamRank[] teamRanks = new TeamRank[26];
        for (int i = 0; i < teamRanks.length; i++) {
            teamRanks[i] = new TeamRank((char) ('A' + i));
        }
        int maxTeams = 0;
        for (int i = 0; i < votes.length; i++) {
            maxTeams = Math.max(maxTeams, votes[i].length());
            for (int j = 0; j < votes[i].length(); j++) {
                teamRanks[votes[i].charAt(j) - 'A'].count[j]++;
            }
        }

        Arrays.sort(teamRanks, (t1, t2) -> {
            int t1Count = 0;
            int t2Count = 0;
            for (int i = 0; i < 26; i++) {
                t1Count += t1.count[i];
                t2Count += t2.count[i];
                if (t1.count[i] != t2.count[i]) {
                    return t2.count[i] - t1.count[i];
                }
            }
            if (t1Count > 0 && t2Count > 0) {
                return t1.ch - t2.ch;
            } else {
                return t1Count - t2Count;
            }

        });
        String output = "";
        for (int i = 0; i < maxTeams; i++) {
            output = output + teamRanks[i].ch;
        }
        return output;

    }

    private static class TeamRank {
        char ch;
        int[] count;

        public TeamRank(char ch) {
            this.ch = ch;
            count = new int[26];
        }
    }
}
