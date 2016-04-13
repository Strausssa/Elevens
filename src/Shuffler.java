import java.lang.Math;

/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

    /**
     * The number of consecutive shuffle steps to be performed in each call
     * to each sorting procedure.
     */
    private static final int SHUFFLE_COUNT = 5;
    
    private static final int VALUE_COUNT = 8;

    /**
     * Tests shuffling methods.
     * @param args is not used.
     */
    public static void main(String[] args) {
    	int[] a = {1,1,1,3};
    	int[] b = {2,1,3,0};
    	
    	System.out.println(SHUFFLE_COUNT + " Consecutive Efficient Selection Shuffles:");
        int[] values2 = new int[VALUE_COUNT];
        for (int i = 0; i < values2.length; i++) {
            values2[i] = i;
            }
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            selectionShuffle(values2);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values2.length; k++) {
                System.out.printf(" %2d", values2[k]);
                // %2d outputs a decimal (integer) number that fills at least 2 character spaces, padded with empty space.
            }
            System.out.println();
        }
        System.out.println();
    	
    	System.out.println(SHUFFLE_COUNT + " Consecutive Perfect Shuffles:");
        int[] values1 = new int[VALUE_COUNT];
        for (int i = 0; i < values1.length; i++) {
            values1[i] = i;
            }
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            perfectShuffle(values1);
            System.out.print("  " + j + ":");
            for (int k = 0; k < values1.length; k++) {
                System.out.printf(" %2d", values1[k]);
            }
            System.out.println();
        }
        System.out.println();
        
        System.out.println("Permutations: " + arePermutations(a,b));
    }


    /**
     * Apply a "perfect shuffle" to the argument.
     * The perfect shuffle algorithm splits the deck in half, then interleaves
     * the cards in one half with the cards in the other.
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static void perfectShuffle(int[] values) {
        int[] half1 = new int[ VALUE_COUNT / 2 ];
        int[] half2 = new int[ VALUE_COUNT - VALUE_COUNT / 2 ];

        for( int i = 0; i < VALUE_COUNT / 2; i++ ) {
            half1[i] = values[i];
        }
        
        for( int i = 0; i < VALUE_COUNT - VALUE_COUNT / 2; i++ ) {
            half2[i] = values[ i + VALUE_COUNT / 2 ];
        }

        for( int i = 0; i < VALUE_COUNT / 2; i++ ) {
            values[ 2 * i ] = half2[i];
            values[ 2 * i + 1 ] = half1[i];
        }
    }

    /**
     * Apply an "efficient selection shuffle" to the argument.
     * The selection shuffle algorithm conceptually maintains two sequences
     * of cards: the selected cards (initially empty) and the not-yet-selected
     * cards (initially the entire deck). It repeatedly does the following until
     * all cards have been selected: randomly remove a card from those not yet
     * selected and add it to the selected cards.
     * An efficient version of this algorithm makes use of arrays to avoid
     * searching for an as-yet-unselected card.
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static void selectionShuffle(int[] values) {
        for( int i = VALUE_COUNT - 1; i >= 0; i-- ) {
            int random = (int)(Math.random() * i);
            int temporary = values[random];
            values[random] = values[i];
            values[i] = temporary;
        }
    }
    
    public static String flip() {
    	  if (Math.random() > 0.3333) {
    	    return "head";
    	  }
    	  else {
    	    return "tails";
    	  }
    	}

    public static boolean arePermutations(int[] a, int[] b){
        if (a.length == b.length) {
        	int test1 = 0;
        	for(int i = 0; i < a.length; i++){
                for(int k = 0; k < b.length; k++){
                    if(a[i] == b[k]){
                    	test1++;
                        if(test1 == ((a.length - 1) * 2)){
                        	return true;
                        }
                    }
                }

            }
          
        }
        return false;
        		
    }
}