
import java.util.*;

public class DisjointUnionSet {

    List<Integer> rank, parent;
    int n;

    // Constructor:
    public DisjointUnionSet(int n) {
        rank = new ArrayList<>();
        parent = new ArrayList<>();
        this.n = n;
        for (int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    // O(n):
    public int find(int node) {
        if (parent.get(node) == node) {
            return node;
        }

        return find(parent.get(node));
    }

    // O(4*number of operation):
    public int find_pathCompression(int node) {
        if (parent.get(node) == node) {
            return node;
        }
        return parent.set(node, find(parent.get(node)));
    }

    public void unionByRank(int u, int v) {
        int uRoot = find_pathCompression(u), vRoot = find_pathCompression(v);

        if (uRoot == vRoot) {
            return;
        }

        if (rank.get(uRoot) < rank.get(vRoot)) {
            parent.set(uRoot, vRoot);
        } else if (rank.get(uRoot) > rank.get(vRoot)) {
            parent.set(vRoot, uRoot);
        } else {
            parent.set(vRoot, uRoot);
            rank.set(uRoot, rank.get(uRoot) + 1);
        }
    }

    public static void main(String[] args) {
        DisjointUnionSet ds = new DisjointUnionSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(4, 2);
        System.out.println(ds.parent);
        System.out.println(ds.rank);

        ds.unionByRank(6, 3);
        ds.unionByRank(5, 2);
        System.out.println(ds.parent);
        System.out.println(ds.rank);

        ds.unionByRank(5, 4);
        System.out.println(ds.parent);
        System.out.println(ds.rank);

    }
}
