class MinStack {

    // Stores all elements
    Stack<Integer> stack;

    // Stores minimum element till each position
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {

        // Push value into main stack
        stack.push(value);

        // If minStack is empty, current value is the minimum
        if (minStack.isEmpty()) {
            minStack.push(value);
        } else {

            // Store the minimum till this position
            minStack.push(Math.min(value, minStack.peek()));
        }
    }

    public void pop() {

        // Remove from both stacks
        stack.pop();
        minStack.pop();
    }

    public int top() {

        // Return top element
        return stack.peek();
    }

    public int getMin() {

        // Top of minStack always contains current minimum
        return minStack.peek();
    }
}
