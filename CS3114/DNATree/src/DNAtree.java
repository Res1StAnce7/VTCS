// On my honor:
// - I have not used source code obtained from another student,
// or any other unauthorized source, either modified or
// unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project
// with anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.
import java.text.DecimalFormat;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

/**
 * The main class for the DNA tree program which
 * reads in a file of DNA sequences and perform the
 * corresponding operations.
 * 
 * @author Siliang Zhang
 * @version 2022.06.04
 */
public class DNAtree {
    private static final char[] DNA_ARR = { 'A', 'C', 'G', 'T', 'E' };

    private static boolean removeFlag = true;

    private DNATreeNode root;

    private int counter;

    private final FlyweightNode fw;

    /**
     * This function will create a new flyweight object
     * and initialize the root node.
     * 
     * Variables Explanation:
     * counter is used to count the number of nodes traversed during searching.
     * fw is the flyweight node which is the placeholder.
     * root is the root node of the tree.
     * remopveFlag is used to help determine whether the node is moved or not.
     */
    public DNAtree() {
        this.counter = 1;
        this.fw = new FlyweightNode();
        this.root = this.fw;
    }


    /**
     * Reads in a file of DNA sequences and perform the operation.
     * 
     * @param args
     *            The file name
     * 
     * Variables Explanation:
     * tree is the tree object.
     * scanner is the scanner object which is used to read in the file.
     * line is the line of the file.
     * sequence is the sequence of the DNA.
     * level is the level of the node inserted.
     */
    public static void main(String[] args) {
        DNAtree tree = new DNAtree();
        
        try {
            Scanner scan = new Scanner(new File(args[0]));

            while (scan.hasNextLine()) {
                String line = scan.nextLine().replace("\t", "").trim();

                if (line.matches("^ *insert *[ACGT]+ *$")) {
                    String sequence = tree.getDNA(line);
                    int level = tree.insert(sequence);

                    if (level == -1) {
                        System.out.println("sequence " + sequence
                            + " already exists");
                    }
                    else {
                        System.out.println("sequence " + sequence
                            + " inserted at level " + level);
                    }
                }
                else if (line.matches("^ *remove *[ACGT]+ *$")) {
                    String sequence = tree.getDNA(line);
                    boolean empty = tree.isEmpty();
                    tree.remove(sequence);

                    if (!removeFlag || empty) {
                        System.out.println("sequence " + sequence
                            + " does not exist");
                        removeFlag = true;
                    }
                    else {
                        System.out.println("sequence " + sequence + " removed");
                        tree.removeHelper();
                        if (tree.isEmpty()) {
                            tree.setFlyweight();
                        }
                    }
                }
                else if (line.matches("^ *print *$")) {
                    System.out.println(tree.print(false, false));
                }
                else if (line.matches("^ *print *lengths *$")) {
                    System.out.println(tree.print(true, false));
                }
                else if (line.matches("^ *print *stats *$")) {
                    System.out.println(tree.print(false, true));
                }
                else if (line.matches("^ *search *[ACGT]+[$]? *$")) {
                    System.out.println(tree.search(tree.getDNA(line)));
                    tree.resetCounter();
                }
            }
            scan.close();
        }
        catch (IOException e) {
            System.exit(0);
        }
    }


    /**
     * The function will return to insert the DNA to the tree and
     * return the level of the node. If the DNA already exists,
     * it will return -1. Otherwise, it will return the level
     * 
     * @param seq
     *            The DNA sequence to be inserted
     * @return The level of the new node, -1 if unsuccessful
     * 
     * Variables Explanation:
     * node is the internal node to get inserted.
     */
    public int insert(String seq) {
        if (this.root instanceof FlyweightNode) {
            this.root = new LeafNode(seq, 0);
            return 0;
        }
        else if (this.root instanceof LeafNode) {
            if (((LeafNode)this.root).getSequence().equals(seq)) {
                return -1;
            }
            InternalNode node = new InternalNode(this.fw, 0);
            node.setEntry(this.root, ((LeafNode)this.root).getSequence().charAt(
                0));
            this.root.setLevel(1);
            this.root = node;
        }

        return recInsert(seq, (InternalNode)this.root);
    }


