public class week2
    {

        public static boolean isSameBST(int[] X, int[] Y, int n)
        {
            if (n == 0) {
                return true;
            }

            if (X[0] != Y[0]) {
                return false;
            }
            if (n == 1) {
                return true;
            }
            int[] leftX = new int[n-1];
            int[] rightX = new int[n-1];
            int[] leftY = new int[n-1];
            int[] rightY = new int[n-1];

            int k = 0, l = 0, m = 0, o = 0;
            for (int i = 1; i < n; i++)
            {
                if (X[i] < X[0]) {
                    leftX[k++] = X[i];
                }
                else {
                    rightX[l++] = X[i];
                }

                if (Y[i] < Y[0]) {
                    leftY[m++] = Y[i];
                }
                else {
                    rightY[o++] = Y[i];
                }
            }
            if (k != m) {
                return false;
            }

            if (l != o) {
                return false;
            }
            return isSameBST(leftX, leftY, k) && isSameBST(rightX, rightY, l);
        }

        public static void main(String[] args)
        {
            int[] X = { 15,25,20,22,30,18,10,8,9,12,6 };
            int[] Y = { 15, 10, 12, 8, 25, 30, 6, 20, 18, 9, 22 };

            if (X.length == Y.length && isSameBST(X, Y, X.length)) {
                System.out.println("true");
            }
            else {
                System.out.println("false");
            }
        }
    }

