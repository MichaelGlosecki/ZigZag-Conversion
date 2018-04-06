import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        List<Queue<Character>> arrayListOfQueues = new ArrayList<>();
        StringBuilder zigzagString = new StringBuilder();

        Queue<Character> row;
        int currentRow = -1;
        boolean zag = false;
        for (int index = 0; index < s.length(); index++) {
            if (zag) {
                currentRow--;
                zag = currentRow != 0;
            } else {
                currentRow++;
                zag = currentRow == numRows - 1;
            }
            if(arrayListOfQueues.size() != numRows){
                row = new ArrayDeque<>();
                row.add(s.charAt(index));
                arrayListOfQueues.add(row);
            } else {
                row = arrayListOfQueues.get(currentRow);
                row.add(s.charAt(index));
            }
        }

        for (Queue<Character> currentRowFromArray : arrayListOfQueues) {
            while (!currentRowFromArray.isEmpty()) {
                zigzagString.append(currentRowFromArray.remove());
            }
        }

        return zigzagString.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Correct Answer: PAHNAPLSIIGYIR");
        System.out.println("Calculated Answer: " + solution.convert("PAYPALISHIRING", 4));
    }
}