    /**
     * The function is the helper function for insert which will
     * recursively insert the DNA to the tree.
     *
     * @param seq
     *            The DNA sequence to be inserted
     * @param node
     *            The node
     * @return The level of the new node, -1 if unsuccessful
     * 
     * Variables Explanation:
     * pos is the position of the character in the DNA sequence.
     * child is the child node of the node.
     * str is the string of the DNA sequence.
     */
    private int recInsert(String seq, InternalNode node) {
        char pos = node.getLevel() < seq.length()
            ? seq.charAt(node.getLevel())
            : 'E';
        DNATreeNode child = node.getEntry(pos);

        if (child instanceof FlyweightNode) {
            node.setEntry(new LeafNode(seq, node.getLevel() + 1), pos);
            return node.getLevel() + 1;
        }
        else if (child instanceof LeafNode) {
            if (((LeafNode)child).getSequence().equals(seq)) {
                return -1;
            }

            String str = ((LeafNode)child).getSequence();
            InternalNode tempNode = new InternalNode(this.fw, child.getLevel());

            node.setEntry(tempNode, pos);
            pos = child.getLevel() < str.length()
                ? str.charAt(child.getLevel())
                : 'E';
            child.incrementLevel();
            tempNode.setEntry(child, pos);
            child = tempNode;
        }

        return recInsert(seq, (InternalNode)child);
    }


    /**
     * The function will take the DNA sequence and remove it from the tree.
     * 
     * @param seq
     *            The DNA sequence to be removed
     * @return The boolean result of the remove operation
     */
    public boolean remove(String seq) {
        if (this.root instanceof FlyweightNode) {
            return false;
        }
        else if (this.root instanceof LeafNode) {
            if (((LeafNode)this.root).getSequence().equals(seq)) {
                this.root = this.fw;
                return true;
            }
            removeFlag = false;
            return false;
        }

        return recRemove(seq, (InternalNode)this.root);
    }


    /**
     * The function is the helper function for insert which will
     * recursively try to remove the DNA from the tree.
     * 
     * @param seq
     *            The sequence to be removed
     * @param node
     *            The node
     * @return The boolean result of the remove operation
     * 
     * Variables Explanation:
     * silimar to the insert function.
     */
    private boolean recRemove(String seq, InternalNode node) {
        char pos = node.getLevel() >= seq.length()
            ? 'E'
            : seq.charAt(node.getLevel());
        DNATreeNode next = node.getEntry(pos);

        if (next instanceof FlyweightNode) {
            removeFlag = false;
            return false;
        }
        else if (next instanceof LeafNode) {
            if (((LeafNode)next).getSequence().equals(seq)) {
                node.setEntry(this.fw, pos);
                return true;
            }
            removeFlag = false;
            return false;
        }
        else if (recRemove(seq, (InternalNode)next) && ((InternalNode)next)
            .getCountOfFw() == 4) {
            for (char curr : DNA_ARR) {

                DNATreeNode child = ((InternalNode)next).getEntry(curr);
                if (child instanceof LeafNode) {
                    node.setEntry(child, pos);
                    child.decrementLevel();
                    return true;
                }
            }
        }
        return true;
    }


    /**
     * THe function will perform the corresponding print operation
     * based on the boolean values.
     * 
     * @param lengths
     *            The flag for whether or not to print the lengths
     * @param stats
     *            The flag for whether or not to print the statistics
     * @return The print for the entire tree
     */
    public String print(boolean lengths, boolean stats) {
        if (!(this.root instanceof FlyweightNode)) {
            System.out.print("tree dump:");
            return recPrint(this.root, 0, lengths, stats);
        }
        return "tree dump:\nE";
    }


