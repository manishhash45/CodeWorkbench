package com.mk.java.dp.Knapsack;

public class knapsackSol {

    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};

        int W = 50;

        System.out.println("Maximum value that can be obtained: " + new knapsackSol().knapsack(W, val, wt));
    }

    public int knapsack(int W, int val[], int wt[]) {
        int n=wt.length;

        int [][]dp = new int [n][W+1];


        for(int i=0; i< n; i++)
            for(int j=0; j<=W ; j++)
                dp[i][j]=-1;


        // code here
        return f(wt.length-1,W,val,wt,dp);
    }

    private int f(int ind, int W, int val[], int wt[],int [][] dp)
    {
        if(ind==0)
        {
            if(wt[ind]<=W) return val[ind];
            else
                return 0;
        }

        if(dp[ind][W]!=-1) return dp[ind][W];

        int skip= f(ind-1, W, val,wt,dp);

        int take=0;
        if(wt[ind]<=W)
            take= val[ind]+ f(ind-1, W-wt[ind], val,wt,dp);


        return dp[ind][W]=Math.max(take, skip);


    }



//TEL
// class Solution {
//     public int knapsack(int W, int val[], int wt[]) {
//         // code here
//       return f(wt.length-1,W,val,wt);
//     }

//     private int f(int ind, int W, int val[], int wt[])
//     {
//         if(ind==0)
//         {
//             if(wt[ind]<=W) return val[ind];
//             else
//             return 0;
//         }

//         int skip= f(ind-1, W, val,wt);

//         int take=0;
//         if(wt[ind]<=W)
//         take= val[ind]+ f(ind-1, W-wt[ind], val,wt);


//         return Math.max(take, skip);


//     }

// }
}
