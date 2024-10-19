/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dslab.stack;

/**
 *
 * @author fabio
 */
public interface Stack<T> {
    void push(T element); // Adds an element to the top of the stack
    T pop(); // Removes and returns the top element of the stack
    T peek(); // Returns the top element without removing it from the stack
    boolean isEmpty(); // Check if the stack is empty
}