    /**
     * This function is the helper method for the print method
     * which will recursively print the tree by performing a
     * preorder traversal.
     * 
     * @param node
     *            The node to be printed
     * @param lengths
     *            The flag for whether or not to print the lengths
     * @param stats
     *            The flag for whether or not to print the statistics
     * @param level
     *            The level of the node
     * @return The print for the entire tree
     * 
     * Variables Explanation:
     * opt is the print for the tree.
     * count is an int array used to store the number of each character
     * in the DNA sequence.
     * stats is an double array used to store the statistics of the sequence.
     */
    private String recPrint(DNATreeNode node, int level,
                            boolean lengths, boolean stats) {
        String opt = "\n";

        for (int i = 0; i < level; i++) {
            opt += "  ";
        }

        if (node instanceof FlyweightNode) {
            opt += "E";
        }
        else if (node instanceof LeafNode) {
            String seq = ((LeafNode)node).getSequence();
            opt += seq;

            if (lengths) {
                opt += " " + seq.length();
            }
            else if (stats) {
                int[] count = new int[4];
                double[] stat = new double[4];
                DecimalFormat df = new DecimalFormat("0.00");

                for (char c : seq.toCharArray()) {
                    switch (c) {
                        case 'A':
                            count[0]++;
                            break;
                        case 'C':
                            count[1]++;
                            break;
                        case 'G':
                            count[2]++;
                            break;
                        case 'T':
                            count[3]++;
                            break;
                        default:
                            break;
                    }
                }
                for (int i = 0; i < 4; i++) {
                    stat[i] = count[i] * 100.00 / seq.length();
                }

                opt += " A:" + df.format(stat[0]) + " ";
                opt += "C:" + df.format(stat[1]) + " ";
                opt += "G:" + df.format(stat[2]) + " ";
                opt += "T:" + df.format(stat[3]);
            }
        }
        else {
            opt += "I";
            opt += recPrint(((InternalNode)node).getEntry('A'), level + 1,
                lengths, stats);
            opt += recPrint(((InternalNode)node).getEntry('C'), level + 1,
                lengths, stats);
            opt += recPrint(((InternalNode)node).getEntry('G'), level + 1,
                lengths, stats);
            opt += recPrint(((InternalNode)node).getEntry('T'), level + 1,
                lengths, stats);
            opt += recPrint(((InternalNode)node).getEntry('E'), level + 1,
                lengths, stats);
        }
        return opt;
    }


    /**
     * The function will search the given sequence to check
     * if there is a partiall or complete match and return the result.
     * 
     * @param str
     *            The dna to be searched
     * @return the number of nodes visited and search results
     * 
     * Variables Explanation:
     * match is if the user require a exact match.
     * The others are similar to the above functions.
     */
    public String search(String str) {
        if (this.root instanceof FlyweightNode) {
            return "# of nodes visited: 1\nno sequence found";
        }

        String opt = "\n";
        boolean match = false;

        if (str.charAt(str.length() - 1) == '$') {
            match = true;
            str = str.substring(0, str.length() - 1);
        }

        if (this.root instanceof LeafNode) {
            String seq = ((LeafNode)root).getSequence();

            if (!match && str.length() <= seq.length() && seq.substring(0, str
                .length()).equals(str)) {
                opt += "sequence: " + seq;
            }
            else if (match && seq.equals(str)) {
                opt += "sequence: " + seq;
            }
            else {
                opt += "no sequence found";
            }
        }
        else {
            int i = 0;
            InternalNode node = (InternalNode)this.root;

            while (i < str.length()) {
                char c = str.charAt(i);
                if (node.getEntry(c) instanceof InternalNode) {
                    node = (InternalNode)node.getEntry(c);
                    this.counter++;
                }
                else {
                    break;
                }
                i++;
            }

            char pos = i < str.length() ? str.charAt(i) : 'E';
            DNATreeNode child = node.getEntry(pos);

            if (match) {
                if (child instanceof LeafNode && ((LeafNode)child).getSequence()
                    .equals(str)) {
                    opt += "sequence: " + ((LeafNode)child).getSequence();
                }
                else {
                    opt += "no sequence found";
                }
                this.counter++;
            }
            else {
                if (pos != 'E' && child instanceof LeafNode) {
                    String seq = ((LeafNode)child).getSequence();

                    if (seq.length() < str.length()) {
                        opt += "no sequence found";
                    }
                    else if (seq.substring(0, str.length()).equals(str)) {
                        opt += "sequence: " + ((LeafNode)child)
                            .getSequence();
                    }
                    this.counter++;
                }
                else if (pos == 'E') {
                    this.counter--;
                    opt += printLeaf(node);
                    opt = opt.substring(0, opt.length() - 1);
                }
                else {
                    opt += "no sequence found";
                    this.counter++;
                }
            }
        }
        return "# of nodes visited: " + this.counter + opt;
    }


