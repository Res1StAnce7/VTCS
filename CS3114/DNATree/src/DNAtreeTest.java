import student.TestCase;

/**
 * The test class of DNATree.
 * 
 * @author Siliang Zhang
 * @version 2022.06.04
 */
public class DNAtreeTest extends TestCase {
    private DNAtree tree;

    /**
     * Initializes the tree.
     */
    public DNAtreeTest() {
        this.tree = new DNAtree();
    }


    /**
     * The test for insert.
     */
    public void testInsert() {

        int result = this.tree.insert("ACGT");
        assertEquals(result, 0);

        result = this.tree.insert("ACGT");
        assertEquals(result, -1);

        result = this.tree.insert("AAAA");
        assertEquals(result, 2);

        result = this.tree.insert("AA");
        assertEquals(result, 3);

        result = this.tree.insert("AAACCCCGGTGAAAACGTA");
        assertEquals(result, 4);

        result = this.tree.insert("ACTGGGAA");
        assertEquals(result, 3);

        this.tree.remove("ACGT");

        result = this.tree.insert("ACCTT");
        assertEquals(result, 3);

        result = this.tree.insert("ACTTA");
        assertEquals(result, 4);

        result = this.tree.insert("TATA");
        assertEquals(result, 1);

        result = this.tree.insert("TCG");
        assertEquals(result, 2);

        result = this.tree.insert("TCG");
        assertEquals(result, -1);
    }


    /**
     * The test for remove.
     */
    public void testRemove() {
        this.tree.insert("ACGT");
        this.tree.insert("AAAA");
        this.tree.insert("AA");
        this.tree.insert("AAACCCCGGTGAAAACGTA");
        this.tree.insert("ACTGGGAA");
        this.tree.remove("ACGT");
        this.tree.insert("ACCTT");
        this.tree.insert("ACTTA");
        this.tree.insert("TATA");
        this.tree.insert("TCG");

        boolean result = this.tree.remove("ACGT");
        assertEquals(result, true);

        result = this.tree.remove("AAAA");
        assertEquals(result, true);

        result = this.tree.remove("AA");
        assertEquals(result, true);

        result = this.tree.remove("AAACCCCGGTGAAAACGTA");
        assertEquals(result, true);

        result = this.tree.remove("ACTGGGAA");
        assertEquals(result, true);

        result = this.tree.remove("ACCTT");
        assertEquals(result, true);

        result = this.tree.remove("ACTTA");
        assertEquals(result, true);

        result = this.tree.remove("TATA");
        assertEquals(result, true);

        result = this.tree.remove("TCG");
        assertEquals(result, true);

        result = this.tree.remove("TCG");
        assertEquals(result, false);

        this.tree.insert("TCG");
        result = this.tree.remove("TCG");
        assertEquals(result, true);

        this.tree = new DNAtree();
        result = this.tree.remove("TCG");
        assertEquals(result, false);

        this.tree.insert("TCG");
        result = this.tree.remove("TCCG");
        assertEquals(result, false);

        result = this.tree.remove("TCG");
        assertEquals(result, true);

        result = this.tree.remove("ACTTA");
        assertEquals(result, false);
    }


    /**
     * The test for print.
     */
    public void testPrint() {
        String result = this.tree.print(false, false);
        assertEquals(result, "tree dump:\nE");

        this.tree.insert("ACGT");
        result = this.tree.print(false, false);
        System.out.println(result);
        assertEquals(result, "\nACGT");

        this.tree.insert("AAAA");
        this.tree.insert("AA");
        this.tree.insert("AAACCCCGGTGAAAACGTA");
        this.tree.insert("ACTGGGAA");
        this.tree.remove("ACGT");
        this.tree.insert("ACCTT");
        this.tree.insert("ACTTA");
        this.tree.insert("TATA");
        this.tree.insert("TCG");

        result = this.tree.print(false, false);
        assertEquals(result, "\n" + "I\n" + "  I\n" + "    I\n" + "      I\n"
            + "        AAAA\n" + "        AAACCCCGGTGAAAACGTA\n" + "        E\n"
            + "        E\n" + "        E\n" + "      E\n" + "      E\n"
            + "      E\n" + "      AA\n" + "    I\n" + "      E\n"
            + "      ACCTT\n" + "      E\n" + "      I\n" + "        E\n"
            + "        E\n" + "        ACTGGGAA\n" + "        ACTTA\n"
            + "        E\n" + "      E\n" + "    E\n" + "    E\n" + "    E\n"
            + "  E\n" + "  E\n" + "  I\n" + "    TATA\n" + "    TCG\n"
            + "    E\n" + "    E\n" + "    E\n" + "  E");

        this.tree = new DNAtree();
        this.tree.insert("AAAA");
        this.tree.insert("AA");
        this.tree.insert("AAACCCCGGTGAAAACGTA");
        this.tree.insert("ACTGGGAA");
        this.tree.remove("AAAA");
        this.tree.remove("AA");
        this.tree.remove("AAACCCCGGTGAAAACGTA");

        result = this.tree.print(false, false);

        assertEquals(result, "\nI\n" + "  ACTGGGAA\n" + "  E\n" + "  E\n"
            + "  E\n" + "  E");
    }


