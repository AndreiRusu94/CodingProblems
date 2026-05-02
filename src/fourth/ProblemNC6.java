package fourth;
/*
You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history
number of steps or move forward in the history number of steps.

Implement the BrowserHistory class:

BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
void visit(string url) Visits url from the current page. It clears up all the forward history.
string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.

Example:

Input:
["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
[["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
Output:
[null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"] */

public class ProblemNC6 {
    public static void main(String[] args) {
        SolutionNC6 solution = new SolutionNC6();

        SolutionNC6.BrowserHistory browserHistory = solution.new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
        browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
        browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"    }
    }

}

class SolutionNC6 {
    class BrowserHistory {

        ListNode cur;

        public BrowserHistory(String homepage) {
            cur = new ListNode(homepage);
        }

        public void visit(String url) {
            cur.next = new ListNode(url, cur, null);
            cur = cur.next;
        }

        public String back(int steps) {
            while (cur.prev != null && steps > 0) {
                cur = cur.prev;
                steps--;
            }

            return cur.val;
        }

        public String forward(int steps) {
            while (cur.next != null && steps > 0) {
                cur = cur.next;
                steps--;
            }

            return cur.val;
        }
    }

    private static class ListNode {

        String val;
        ListNode prev, next;

        public ListNode(String val) {
            this(val, null, null);
        }

        public ListNode(String val, ListNode prev, ListNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}