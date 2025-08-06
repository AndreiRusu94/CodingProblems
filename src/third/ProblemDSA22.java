package third;
/*
Generating Power set in lexicographical order.
Examples :

Input : abc
Output : a ab abc ac b bc c
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemDSA22 {
    public static void main(String[] args) {
        SolutionDSA22 solution = new SolutionDSA22();

        solution.generatePowerSet("abc");
    }
}

class SolutionDSA22 {

    public void generatePowerSet(String s) {
        var chars = s.toCharArray();
        Arrays.sort(chars);
        String sortedS = new String(chars);
        List<String> subsets = new ArrayList<>();
        int n = sortedS.length();

        for (int i = 0; i < (1 << n); i++) {
            int num = i;
            StringBuilder binary = new StringBuilder();
            for (int j = 0; j < n; j++) {
                binary.insert(0, num % 2);
                num /= 2;
            }

            StringBuilder subset = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (binary.charAt(j) == '1') {
                    subset.append(sortedS.charAt(j));
                }
            }
            subsets.add(subset.toString());
        }

        subsets.sort(null);

        for (String subset : subsets) {
            System.out.println(subset + " ");
        }

    }

}
