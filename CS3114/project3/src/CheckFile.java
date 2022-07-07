import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;

/**
 * CheckFile: Check to see if a file is sorted. This assumes that each record is
 * a pair of short ints with the first short being the key value
 *
 * @author CS Staff
 * @version 03/15/2016
 */

public class CheckFile {
    /**
     * This method checks a file to see if it is properly sorted.
     *
     * @param filename
     *            a string containing the name of the file to check
     * @return true if the file is sorted, false otherwise
     * @throws Exception
     *             either and IOException or a FileNotFoundException
     */
    public boolean checkFile() throws Exception {
        boolean isError = false;
        DataInputStream in = new DataInputStream(new BufferedInputStream(
            new FileInputStream("input.dat")));

        short key2 = in.readShort();
        short value2 = in.readShort();
        int reccnt = 0;
        try {
            while (true) {
                short key1 = key2;
                short value1 = value2;
                reccnt++;
                key2 = in.readShort();
                value2 = in.readShort();

                if (key1 > key2) {
                    //System.out.println("Reccnt: " + reccnt + " key1: " + key1 + " key2: " + key2);
                    isError = true;
                }
                //System.out.println("Reccnt: " + reccnt + " key1: " + key1 + " value1: " 
                //+ value1 + " key2: " + key2+ " value2: " + value2);  
            }
        }
        catch (EOFException e) {
            System.out.println(reccnt + " records processed");
        }
        in.close();
        return !isError;
    }



    /**
     * Print the binary file which is mainly used for debugging.
     * @param file the file to print.
     * @throws Exception  either and IOException or a FileNotFoundException
     */
    public void printFile(String file) throws Exception {
        DataInputStream in = new DataInputStream(new BufferedInputStream(
            new FileInputStream(file)));
        int reccnt = 0;
        try {
            while (true) {
                short key1 = in.readShort();
                short key2 = in.readShort();
                System.out.println("key: " + key1 + " val: " + key2);
                reccnt++;
            }
        }
        catch (EOFException e) {
            System.out.println(reccnt + " records processed");
        }
        in.close();   
    }


}
