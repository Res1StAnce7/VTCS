// On my honor:
// - I have not used source code obtained from another student,
//   or any other unauthorized source, either modified or
//   unmodified.
//
// - All source code and documentation used in my program is
//   either my original work, or was derived by me from the
//   source code published in the textbook for this course.
//
// - I have not discussed coding details about this project
//   with anyone other than my partner (in the case of a joint
//   submission), instructor, ACM/UPE tutors or the TAs assigned
//   to this course. I understand that I may discuss the concepts
//   of this program with other students, and that another student
//   may help me debug my program so long as neither of us writes
//   anything during the discussion or modifies any computer file
//   during the discussion. I have violated neither the spirit nor
//   letter of this restriction.
import java.io.IOException;
import java.io.File;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * This class will use heap sort to sort the external binary file.
 * 
 * @author Siliang Zhang
 * @version 06/22/2022
 */
public class HeapSort {
    /**
     * This is the entry point of the application
     * 
     * @param args
     *            Command line arguments
     */
    public static void main(String[] args) {
        File inFile = new File(args[0]);
        int numRecords = (int)(inFile.length() / 4);

        try {
            BufferPool pool = new BufferPool(inFile, Integer.parseInt(args[1]));
            MaxHeap heap = new MaxHeap(pool, numRecords);

            Long start = System.currentTimeMillis();
            heap.sort();
            Long time = System.currentTimeMillis() - start;

            printRecords(args[0], (int)(inFile.length()));
            pool.writeToFile(args[2], time);

        }
        catch (IOException e) {
            System.exit(0);
        }
        catch (Exception e) {
            System.exit(0);
        }
    }


    /**
     * Call the generate method to generate a file. 
     * (For testing)
     * 
     * 
     * @param numRecords
     *            the number of records in the file
     */
    public static void generate(int numRecords) {
        ByteFileGenerator bfg = new ByteFileGenerator();
        try {
            bfg.generate(numRecords);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * This method checks the sorted file to make sure it is sorted. 
     * (For testing)
     */
    public static void checkFile() {
        try {
            CheckFile check = new CheckFile();

            if (check.checkFile()) {
                System.out.println("File is sorted");
            }
            else {
                System.out.println("File is not sorted");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Take a record array and print eight records per line.
     * 
     * @param fileName
     *            the name of the file
     * @param size
     *            the number of bytes in the file
     * @throws Exception throws an exception if the file is not found
     */
    public static void printRecords(String fileName, int size) 
                        throws Exception {
        DataInputStream in = new DataInputStream(new BufferedInputStream(
                            new FileInputStream(fileName)));
        int counter = 0;
        for (int i = 0; i < size; i += 4) {
            short key = in.readShort();
            short val = in.readShort();
            if (i % 4096 == 0) {
                if (counter % 8 == 0 && counter != 0) {
                    System.out.println();
                }
                
                System.out.print(key + " " + val + " ");
                counter++;
            }
        }
        System.out.println();    
        in.close();
    }
}
