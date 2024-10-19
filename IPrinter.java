package dslab.iprint;

/**
 *
 * @author fabio
 */

// Defines the IPrinter interface with methods relevant to a print server.
public interface IPrinter {
    void submitPrintJob(String job); // Add a job for printing
    String printNextJob(); // Return and remove the name of the next job in FIFO sequence
    int size(); // Return the number of jobs waiting to be printed
    String pollNextJob(); // Returns the name of the next job without removing it
}
