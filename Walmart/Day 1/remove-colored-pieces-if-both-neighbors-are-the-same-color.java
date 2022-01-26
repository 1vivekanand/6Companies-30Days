Problem Link : https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/

class Solution {
    public boolean winnerOfGame(String colors) {
        int movesA = 0;
        int movesB = 0;

        int streakA = 0;
        int streakB = 0;

        for (char color : colors.toCharArray()) {
            if (color == 'A') {
                streakA++;
                if (streakA >= 3) {
                    movesA++;
                }
                streakB = 0;
            } else {
                streakB++;
                if (streakB >= 3) {
                    movesB++;
                }
                streakA = 0;
            }
        }

        return movesA - movesB > 0;
    }
}