class Solution {
    public String convert(String s, int numRows) {
        StringBuilder zigzagString = new StringBuilder();

        int zag = numRows / 2;
        int nextCharacter = numRows + zag;
        int nextRow = 0;
        while (zigzagString.length() < s.length()) {
            for (int i = nextRow; i < s.length(); i += nextCharacter) {
                zigzagString.append(s.charAt(i));
            }
            nextCharacter -= zag;
            if (nextCharacter < zag) {
                nextCharacter = numRows + zag;
            }
            nextRow++;
        }

        return zigzagString.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Correct Answer: PAHNAPLSIIGYIR");
        System.out.println("Calculated Answer: " + solution.convert("PAYPALISHIRING", 3));
    }
}
