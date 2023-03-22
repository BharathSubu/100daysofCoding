//https://leetcode.com/problems/design-browser-history/

import java.util.*;

public class DesignBrowserHistory {

    private Deque<String> history;
    private Deque<String> forward;

    public DesignBrowserHistory(String homepage) {
        history = new LinkedList<>();
        history.push(homepage);
        forward = new LinkedList<>();
    }

    public void visit(String url) {
        history.push(url);
        forward.clear();
    }

    public String back(int steps) {
        while (steps > 0 && history.size() > 1) {
            forward.push(history.pop());
            steps--;
        }
        return history.peek();
    }

    public String forward(int steps) {
        while (steps > 0 && !forward.isEmpty()) {
            history.push(forward.pop());
            steps--;
        }
        return history.peek();
    }
}
