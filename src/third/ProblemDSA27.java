package third;

/*
Tower of Hanoi is a mathematical puzzle where we have three rods (A, B, and C) and N disks. Initially, all the disks are stacked in decreasing value of diameter i.e., the smallest disk is placed on the top and they are on rod A. The objective of the puzzle is to move the entire stack to another rod (here considered C), obeying the following simple rules:

Only one disk can be moved at a time.
Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
No disk may be placed on top of a smaller disk.
Examples:
Input: 2
Output: Disk 1 moved from A to B
Disk 2 moved from A to C
Disk 1 moved from B to C

Input: 3
Output: Disk 1 moved from A to C
Disk 2 moved from A to B
Disk 1 moved from C to B
Disk 3 moved from A to C
Disk 1 moved from B to A
Disk 2 moved from B to C
Disk 1 moved from A to C

Input: 4
Output:
 Disk 1 moved from A to B
 Disk 2 moved from A to C
 Disk 1 moved from B to C
 Disk 3 moved from A to B
 Disk 1 moved from C to A
 Disk 2 moved from C to B
 Disk 1 moved from A to B
 Disk 4 moved from A to C
 Disk 1 moved from B to C
 Disk 2 moved from B to A
 Disk 1 moved from C to A
 Disk 3 moved from B to C
 Disk 1 moved from A to B
 Disk 2 moved from A to C
 Disk 1 moved from B to C
*/

public class ProblemDSA27 {

    public static void main(String[] args) {
        SolutionDSA27 solution = new SolutionDSA27();
        solution.towerOfHanoi(5, 'A', 'C', 'B');
    }
}

class SolutionDSA27 {
    public void towerOfHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 0) {
            return;
        }

        towerOfHanoi(n - 1, fromRod, auxRod, toRod);
        System.out.println("Disk: " + n + " " + "from rod: " + fromRod + " to rod: " + toRod);
        towerOfHanoi(n - 1, auxRod, toRod, fromRod);
    }

}