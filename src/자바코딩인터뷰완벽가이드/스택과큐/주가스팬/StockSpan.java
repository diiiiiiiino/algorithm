package 자바코딩인터뷰완벽가이드.스택과큐.주가스팬;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    private static int[] stockSpan(int[] stockPrices) {
        if(stockPrices == null){
            throw new IllegalArgumentException();
        }

        int[] stockSpan = new int[stockPrices.length];
        Stack<Integer> stack = new Stack<>();
        stockSpan[0] = 1;
        stack.push(0);

        for(int i = 1; i < stockPrices.length; i++){
            while(!stack.isEmpty() && stockPrices[i] > stockPrices[stack.peek()]){
                stack.pop();
            }

            if(stack.empty()){
                stockSpan[i] = i + 1;
            } else {
                stockSpan[i] = i - stack.peek();
            }

            stack.push(i);
        }

        return stockSpan;
    }

    public static void main(String[] args) {
        int stockPrices[] = { 55, 34, 22, 23, 27, 88, 70, 42, 51, 100 };
        int[] spanResult = StockSpan.stockSpan(stockPrices);

        System.out.println("Stock prices: " + Arrays.toString(stockPrices));
        System.out.println("Span results: " + Arrays.toString(spanResult));
    }
}
