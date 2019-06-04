import java.util.*;
public class SubRectangularMatrixWithMaximumSum {

    class Result {
        int maxSum;
        int leftBound;
        int rightBound;
        int upBound;
        int lowBound;
        @Override
        public String toString() {
            return "" + maxSum;
        }
    }

    public Result maxSum(int input[][]) {
        int rows = input.length;
        int cols = input[0].length;
        int temp[] = new int[rows];
        Result result = new Result();
        for (int left = 0; left < cols ; left++) {
            for (int i = 0; i < rows; i++) {
                temp[i] = 0;
            }
            for (int right = left; right < cols; right++) {
                for (int i = 0; i < rows; i++) {
                    temp[i] += input[i][right];
                }
                KadaneResult kadaneResult = kadane(temp);
                if (kadaneResult.maxSum > result.maxSum) {
                    result.maxSum = kadaneResult.maxSum;
                    result.leftBound = left;
                    result.rightBound = right;
                    result.upBound = kadaneResult.start;
                    result.lowBound = kadaneResult.end;
                }
            }
        }
        return result;
    }

    class KadaneResult {
        int maxSum;
        int start;
        int end;
        public KadaneResult(int maxSum, int start, int end) {
            this.maxSum = maxSum;
            this.start = start;
            this.end = end;
        }
    }

    private KadaneResult kadane(int arr[]) {
        int max = 0;
        int maxStart = -1;
        int maxEnd = -1;
        int currentStart = 0;
        int maxSoFar = 0;
        for (int i = 0; i < arr.length; i++) {
            maxSoFar += arr[i];
            if (maxSoFar < 0) {
                maxSoFar = 0;
                currentStart = i + 1;
            }
            if (max < maxSoFar) {
                maxStart = currentStart;
                maxEnd = i;
                max = maxSoFar;
            }
        }
        return new KadaneResult(max, maxStart, maxEnd);
    }


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int [][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextInt();
            }
        }
        SubRectangularMatrixWithMaximumSum saw = new SubRectangularMatrixWithMaximumSum();
        System.out.println(saw.maxSum(a));
    }
}