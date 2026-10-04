class Solution 
{
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        // Step 1: build the graph (adjacency list)
        
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) 
        {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) 
        {
            graph.get(edge.get(0)).add(new int[]{edge.get(1), edge.get(2)});
        }

        // Step 2: distance array, -1 means "not reached yet"

        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        // Step 3: min-heap of {vertex, distance}

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0});

        // Step 4: Dijkstra (simplified)

        while (!pq.isEmpty()) 
        {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];

            if (dist[u] != -1) 
            continue;                            // already finalised
            dist[u] = d;

            for (int[] nb : graph.get(u)) 
            {
                if (dist[nb[0]] == -1) 
                {
                    pq.add(new int[]{nb[0], d + nb[1]});
                }
            }
        }

        // Step 5: build the result map

        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < n; i++) 
        {
            result.put(i, dist[i]);
        }
        return result;
    }
}

