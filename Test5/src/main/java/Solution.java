import java.io.InputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

       // String str = "avcsb123ddg6743";
        // find(str);
        int[] chaa = find(str);
        for (int i = 0; i <chaa.length ; i++) {
            System.out.print(chaa[i]);
        }



    }

    public static int[] find(String str) {
        int[] bb = {-1};
        if(str==null){
            return bb;
        }
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        // char[] ch = new char[20];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0' || chars[i] == '1' || chars[i] == '2'
                    || chars[i] == '3' || chars[i] == '4'
                    || chars[i] == '5' || chars[i] == '6'
                    || chars[i] == '7' || chars[i] == '8' || chars[i] == '9') {
                // ch[i] = chars[i];
                sb.append(chars[i]);
            }
        }
        if(sb.length()==0){
            return bb;
        }

        String str2 = sb.toString();
        char[] cha = str2.toCharArray();
        for (int i = 0; i < cha.length; i++) {
            for (int j = 0; j < cha.length - i - 1; j++) {
                if (cha[j] > cha[j + 1]) {
                    char tmp = cha[j];
                    cha[j] = cha[j + 1];
                    cha[j + 1] = tmp;
                }
            }
        }
        int[] arr = new int[cha.length];
        for (int i = 0; i <cha.length ; i++) {
            arr[i] = cha[i]-'0';

        }

        return arr;
    }
}

