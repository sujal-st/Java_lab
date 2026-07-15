import java.io.*;
import java.util.Scanner;

public class Employee{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Create file object
            File file = new File("employee_records.txt");

            // Create file if it does not exist
            if (file.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }

            // Accept employee details
            System.out.print("Enter Employee ID: ");
            String id = sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            System.out.print("Enter Salary: ");
            String salary = sc.nextLine();

            // Append data to file
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(id + "\t" + name + "\t" + dept + "\t" + salary);
            bw.newLine();

            bw.close();

            System.out.println("\nEmployee record saved successfully.");

            // Read and display file contents
            System.out.println("\nStored Employee Records:");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

            // Display file information
            System.out.println("\nFile Information");
            System.out.println("File Name: " + file.getName());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("File Size: " + file.length() + " bytes");
            System.out.println("Readable: " + file.canRead());
            System.out.println("Writable: " + file.canWrite());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}