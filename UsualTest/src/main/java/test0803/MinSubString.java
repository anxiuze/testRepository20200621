package test0803;

/**
 * @author anxiuze
 * @date 2020/8/4 10:16
 * @Description:  输出str1的字串中含有str2所有字符的最小字符串长度，如果不存在请输出0。
 *      示例1：str1 = "abcde", str2 = "ac"；  输出：3； 说明："abc"中包含"ac"，且"abc"是所有满足条件中长度最小的；
 *      示例2：str1 = "12345", str2 = "344"； 输出：0；
 */
public class MinSubString {

    public static void main(String[] args) {
        MinSubString minSubString = new MinSubString();

        String str1 = "abcde";
        String str2 = "ac";
        int result = minSubString.minLength(str1, str2);
        System.out.println("最小字符串长度: "+result);
    }


    public int minLength(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() < str2.length()) {
            return 0;
        }
        char[] chas1 = str1.toCharArray();
        char[] chas2 = str2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < chas2.length; i++) {
            map[chas2[i]]++;
        }
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int match = chas2.length;
        while (right != chas1.length) {
            map[chas1[right]]--;
            System.out.println(map[chas1[right]]);
            if (map[chas1[right]] >= 0) {
                match--;
            }
            if (match == 0) {
                while (map[chas1[left]] < 0) {
                    map[chas1[left++]]++;
                    System.out.println(map[chas1[left++]]++);
                }
                minLen = Math.min(minLen, right - left + 1);
                match++;
                map[chas1[left++]]++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }


}
