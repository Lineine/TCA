package net.mooctest;

public final class BruteForceKnapsack_Test {

    static int knapSack(int W, int[] wt, int[] val, int n) {
        int maxVal = 0;
        for (int i = 0; i < (1 << n); i++) {
            int totalWeight = 0;
            int totalValue = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j))!= 0) {
                    totalWeight += wt[j];
                    totalValue += val[j];
                }
            }
            if (totalWeight <= W) {
                maxVal = Math.max(maxVal, totalValue);
            }
        }
        return maxVal;
    }

    public static void main(String[] args) {
        int[] val = new int[] {60, 100, 120};
        int[] wt = new int[] {10, 20, 30};
        int w = 50;
        int n = val.length;
        System.out.println(knapSack(w, wt, val, n));
    }
}