    /**
     * The test for search.
     */
    public void testSearch() {
        String result = this.tree.search("ACGT");
        assertEquals(result, "# of nodes visited: 1\nno sequence found");

        this.tree.insert("ACGT");
        result = this.tree.search("ACGT");
        assertEquals(result, "# of nodes visited: 1\nsequence: ACGT");

        this.tree.insert("AAAA");
        this.tree.insert("AA");
        this.tree.insert("AAACCCCGGTGAAAACGTA");
        this.tree.insert("ACTGGGAA");
        this.tree.remove("ACGT");
        this.tree.insert("ACCTT");
        this.tree.insert("ACTTA");
        this.tree.insert("TATA");
        this.tree.insert("TCG");

        result = this.tree.search("AAAA$");
        assertEquals(result, "# of nodes visited: 5\nsequence: AAAA");
        this.tree.resetCounter();

        result = this.tree.search("AA");
        assertEquals(result, "# of nodes visited: 13\nsequence: AAAA\n"
            + "sequence: AAACCCCGGTGAAAACGTA\n" + "sequence: AA");
        this.tree.resetCounter();

        result = this.tree.search("ACGT$");
        assertEquals(result, "# of nodes visited: 4\nno sequence found");
    }


    /**
     * The test for main.
     */
    public void testMain() {
        String[] args = new String[1];
        args[0] = "test.txt";
        DNAtree.main(args);
        String output = systemOut().getHistory();
        assertEquals("sequence ACGT inserted at level 0\n"
            + "sequence AAAA inserted at level 2\n"
            + "sequence AA inserted at level 3\n"
            + "sequence AAACCCCGGTGAAAACGTA inserted at level 4\n"
            + "sequence ACTGGGAA inserted at level 3\n"
            + "sequence ACGT does not exist\n"
            + "sequence ACCTT inserted at level 3\n"
            + "sequence ACTTA inserted at level 4\n" + "tree dump:\n" + "I\n"
            + "  I\n" + "    I\n" + "      I\n" + "        AAAA\n"
            + "        AAACCCCGGTGAAAACGTA\n" + "        E\n" + "        E\n"
            + "        E\n" + "      E\n" + "      E\n" + "      E\n"
            + "      AA\n" + "    I\n" + "      E\n" + "      ACCTT\n"
            + "      E\n" + "      I\n" + "        E\n" + "        E\n"
            + "        ACTGGGAA\n" + "        ACTTA\n" + "        E\n"
            + "      E\n" + "    E\n" + "    E\n" + "    E\n" + "  E\n"
            + "  E\n" + "  E\n" + "  E\n"
            + "sequence TATA inserted at level 1\n"
            + "sequence TCG inserted at level 2\n" + "tree dump:\n" + "I\n"
            + "  I\n" + "    I\n" + "      I\n" + "        AAAA 4\n"
            + "        AAACCCCGGTGAAAACGTA 19\n" + "        E\n" + "        E\n"
            + "        E\n" + "      E\n" + "      E\n" + "      E\n"
            + "      AA 2\n" + "    I\n" + "      E\n" + "      ACCTT 5\n"
            + "      E\n" + "      I\n" + "        E\n" + "        E\n"
            + "        ACTGGGAA 8\n" + "        ACTTA 5\n" + "        E\n"
            + "      E\n" + "    E\n" + "    E\n" + "    E\n" + "  E\n"
            + "  E\n" + "  I\n" + "    TATA 4\n" + "    TCG 3\n" + "    E\n"
            + "    E\n" + "    E\n" + "  E\n" + "tree dump:\n" + "I\n" + "  I\n"
            + "    I\n" + "      I\n"
            + "        AAAA A:100.00 C:0.00 G:0.00 T:0.00\n"
            + "        AAACCCCGGTGAAAACGTA A:42.11 C:26.32 G:21.05"
            + " T:10.53\n" + "        E\n" + "        E\n" + "        E\n"
            + "      E\n" + "      E\n" + "      E\n"
            + "      AA A:100.00 C:0.00 G:0.00 T:0.00\n" + "    I\n"
            + "      E\n" + "      ACCTT A:20.00 C:40.00 G:0.00 T:40.00\n"
            + "      E\n" + "      I\n" + "        E\n" + "        E\n"
            + "        ACTGGGAA A:37.50 C:12.50 G:37.50 T:12.50\n"
            + "        ACTTA A:40.00 C:20.00 G:0.00 T:40.00\n" + "        E\n"
            + "      E\n" + "    E\n" + "    E\n" + "    E\n" + "  E\n"
            + "  E\n" + "  I\n" + "    TATA A:50.00 C:0.00 G:0.00 T:50.00\n"
            + "    TCG A:0.00 C:33.33 G:33.33 T:33.33\n" + "    E\n" + "    E\n"
            + "    E\n" + "  E\n" + "# of nodes visited: 5\n"
            + "sequence: AAAA\n" + "# of nodes visited: 13\n"
            + "sequence: AAAA\n" + "sequence: AAACCCCGGTGAAAACGTA\n"
            + "sequence: AA\n" + "# of nodes visited: 4\n"
            + "no sequence found\n", output);
    }


