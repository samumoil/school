public class Main {
        static int i = 0;
        static int j = 0;
        public static void main(String [] args) {
                int i = 2;
                int j = 3;
                {
                        j = 1;
                        System.out.println("i + j on " + i + j);
                }
                int k = i + j;
                System.out.println("k on " + k);
                System.out.println("j on " + j);
        }
}