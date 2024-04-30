public class Homework {

    // Private function that returns an integer
    private int privateFunction() {
        int result_to_print = 100; 
        return result_to_print;
    }

    // Protected function that returns nothing
    protected void protectedFunction(String text, int number) {
    }


    // Function to count occurance of givven pattern  in given  array string
    public static int countOccurrences(String[] input_string_array, String pattern) {
        int totalCount = 0;
        for (String member : input_string_array) {
            totalCount += countOccurrencesInMemberString(member, pattern);
        }
        return totalCount;
    }

    // Function to count occurrences of a given pattern in each member string of given array string
    private static int countOccurrencesInMemberString(String str, String pattern) {
        int count = 0;
        int index = -1;
        while ((index = str.indexOf(pattern, index + 1)) != -1) {
            // Increment count for each occurrence found
            count++;
        }
        return count;
    }

     // Function to merge two arrays and remove duplicates
     public static int[] mergeAndRemove(int[] array_1, int[] array_2) {
        int mergedArrayLength = array_1.length + array_2.length;
        
        int[] mergedArray = new int[mergedArrayLength];
        
        int index = 0;
        
        for (int num : array_1) {
            if (!isPresent(mergedArray, index, num)) {
                mergedArray[index++] = num;
            }
        }
        
        for (int num : array_2) {
            if (!isPresent(mergedArray, index, num)) {
                mergedArray[index++] = num;
            }
        }

        // Resizing the resultant array
        int[] result = new int[index];
        
        for( int i=0; i < index ; i++){
            result[i]= mergedArray[i];
        }
        
        return result;
        
        
           }
    
    //  Function to check if the number is already present in the array
    private static boolean isPresent(int[] array, int length, int value) {
        for (int i = 0; i < length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }


     // Function to remove pairs of patterns from a string
     public static String pairRemoval(String text, String leftPattern, String rightPattern) {
        char left = leftPattern.charAt(0);
        char right = rightPattern.charAt(0);

        char[] chars = text.toCharArray();

        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == left) {
                for (int j=i+1 ; j<chars.length; j++){
                    if(chars[j]== right){
                        chars[i] = ' ';
                        chars[j] = ' ';
                        break;

                    }
                }
                
            }
           
        }

        // Combine and remove empty elements
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            if (c != ' ') {
                result.append(c);
            }
        }

        return result.toString();
    }


    // Matrix multiplication

    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowA = matrixA.length;
        int colA = matrixA[0].length;
        int colB = matrixB[0].length;

        int[][] result = new int[rowA][colB];

        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                for (int k = 0; k < colA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return result;
    }



    public static void main(String[] args) {
        
        // Calling function that returns integer
        System.out.println("Private Function");

        Homework private_function = new Homework();
        System.out.println("Result from Private function: " + private_function.privateFunction());
        System.out.println("--------------------------");


        // Calling protected Function
        System.out.println("Protected Function");

        Homework protected_funcgtion = new Homework();
        protected_funcgtion.protectedFunction("Hello", 100);
        System.out.println("--------------------------");


        // Calling occurance countig function
        System.out.println("Pattern Count");

        String[] array = {"prashidda", "baruwal", "feifaahr"};
        String pattern = "a";
        int occurrences = countOccurrences(array, pattern);
        System.out.println("Total occurrences: " + occurrences); 
        System.out.println("--------------------------");



        // Merging array
        System.out.println("Merge array and remove duplicates");

        int[] array_1 = {1, 2, 3};
        int[] array_2 = {2, 3, 4};
        int[] mergedArray = mergeAndRemove(array_1, array_2);
        for (int num : mergedArray) {
            System.out.println(num + " "); 
          
        }
        System.out.println("--------------------------");



          // Using pattern removal
          System.out.println("Pattern Removal ");

        String text = "{{Muscat}}{ }mecum tollgate}poultry quarrymen pantheon asteria";
        String leftPattern = "{";
        String rightPattern = "}";
        String patternremoved = pairRemoval(text, leftPattern, rightPattern);
        System.out.println(patternremoved);
        System.out.println("--------------------------");


    




            // Example usage
            int[][] matrixA = {{55, 30, 12}, {66, 86, 29}, {89, 90, 38}};
            int[][] matrixB = {{23, 84}, {11, 63}, {11, 21}};
            int[][] resultmatrix = multiplyMatrices(matrixA, matrixB);

            System.out.println("Matrix Multiplication");

            for (int[] row : resultmatrix) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
            System.out.println("--------------------------");




        
        
    }
}
