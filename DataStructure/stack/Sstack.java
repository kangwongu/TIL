package stack;

import java.util.ArrayList;

public class Sstack<T> {
    private ArrayList<T> stack = new ArrayList<T>();
   
    
    // push
    public void push(T item) {
        stack.add(item);
    }
    
    // pop
    public T pop() {
        if(stack.isEmpty()) {
            return null;
        }
        return stack.remove(stack.size()-1);
    }
    
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    
    
    public static void main(String[] args) {
        Sstack<Integer> stack = new Sstack<Integer>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
