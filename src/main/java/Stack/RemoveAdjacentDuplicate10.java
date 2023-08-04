package Stack;

public class RemoveAdjacentDuplicate10 {


    public String removeDuplicates(String s) {
        int index = 0;
        int length = s.length();
        char[] result = new char[length];
        for (char c : s.toCharArray()) {
            if (index == 0) {
                result[index++] = c;
            } else {
                if (c == result[index - 1]) {
                    index--;
                } else {
                    result[index++] = c;
                }
            }
        }
        return new String(result, 0, index);
    }



    public static void main(String[] args) {
        RemoveAdjacentDuplicate10 obj = new RemoveAdjacentDuplicate10();
        System.out.println(obj.removeDuplicates("geeksforgeek"));
    }
}
