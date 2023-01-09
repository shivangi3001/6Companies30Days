// freqently and imp ques --> microsoft

// Runtime 82 ms     Beats 5.1%
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> l1 = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;
        if(n==1){
            l1.add(nums[0]);  return l1;
        }

        int[] dp = new int[n];
        for(int i=0;i<n;i++) dp[i]=1;
        
        int max=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j] == 0 && dp[j]+1>dp[i] ){
                    dp[i]=dp[j]+1;
                    max = Math.max(max, dp[i]);
                }
            }
        }
        
         for(int i=0;i<n;i++) System.out.print(nums[i]+" ");      System.out.println();
        for(int i=0;i<n;i++) System.out.print(dp[i]+" ");      System.out.println();
        System.out.println(max);

        int prev=-1;
        for(int i=n-1;i>=0;i--){
            if(max==dp[i] && (prev == -1 || nums[prev]%nums[i] == 0 )){
                l1.add(nums[i]);
                max--;  prev=i;
            }
        }

        return l1;
    }
}

// few hidden testcases which did not pass in 1 go
// [35,2,71,5,47,70,99,86]
// [1]
// [3,17]


// tried some other brute force approach
// class Solution {
//     public List<Integer> largestDivisibleSubset(int[] nums) {
//         List<Integer> l1 = new ArrayList<>();

//         int n = nums.length;
//         int[] dp = new int[n];
//         int[] hash = new int[n];

//         for(int i=0;i<n;i++){
//             hash[i] =i;
//             for(int prev=0;prev<i;prev++){
//                 if(nums[prev]%nums[i]==0 || nums[i]%nums[prev]==0){
//                     if(1+dp[prev] > dp[i]){
//                         dp[i] = 1+dp[prev];
//                         hash[i]=prev;
//                     }
//                 }
//             }
//         }
//         int ans = -1;
//         int lastIndex =-1;
        
//         for(int i=0; i<=n-1; i++){
//             if(dp[i]> ans){
//                 ans = dp[i];
//                 lastIndex = i;
//             }
//         }
        
//         ArrayList<Integer> temp=new ArrayList<>();
//         temp.add(nums[lastIndex]);
        
//         while(hash[lastIndex] != lastIndex){ // till not reach the initialization value
//             lastIndex = hash[lastIndex];
//             temp.add(nums[lastIndex]);    
//         }
//         // System.out.println(temp);

//         for(int i=temp.size()-1;i>=0;i--) l1.add(temp.get(i));

//         return l1;
//     }
// }