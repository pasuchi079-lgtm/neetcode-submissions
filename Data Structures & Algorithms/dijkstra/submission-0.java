class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {      
         // Step 1: build the graph (adjacency list)

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) 
        {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) 
        {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            graph.get(u).add(new int[]{v, w});
        }

        // Step 2: distance array, all "infinity" except the source

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 3: min-heap that always gives the closest vertex first

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0});

        // Step 4: Dijkstra

        while (!pq.isEmpty()) 
        {
            int[] current = pq.poll();
            int u = current[0];
            int d = current[1];

            if (d > dist[u]) continue;   // outdated entry, skip

            for (int[] neighbor : graph.get(u)) 
            {
                int v = neighbor[0];
                int w = neighbor[1];

                if (d + w < dist[v]) 
                {
                    dist[v] = d + w;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        // Step 5: build the result map (-1 for unreachable vertices)

        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < n; i++) 
        {
            result.put(i, dist[i] == Integer.MAX_VALUE ? -1 : dist[i]);
        }
        return result;
    }
}