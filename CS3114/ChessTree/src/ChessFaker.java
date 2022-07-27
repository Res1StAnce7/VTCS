import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

// DO NOT MODIFY THIS FILE.
// WEBCAT'S REFERENCE TESTS WILL EXPECT THIS EXACT EXECUTION

/**
 * @author Patrick Sullivan
 * @version 0.2.0
 */
public class ChessFaker {

    static final char[] PIECES = "KQRRBBNNPPPP".toCharArray();
    static final char[] RANKS = "12345678".toCharArray();
    static final char[] FILES = "abcdefgh".toCharArray();
    private static final Charset CSET = StandardCharsets.UTF_8;
    private static final int MIN_ASCII = (int)'A';
    private static final int MAX_ASCII = (int)'z';

    /**
     * For a given board state, get every possible valid move
     * 
     * @param board
     *            The current board state
     * 
     * @return
     *         An array of strings, each being a valid move.
     *         There are always between 1 and 12 moves.
     */
    public static String[] getNextMoves(String board) {
        Random rand = getRandomFor(board);
        int numNewMoves = rand.nextInt(11) + 1;
        String[] nextMoves = new String[numNewMoves];

        for (int i = 0; i < numNewMoves; i++) {
            char piece = PIECES[rand.nextInt(PIECES.length)];
            char rank = RANKS[rand.nextInt(RANKS.length)];
            char file = FILES[rand.nextInt(FILES.length)];
            char[] moveChars = { piece, file, rank };
            String newMove = new String(moveChars);
            boolean isUniqueMove = true;
            for (int j = i - 1; j > 0; j--) {
                if (newMove.equals(nextMoves[j])) {
                    isUniqueMove = false;
                    break;
                }
            }
            if (isUniqueMove) {
                nextMoves[i] = newMove;
            }
            else {
                i--;
            }
        }
        return nextMoves;
    }


    /**
     * From a starting board state and planned move, get the next board state
     * 
     * @param board
     *            The current board state
     * @param move
     *            The planned move to make
     * 
     * @return
     *         The next board state
     */
    public static String getNextBoard(String board, String move) {
        Random r = getRandomFor(move);
        int numChanges = r.nextInt(2) + 1;
        int[] boardInts = stringToInts(board);
        for (int change = 0; change < numChanges; change++) {
            int pos = r.nextInt(boardInts.length);
            boardInts[pos] += r.nextInt(100) - 50;
        }
        String newBoard = intsToString(boardInts);
        return newBoard;
    }


    /**
     * From a starting board state and planned move, calculate change in fitness
     * 
     * @param board
     *            The board state
     * @return
     *         The fitness of the CURRENT board
     */
    public static int getFitness(String board) {
        byte[] bArr = board.getBytes(CSET);
        int fit = 0;
        int w = 28; // width
        int h = 1; // height
        for (int i = 0; i < 15; i++) {
            int b = Math.abs(bArr[i % bArr.length]);
            int triWave = h * (Math.abs(((b + w) % (w * 2)) - w) - w / 2);
            fit += triWave;
            // magic numbers of chess-fakery
        }
        return fit;
    }

    /**
     * Private methods below here
     */
    
    // Here is a weak (but fast) pseudo-random generator.
    private static Random getRandomFor(String seedStr) {
        long hash = seedStr.hashCode();
        return new Random(hash);
    }


    private static int[] stringToInts(String str) {
        char[] asChars = str.toCharArray();
        int[] asInts = new int[asChars.length];
        for (int i = 0; i < asChars.length; i++) {
            asInts[i] = (int)asChars[i];
        }
        return asInts;
    }


    private static String intsToString(int[] ints) {
        final int range = MAX_ASCII - MIN_ASCII;
        char[] asChars = new char[ints.length];
        for (int i = 0; i < ints.length; i++) {
            int cc = ints[i];
            while (cc < MIN_ASCII)
                cc += range;
            while (cc > MAX_ASCII)
                cc -= range;
            asChars[i] = (char)cc;
            // difficult to improve without breaking transitive...
        }
        return String.valueOf(asChars);
    }

}
