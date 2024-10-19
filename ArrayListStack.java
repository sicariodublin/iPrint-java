/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dslab.stack;

/**
 *
 * @author fabio
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//This line is the beginning of a class definition for a generic stack implemented using an ArrayList. 
//The ArrayListStack class provides specific implementations for the generic stack operations defined in the Stack interface, 
//allowing it to be used as a stack for any type of elements.
class ArrayListStack<T> implements Stack<T> {
    private ArrayList<T> stack; // Internal storage for stack elements.

    public ArrayListStack() {
        stack = new ArrayList<>(); // Initialize the stack storage.
    }
    
    //The push method implements the stack operation of adding an element to the top of the stack.
    //It does so by utilizing the ArrayList's add method to insert the element at the end of the internal list (stack), 
    //which represents the stack's top in this implementation.
    @Override
    public void push(T element) {
        stack.add(element); // Adds an element to the end of the list, which is the top of the stack.
    }

    //The pop method is designed to remove the top element from the stack and return it. However, 
    //it first checks if the stack is empty to avoid an illegal operation. If the stack is not empty, 
    //it proceeds to remove and return the top element (not shown in the provided code snippet). 
    //If the stack is empty, it throws an exception to indicate an error in attempting to pop from an empty stack. 
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Pop operation on an empty stack");
        }
        return stack.remove(stack.size() - 1); // Removes and returns the last element of the list, the top of the stack.
    }

    //The peek method is designed to return the top element of the stack without removing it. 
    //Before attempting to retrieve the top element, it checks if the stack is empty using the isEmpty method. 
    //If the stack is empty, it throws an IllegalStateException to indicate that attempting to peek into an empty stack is an illegal operation. 
    //This ensures the method only attempts to access the stack's top element when it is guaranteed that the stack is not empty, thus preventing runtime errors related to accessing elements in an empty stack.
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Peek operation on an empty stack"); 
        }
        return stack.get(stack.size() - 1); 
    }

    // Checks if the internal list is empty.
    @Override
    public boolean isEmpty() {
        return stack.isEmpty(); 
    }

    // Added functionalities for user interactions
    public boolean contains(T element) {
        return stack.contains(element); // Checks if the stack contains a specific element.
    }

    // Clears the stack by clearing the internal list.
    public void clear() {
        stack.clear(); 
    }

    // Returns a string representation of the stack.
    @Override
    public String toString() {
        return "Stack: " + stack.toString(); 
    }

    // Creates a stack instance for storing strings.
    // Scanner object for reading user input.
    public static void main(String[] args) {
        Stack<String> personStack = new ArrayListStack<>(); 
        Scanner scanner = new Scanner(System.in); 
        
        // Predefined array of names
        String[] preloadedNames = {"Mirian", "Jolier", "Pedro", "Fabio"};

        // Add names from the array to the stack
        for (String name : preloadedNames) {
            personStack.push(name);
        }
        System.out.println("Preloaded names added to the stack.");
        
        // Main interaction loop
        while (true) {
            // Display menu options
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Name");
            System.out.println("2. Remove Name");
            System.out.println("3. Check Name");
            System.out.println("4. Top Name");
            System.out.println("5. Display Stack");
            System.out.println("6. Empty Stack");
            System.out.println("7. Quit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            try {
                choice = scanner.nextInt(); // Attempts to read the user's choice as an integer.
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number from 1 to 7."); // Handle non-integer inputs.
                scanner.nextLine(); // Consume the invalid input
                continue; // Skip the rest of the loop and prompt for input again.
            }
            scanner.nextLine(); // Consume newline character after the integer input.
            
            // Process the user's choice using a switch statement.
            switch (choice) {
                case 1: // Add a name to the stack.
                    System.out.print("Enter a name to add: ");
                    String nameToAdd = scanner.nextLine();
                    personStack.push(nameToAdd);
                    break;
                case 2: // Remove and show the top name from the stack.
                    if (!personStack.isEmpty()) {
                        System.out.println("Removed name: " + personStack.pop());
                    } else {
                        System.out.println("The stack is empty, unable to remove a name.");
                    }
                    break;
                case 3: // Check if a specific name is in the stack.
                    System.out.print("Enter a name to check: ");
                    String nameToCheck = scanner.nextLine();
                    System.out.println("Stack contains " + nameToCheck + ": " + ((ArrayListStack<String>) personStack).contains(nameToCheck));
                    break;
                case 4: // Display the top name in the stack without removing it.
                    if (!personStack.isEmpty()) {
                        System.out.println("Top name: " + personStack.peek());
                    } else {
                        System.out.println("The stack is empty.");
                    }
                    break;
                case 5: // Show all names in the stack.
                    System.out.println("Current stack: " + personStack);
                    break;
                case 6: // Empty the stack.
                    ((ArrayListStack<String>) personStack).clear();
                    System.out.println("Stack cleared.");
                    break;
                case 7: // Exit
                    System.out.println("Quitting.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}


