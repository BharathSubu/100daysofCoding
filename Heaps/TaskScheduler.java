// https://leetcode.com/problems/task-scheduler/

import java.util.*;


class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        int time = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((first, second) -> second.second - first.second);
        Queue<TPair> q = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        for (HashMap.Entry<Character, Integer> entry : map.entrySet()) {
            Pair p = new Pair(entry.getKey(), entry.getValue());
            pq.add(p);
        }
        while (!pq.isEmpty() || !q.isEmpty()) {

            while (!q.isEmpty() && q.peek().third <= time) {
                TPair addTPair = q.remove();
                pq.add(new Pair(addTPair.first, addTPair.second));
            }
            if (pq.isEmpty()) {
                TPair addTPair = q.remove();
                time = addTPair.third;
                pq.add(new Pair(addTPair.first, addTPair.second));
            }
            Pair p = pq.remove();
            time++;
            if (p.second != 1) {
                TPair tp = new TPair(p.first, p.second - 1, time + n);
                q.add(tp);
            }
        }
        return time;
    }

    public static void main(String[] args) {
        char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'C', 'C' };
        System.out.println(leastInterval(tasks, 3));
    }
}

class Pair {
    char first;
    int second;

    Pair(char a, int b) {
        first = a;
        second = b;
    }
}

class TPair {
    char first;
    int second;
    int third;

    TPair(char a, int b, int c) {
        first = a;
        second = b;
        third = c;
    }
}