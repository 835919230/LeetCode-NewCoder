package com.leetcode.grapth;

import java.util.*;

/**
 * 课程表，拓扑排序，dfs遍历，有环的话关系不存在，无环的话输出一个可能的顺序
 */
public class No201 {

    List<List<Integer>> edges;

    int[] visited;

    int[] result;

    boolean valid;

    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        result = new int[numCourses];
        index = numCourses - 1;
        valid = true;

        for(int[] pre : prerequisites) {
            edges.get(pre[1]).add(pre[0]);
        }
        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (!valid) {
            return new int[0];
        }

        return result;
    }

    public void dfs(int u) {
        visited[u] = 1;

        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
        result[index--] = u;
    }
}
