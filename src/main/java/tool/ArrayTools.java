package tool;

/**
 * Created by Alexis on 26/01/2017.
 */
public class ArrayTools {

    /**
     * Show a boolean array in a proper way.
     * @param array
     */
    public static void showArray(boolean[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println("[" + i + "] => " + array[i]);
        }
    }
}
