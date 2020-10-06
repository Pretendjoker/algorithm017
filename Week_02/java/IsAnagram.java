/**
 * @author Zewei Ni
 * @version :PACKAGE_NAME on 2020-09-27 21:41 Zewei Ni
 * @name IsAnagram
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i=0; i<s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int j=0; j<t.length(); j++) {
            table[t.charAt(j) - 'a']--;
            if (table[t.charAt(j) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
