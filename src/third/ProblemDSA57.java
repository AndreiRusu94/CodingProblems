package third;
/*
We have houses (H) and empty lots (-), and we need to place the minimum number of water tanks (T) on the - so that every house is supplied.

A T can supply its neighboring houses (left and right).
Tanks can only be placed on -, not on H.

*/

public class ProblemDSA57 {
    public static void main(String[] args) {
        SolutionDSA57 solution = new SolutionDSA57();

        System.out.println(solution.placeTanks("-H--H--"));
    }
}

class SolutionDSA57 {

    public int placeTanks(String street) {
        char[] arr = street.toCharArray();
        int n = street.length();
        int tankCount = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'H') {
                if (i > 0 && arr[i - 1] == 'T') {
                    continue;
                }

                if (i + 1 < n && arr[i + 1] == '-') {
                    arr[i + 1] = 'T';
                    tankCount++;
                } else if (i > 0 && arr[i - 1] == '-') {
                    arr[i - 1] = 'T';
                    tankCount++;
                } else {
                    return -1;
                }
            }
        }

        return tankCount;
    }
}