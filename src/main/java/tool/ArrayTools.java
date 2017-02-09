package tool;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * Created by Alexis on 26/01/2017.
 */
public class ArrayTools {

    /**
     * Show a boolean array in a proper way.
     *
     * @param array
     */
    public static void showArray(boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("[" + i + "] => " + array[i]);
        }
    }

    /**
     * Show an int array in a proper way.
     *
     * @param array
     */
    public static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("[" + i + "] => " + array[i]);
        }
    }

    /**
     * Show an int array in a proper way.
     * @param array
     */
    public static void showArrayInLine(boolean[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print("[" + (array[i] ? "1" : "0") + "]");
        }
        System.out.println("");
    }


    /**
     * Show an int array in a proper way.
     *
     * @param array
     */
    public static void showArrayInLine(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]");
        }
        System.out.println("");
    }

    public static void showMap(LinkedHashMap<Integer, Integer> maps) {
        for (Integer node : maps.keySet()) {
            System.out.println("[" + node + "] => " + maps.get(node));
        }
    }
}
