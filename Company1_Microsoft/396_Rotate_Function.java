// Runtime 5 ms     Beats 67.96%

// using dp approach f(1) = f(0) + sum - n*arr[n-1]
// f(k) = f(k-1) +sum - n*arr[n-k];
class Solution {
    public int maxRotateFunction(int[] nums) {
        int len=nums.length;
        if(nums == null || nums.length ==0) return 0;

        int sum=0, f0=0; 
        for(int i=0;i<len;i++){
            sum += nums[i];
            f0 += i*nums[i];
        }

        int[] dp = new int[len];
        dp[0]=f0;  
        int max = dp[0];
        for(int i=1;i<len;i++){
            dp[i] = dp[i-1] + sum - len*nums[len-i];
            max = Math.max(dp[i], max);
        }
        return max;
    }
}


// brute firce --> o(n2)  --> got TLE error
// class Solution {
//     public int maxRotateFunction(int[] nums) {
//         int len=nums.length;

//         int[] n = new int[len];
//         for(int i=0;i<len;i++) n[i]=i;

//         return helper(nums,n);
//     }

//     public int helper(int[] arr, int[] num){
//         int len=arr.length;
//         int overMax=Integer.MIN_VALUE;
//         while(len>=0){
//         int sum =0;
//         for(int i=0;i<arr.length;i++){
//             int c = num[i]%arr.length;
//             sum = sum+ ( arr[i]*c);
//             num[i]++;
//         }
//         // System.out.println(sum+" "+overMax);

//         if(sum>overMax) overMax=sum;
//         len--;
//         }
//         return overMax;
//     }
// }package Company1_Microsoft;

public class 396_Rotate_Function {
    
}