    /**
     * The helper method for search
     * 
     * @param node
     *            The root
     * @return The string of the leaf node
     * 
     * Variables Explanation:
     * Similiar to the above functions.
     */
    private String printLeaf(InternalNode node) {
        String opt = "";
        this.counter++;

        if (node.getEntry('A') instanceof LeafNode) {
            opt += "sequence: " + ((LeafNode)node.getEntry('A')).getSequence()
                + "\n";
            this.counter++;
        }
        else if (node.getEntry('A') instanceof InternalNode) {
            opt += printLeaf((InternalNode)node.getEntry('A'));
        }
        else {
            this.counter++;
        }

        if (node.getEntry('C') instanceof LeafNode) {
            opt += "sequence: " + ((LeafNode)node.getEntry('C')).getSequence()
                + "\n";
            this.counter++;
        }
        else if (node.getEntry('C') instanceof InternalNode) {
            opt += printLeaf((InternalNode)node.getEntry('C'));
        }
        else {
            this.counter++;
        }

        if (node.getEntry('G') instanceof LeafNode) {
            opt += "sequence: " + ((LeafNode)node.getEntry('G')).getSequence()
                + "\n";
            this.counter++;
        }
        else if (node.getEntry('G') instanceof InternalNode) {
            opt += printLeaf((InternalNode)node.getEntry('G'));
        }
        else {
            this.counter++;
        }

        if (node.getEntry('T') instanceof LeafNode) {
            opt += "sequence: " + ((LeafNode)node.getEntry('T')).getSequence()
                + "\n";
            this.counter++;
        }
        else if (node.getEntry('T') instanceof InternalNode) {
            opt += printLeaf((InternalNode)node.getEntry('T'));
        }
        else {
            this.counter++;
        }

        if (node.getEntry('E') instanceof LeafNode) {
            opt += "sequence: " + ((LeafNode)node.getEntry('E')).getSequence()
                + "\n";
        }
        this.counter++;

        return opt;
    }


    /**
     * The function will reset the counter to 0
     */
    public void resetCounter() {
        this.counter = 1;
    }


    /**
     * Check if the tree is empty
     * 
     * @return The boolean result
     */
    public boolean isEmpty() {
        if (this.root instanceof FlyweightNode) {
            return true;
        }
        else if (this.root instanceof LeafNode) {
            return false;
        }

        return ((InternalNode)this.root).getCountOfFw() == 5;
    }


    /**
     * Set the root to the flyweight node
     */
    public void setFlyweight() {
        this.root = this.fw;
    }


    /**
     * This function will return the DNA sequence based on
     * the given string.
     * 
     * @param line
     *            The string
     * @return The DNA sequence
     */
    public String getDNA(String line) {
        Scanner sc = new Scanner(line.trim());
        sc.next();
        return sc.next();
    }


    /**
     * This function will test if the children of the root are four
     * flyweight nodes and one leaf node. Then it will set the root
     * to the leaf node.
     * 
     * @return The boolean result
     */
    public boolean removeHelper() {
        if (this.root instanceof InternalNode && ((InternalNode)this.root)
            .getCountOfFw() == 4 && (((InternalNode)this.root)
            .getCountOfLeaf()) == 1) {
            for (char c : DNA_ARR) {
                if (((InternalNode)this.root).getEntry(c) instanceof LeafNode) {
                    this.root = ((InternalNode)this.root).getEntry(c);
                    return true;
                }
            }
        }
        return false;
    }
}
