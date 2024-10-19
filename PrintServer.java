package dslab.iprint;

/**
 *
 * @author fabio
 */
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// PrintServer class implements the IPrinter interface.
public class PrintServer implements IPrinter {
    private Queue<String> printQueue;

    public PrintServer() {
        this.printQueue = new LinkedList<>();
    }

    // Adds a print job to the queue.
    @Override
    public void submitPrintJob(String job) {
        printQueue.add(job);
    }

    // Removes and returns the name of the next job in the queue.
    @Override
    public String printNextJob() {
        return printQueue.poll();
    }

    // Returns the number of jobs currently in the queue.
    @Override
    public int size() {
        return printQueue.size();
    }

    // Returns the name of the next job without removing it from the queue.
    @Override
    public String pollNextJob() {
        return printQueue.peek();
    }
    
    // Method to list all jobs in FIFO order
    // Lists all jobs currently in the queue, showing the FIFO sequence.
    public void listAllJobs() {
        if (printQueue.isEmpty()) {
            System.out.println("The print queue is empty."); // No jobs to list.
        } else {
            System.out.println("Current jobs in the queue:"); // Iterate and list jobs.
            for (String job : printQueue) {
                System.out.println(job);
            }
        }
    }

    // Main method demonstrating the usage of PrintServer.
    public static void main(String[] args) {
        PrintServer server = new PrintServer();
        Scanner scanner = new Scanner(System.in);

        // Submitting predefined print jobs
        // Preloading the server with predefined print jobs.
        System.out.println("Submitting predefined print jobs...");
        server.submitPrintJob("Print Job 1");
        server.submitPrintJob("Print Job 2");
        server.submitPrintJob("Print Job 3");
        System.out.println("Predefined jobs added to the queue.");
        server.listAllJobs(); // Show the initial queue state with predefined jobs

        // Interactive menu loop for print server management.
        while (true) {
            System.out.println("\n--- Print Server Menu ---");
            System.out.println("1. Add a print job");
            System.out.println("2. Process (delete) the next print job");
            System.out.println("3. Show the number of remaining jobs");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            try {
                choice = scanner.nextInt(); // Attempt to read user's choice.
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number from 1 to 4."); // Handle non-integer inputs.
                scanner.next(); // Clear the invalid input.
                continue; // Return to the start of the loop.
            }
            scanner.nextLine(); // Clear the newline character.

            // Process the user's choice.
            switch (choice) {
                case 1: // Add a new print job.
                    System.out.print("Enter the name of the print job to add: ");
                    String jobName = scanner.nextLine();
                    server.submitPrintJob(jobName);
                    System.out.println("'" + jobName + "' added to the print queue.");
                    server.listAllJobs(); // Display updated job list.
                    break;
                case 2: // Process and remove the next job.
                    if (server.size() > 0) {
                        String nextJob = server.printNextJob();
                        System.out.println("Processed and removed job: '" + nextJob + "'");
                        server.listAllJobs(); // Display updated job list.
                    } else {
                        System.out.println("No jobs to process.");
                    }
                    break;
                case 3: // Display the number of remaining jobs.
                    System.out.println("Number of jobs remaining: " + server.size());
                    server.listAllJobs(); // Display updated job list.
                    break;
                case 4: // Exit the program.
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default: // Handle invalid choices.
                    System.out.println("Invalid option. Please enter a valid choice.");
                    break;
            }
        }
    }
}







