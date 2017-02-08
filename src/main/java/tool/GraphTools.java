package tool;

/**
 * Created by Alexis on 13/01/2017.
 */
public final class GraphTools {
    /**
     * Show a Matrix in a proper way
     * @param matrix Matrix to show
     */
    public static void showMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            System.out.print("| ");
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j]);
                System.out.print(" | ");
            }
            System.out.println("");
        }
    }

    /**
     * Generate graph data's adjacent matrix with random value
     * @param m Graph arc's number
     * @param n Graph node's number
     * @param s If option's set adjacent matrix will be symetric
     * @return The adjacent matrix
     */
    public static int[][] generateGraphData(int m, int n, boolean s){
        int[][] matrix =  new int[n][n];
        int nbArcInit = 0;
        while(nbArcInit < m){
            int randRow = (int)(Math.random() * n);
            int randCol = (int)(Math.random() * n);
            if(randRow != randCol && matrix[randRow][randCol] != 1){
                matrix[randRow][randCol] = 1;
                nbArcInit++;
                if(s){
                    matrix[randCol][randRow] = 1;
                    nbArcInit++;
                }
            }
        }
        return matrix;
    }

    /**
     * Symetries a matrix.
     * @param matrix The matrix to symetries
     * @return The symetric matrix.
     */
    public static int[][] symetriesMatrix(int[][] matrix){
        int[][] symMatrix = matrix.clone();
        for(int i = 0; i < symMatrix.length; i++) {
            for (int j = 0; j < symMatrix.length; j++) {
                if(symMatrix[i][j] == 1) symMatrix[j][i] = 1;
            }
        }
        return symMatrix;
    }

    /**
     * Test if a matrix is symetric.
     * @param matrix The matrix to test.
     * @return True if the matrix's symetric, false otherwise.
     */
    public static boolean isSymetricMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] == 1 && matrix[j][i] != 1) return false;
            }
        }
        return true;
    }

    public static int[][] generateGraphWeightData(int[][] matrix, int range, boolean acceptNegatif){
        int[][] weightMatrix = matrix.clone();
        for(int i = 0; i < weightMatrix.length; i++) {
            for (int j = 0; j < weightMatrix.length; j++) {
                if(weightMatrix[i][j] == 1) {
                    weightMatrix[i][j] = generateRandomNumber(range, acceptNegatif);
                }
            }
        }
        return weightMatrix;
    }

    private static int generateRandomNumber(int range, boolean acceptNegatif){
        int pNumber = (int)(Math.random() * range);
        return acceptNegatif ? pNumber * (Math.random() > 0.5 ? 1 : -1) : pNumber;
    }
}
