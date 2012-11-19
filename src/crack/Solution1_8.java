package crack;

public class Solution1_8 {
    public static boolean isRotation(String s1, String s2) {
        assert(s1 != null && s2 != null);
        String cat = s1 + s2;
        return s1.length() == s2.length() && s1.indexOf(s2) == 0;
    }
}
