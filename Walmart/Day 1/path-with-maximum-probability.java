Problem Link : https://leetcode.com/problems/path-with-maximum-probability/

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map < Integer, List < Pair < Integer, Double >>> hm = new HashMap < > ();
        for (int i = 0; i < n; i++) {
            hm.put(i, new ArrayList < > ());
        }
        for (int i = 0; i < edges.length; i++) {
            hm.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            hm.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }
        PriorityQueue < Pair < Integer, Double >> pq = new PriorityQueue < > ((a, b) -> Double.compare(b.getValue(), a.getValue()));
        Double prob[] = new Double[n];
        pq.add(new Pair(start, 1.0));
        while (!pq.isEmpty()) {
            Pair < Integer, Double > temp = pq.poll();
            int v = temp.getKey();
            double pb = temp.getValue();
            if (prob[v] != null) continue;
            prob[v] = pb;
            if (v == end) break;
            for (Pair < Integer, Double > nbr: hm.get(v)) {
                int adjNode = nbr.getKey();
                double adjProb = nbr.getValue();
                if (prob[adjNode] == null) {
                    pq.add(new Pair(adjNode, adjProb * pb));
                }
            }
        }
        return prob[end] == null ? 0 : prob[end];
    }
}