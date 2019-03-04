package exercise070;


class Solution {
    
    /**
     * plan a(超时):
     * 运用斐波那契数列基本原理，通过Map/Array/ArrayList等缓存结果降低运算时间。
     */
//    public int climbStairs(int n) {
//        
//        int[] cache = new int[n + 1];
//        if (cache[n] != 0)
//            return cache[n];
//        if (n == 1)
//            return 1;
//        if (n == 2)
//            return 2;
//        cache[n] = climbStairs(n - 1) + climbStairs(n - 2);
//        return cache[n];
//    }
    
    /**
     * plan b(推荐):
     * 运用循环法累加赋值求解
     */
    public int climbStairs(int n) {
        int first = 1;
        int second = 2;
        int temp = 0;
        if (n < 3) 
            return n;
        for(int i = 2; i < n; i++){
            temp = first + second;
            first = second;
            second = temp;
        }
        return temp;
        
    }

    /**
     * 荣耀的plan c:
     * n = 46时返回值会超过int范围，因此测试用例必定在1-45内，原始而暴力
     */
//    public int climbStairs(int n) {
//        
//        int result = 0;
//        
//        switch(n){
//        case 1: result = 1; break;
//        case 2: result = 2; break;
//        case 3: result = 3; break;
//        case 4: result = 5; break;
//        case 5: result = 8; break;
//        case 6: result = 13; break;
//        case 7: result = 21; break;
//        case 8: result = 34; break;
//        case 9: result = 55; break;
//        case 10: result = 89; break;
//        case 11: result = 144; break;
//        case 12: result = 233; break;
//        case 13: result = 377; break;
//        case 14: result = 610; break;
//        case 15: result = 987; break;
//        case 16: result = 1597; break;
//        case 17: result = 2584; break;
//        case 18: result = 4181; break;
//        case 19: result = 6765; break;
//        case 20: result = 10946; break;
//        case 21: result = 17711; break;
//        case 22: result = 28657; break;
//        case 23: result = 46368; break;
//        case 24: result = 75025; break;
//        case 25: result = 121393; break;
//        case 26: result = 196418; break;
//        case 27: result = 317811; break;
//        case 28: result = 514229; break;
//        case 29: result = 832040; break;
//        case 30: result = 1346269; break;
//        case 31: result = 2178309; break;
//        case 32: result = 3524578; break;
//        case 33: result = 5702887; break;
//        case 34: result = 9227465; break;
//        case 35: result = 14930352; break;
//        case 36: result = 24157817; break;
//        case 37: result = 39088169; break;
//        case 38: result = 63245986; break;
//        case 39: result = 102334155; break;
//        case 40: result = 165580141; break;
//        case 41: result = 267914296; break;
//        case 42: result = 433494437; break;
//        case 43: result = 701408733; break;
//        case 44: result = 1134903170; break;
//        case 45: result = 1836311903; break;
//        
//        }
//        return result;
//    }
}

public class Start {

    
    public static void main(String[] args) {
        Solution s = new Solution();
        for(int i = 1; i <= 45; i++)
            System.out.println(i + " : " + s.climbStairs(i));
    }
}
