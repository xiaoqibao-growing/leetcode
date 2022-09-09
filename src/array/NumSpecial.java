package array;

public class NumSpecial {
    public int numSpecial(int[][] mat) {
        int rowLenght = mat.length;
        int result = 0;
        int columnLength = mat[0].length;

        for (int i = 0; i < rowLenght; i++) {
            int[] temp = mat[i];
            for (int j = 0; j < columnLength; j++) {
                if (temp[j] == 1) {
                    boolean flag = true;
                    for (int z = 0; z < rowLenght; z++) {
                        if (mat[z][j] == 1 && z != i) {
                            flag = false;
                        }
                    }

                    if (flag) {
                        for (int k = 0; k < columnLength; k++) {
                            if (k != j && temp[k] == 1) {
                                flag = false;
                            }
                        }
                    }

                    if (flag) {
                        result++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1, 0};
        int[] b = new int[] {0, 0};
        int[] c = new int[] {0, 1};

        int[][] data = new int[3][];
        data[0] = a;
        data[1] = b;
        data[2] = c;

        NumSpecial numSpecial = new NumSpecial();
        System.out.println(numSpecial.numSpecial(data));
    }
}
