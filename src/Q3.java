import java.util.HashSet;
import java.util.Set;

class Question3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;

        // Duyệt qua từng ký tự trong chuỗi
        for (int right = 0; right < n; right++) {
            // Nếu ký tự hiện tại chưa có trong tập hợp
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                // Khi gặp ký tự trùng lặp, loại bỏ các ký tự cho đến khi ký tự trùng bị loại bỏ
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }

        return maxLength;
    }
}

public class Q3 {
    public static void main(String[] args) {
        Question3 solution = new Question3();

        // Test 1: Chuỗi "abcabcbb" -> Kết quả là 3 (substring: "abc")
        String test1 = "abcabcbb";
        System.out.println("Test 1: " + solution.lengthOfLongestSubstring(test1)); // Output: 3

        // Test 2: Chuỗi "bbbbb" -> Kết quả là 1 (substring: "b")
        String test2 = "bbbbb";
        System.out.println("Test 2: " + solution.lengthOfLongestSubstring(test2)); // Output: 1

        // Test 3: Chuỗi "pwwkew" -> Kết quả là 3 (substring: "wke")
        String test3 = "pwwkew";
        System.out.println("Test 3: " + solution.lengthOfLongestSubstring(test3)); // Output: 3

        // Test 4: Chuỗi "" -> Kết quả là 0 (substring: "")
        String test4 = "";
        System.out.println("Test 4: " + solution.lengthOfLongestSubstring(test4)); // Output: 0
    }
}
