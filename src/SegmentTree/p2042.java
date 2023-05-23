package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2042 {
    static int N, M, K;
    static long[] values, tree;
    static int height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        height = (int) Math.ceil(Math.log(N)/Math.log(2));
        values = new long[N+1];

        for (int i = 1; i <= N; i++) {
            values[i] = Long.parseLong(br.readLine());
        }

        tree = new long[(int) Math.pow(2, height+1)];

        initTree(1, 1, N);
//        printTree();

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                updateTree(1, 1, N, b, c);
//                printTree();
            } else {
                sb.append(getPrefixSumTree(1, 1, N, b, c)).append('\n');
            }
        }

        System.out.println(sb);
    }

    static void printTree() {
        int l = 2;
        for (int i = 1; i < tree.length; i++) {
            if (i == l) {
                System.out.println();
                l *= 2;
            }
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

    static long initTree(int node, int start, int end) {
        if (start == end) return tree[node] = values[start];

        return tree[node] = initTree(node*2, start, (start+end)/2) + initTree(node*2 + 1, (start+end)/2 + 1, end);
    }

    static long updateTree(int node, int start, int end, int index, long value) {
        if (start > index || end < index) return tree[node];

        if (start == end) return tree[node] = value;

        return tree[node] = updateTree(node*2, start, (start+end)/2, index, value) + updateTree(node*2+1, (start+end)/2 + 1, end, index, value);
    }

    static long getPrefixSumTree(int node, int start, int end, int left, long right) {
        if (start > right || end < left) return 0;

        if (left <= start && right >= end) return tree[node];

        return getPrefixSumTree(node*2, start, (start+end)/2, left, right) + getPrefixSumTree(node*2 + 1, (start+end)/2 + 1, end, left, right);
    }
}
