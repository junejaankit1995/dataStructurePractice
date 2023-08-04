package searching.practice;

public class RemoveAllAdjacentDuplicate6 {

    private String rduplicateRecrusively(String str) {
        if (str.length() <= 1) {
            return str;
        }
        String tmp, smallInput;
        if (str.charAt(0) == str.charAt(1)) {
            int i = 0;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                i++;
            }
            smallInput = str.substring(++i);
            tmp = "";
            return tmp += rduplicateRecrusively(smallInput);
        } else {
            tmp = str.substring(0, 1);
            return tmp + rduplicateRecrusively(str.substring(1));
        }
    }

    public String removeDuplicateRecursively(String str) {
        String nInput = "";
        while (str.length() != nInput.length()) {
            nInput = str;
            str = rduplicateRecrusively(str);
        }
        return str;
    }

    private String rDuplicate(String str) {
        StringBuilder builder = new StringBuilder();
        int i = 0, n = str.length();
        while (i < n) {
            if (i < (n - 1) && str.charAt(i) == str.charAt(i + 1)) {
                while (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
                    i++;
                }
            } else {
                builder.append(str.charAt(i));
            }
            i++;
        }
        return builder.toString();
    }
}