    /**
     * The test for the rempve Helper.
     */
    public void testRemoveHelper() {
        this.tree = new DNAtree();
        this.tree.insert("AAAA");
        this.tree.insert("AA");
        this.tree.insert("AAACCCCGGTGAAAACGTA");
        this.tree.insert("ACTGGGAA");

        boolean result = this.tree.removeHelper();
        assertEquals(result, false);

        this.tree.remove("AAAA");
        this.tree.remove("AA");
        this.tree.remove("AAACCCCGGTGAAAACGTA");
        result = this.tree.removeHelper();
        assertEquals(result, true);

        this.tree = new DNAtree();
        this.tree.insert("CAAA");
        this.tree.insert("CA");
        this.tree.insert("CAACCCCGGTGAAAACGTA");
        this.tree.insert("CCTGGGAA");

        result = this.tree.removeHelper();
        assertEquals(result, false);

        this.tree.remove("CAAA");
        this.tree.remove("CA");
        this.tree.remove("CAACCCCGGTGAAAACGTA");
        result = this.tree.removeHelper();
        assertEquals(result, true);

        this.tree = new DNAtree();
        this.tree.insert("GAAA");
        this.tree.insert("GA");
        this.tree.insert("GAACCCCGGTGAAAACGTA");
        this.tree.insert("GCTGGGAA");

        result = this.tree.removeHelper();
        assertEquals(result, false);

        this.tree.remove("GAAA");
        this.tree.remove("GA");
        this.tree.remove("GAACCCCGGTGAAAACGTA");
        result = this.tree.removeHelper();
        assertEquals(result, true);

        this.tree = new DNAtree();
        this.tree.insert("TAAA");
        this.tree.insert("TA");
        this.tree.insert("TAACCCCGGTGAAAACGTA");
        this.tree.insert("TCTGGGAA");

        result = this.tree.removeHelper();
        assertEquals(result, false);

        this.tree.remove("TAAA");
        this.tree.remove("TA");
        this.tree.remove("TAACCCCGGTGAAAACGTA");
        result = this.tree.removeHelper();
        assertEquals(result, true);
    }


    /**
     * The test for isEmpty.
     */
    public void testIsEmpty() {
        this.tree = new DNAtree();
        boolean result = this.tree.isEmpty();
        assertEquals(result, true);

        this.tree.insert("AAAA");
        result = this.tree.isEmpty();
        assertEquals(result, false);
    }


    /**
     * The test for getDNA.
     */
    public void testGetDNA() {
        String result = this.tree.getDNA("AAAA ABCD");
        assertEquals(result, "ABCD");
    }
}
