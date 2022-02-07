package queue;

import java.util.ArrayList;

public class Qqueue<T> {
    private ArrayList<T> queue = new ArrayList<T>();
    
    // Enqueue
    public void enqueue(T item) {
        queue.add(item);
    }
    
    // Dequeue
    public T dequeue() {
        if(queue.isEmpty()) {
            return null;
        } else {
            return queue.remove(0);
        }
        
    }
    
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    public static void main(String[] args) {
        Qqueue<String> q = new Qqueue<>();
        q.enqueue("¾È³ç");
        q.enqueue("ÇÏ¼¼¿ä");
        
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}