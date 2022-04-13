package PS.bluemoon_2022.topinterview;  
  /*   
   Bluemoon
   10/04/22 7:27 AM  
   */

import java.util.Stack;

class StockSpanner {
    Stack<Span> stack;
    int index;

    public StockSpanner() {
        this.stack = new Stack<Span>();
        this.index = 0;
    }

    public int next(int price) {
        this.index++;
        if (stack.isEmpty()) {
            stack.push(new Span(index, price));
            return this.index;
        } else {
            while (!stack.isEmpty() && stack.peek().price <= price) {
                stack.pop();
            }
            int output = !stack.isEmpty() ? this.index - stack.peek().index : this.index;
            stack.push(new Span(this.index, price));
            return output;
        }
    }

    private static class Span {
        int index;
        int price;

        public Span(int index, int price) {
            this.index = index;
            this.price = price;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
