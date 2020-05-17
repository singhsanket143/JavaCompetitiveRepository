package Leetcode.Graphs;

import java.util.*;

public class PossibleBipartition {
    Set<Integer>[] createGraph(int n, int[][] edges) {
        Set<Integer>[] graph = (Set<Integer>[]) new Set<?>[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<Integer>();
        }
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0] - 1;
            int y = edges[i][1] - 1;
            graph[x].add(y);
            graph[y].add(x);
        }
        return graph;
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        if (N == 0) return true;
        Set<Integer>[] graph = createGraph(N, dislikes);
        Set<Integer>[] color = (Set<Integer>[]) new Set<?>[2];
        color[0] = new HashSet<>();
        color[1] = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> qu = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (visited.contains(i)) continue;
            qu.addLast(i);
            color[0].add(i);

            while (qu.size() > 0) {
                int current = qu.getFirst();
                qu.removeFirst();
                visited.add(current);
                int currentColor = color[0].contains(current) ? 0 : 1;
                for (int neighbour : graph[current]) {
                    if (!color[0].contains(neighbour) && !color[1].contains(neighbour)) {
                        color[1 - currentColor].add(neighbour);
                        qu.addLast(neighbour);
                    } else if (color[currentColor].contains(neighbour)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
