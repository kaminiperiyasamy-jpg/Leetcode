class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            long x1 = bombs[i][0], y1 = bombs[i][1], r1 = bombs[i][2];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                long x2 = bombs[j][0], y2 = bombs[j][1];
                long dx = x1 - x2;
                long dy = y1 - y2;
                if (dx * dx + dy * dy <= r1 * r1) {
                    graph[i].add(j);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            visited[i] = true;
            int count = 0;
            while (!q.isEmpty()) {
                int curr = q.poll();
                count++;
                for (int nei : graph[curr]) {
                    if (!visited[nei]) {
                        visited[nei] = true;
                        q.offer(nei);
                    }
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}