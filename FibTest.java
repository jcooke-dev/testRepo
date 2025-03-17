
import java.util.Scanner;


public class FibTest {

    static long lNumCalls = 0;

    public static void main(String[] args) {

        Scanner inScan = new Scanner( System.in );

        long lTimeStart;
        long lTimeEnd;

        boolean bQuit = false;

        do {
            System.out.print("Enter an int (or [q] to quit): ");

            String strLine = inScan.nextLine();

            if( strLine.equalsIgnoreCase( "q" ) ) { // provide a graceful exit
                bQuit = true;
            }
            else {

                try {

                    int nUse = Integer.parseInt(strLine);

                    if( nUse < 52 ) {
                        lTimeStart = System.nanoTime();
                        lNumCalls = 0;
                        System.out.println("Fibonacci (recursive) for " + nUse + ": " + calcFibRecursive(nUse));
                        lTimeEnd = System.nanoTime();
                        System.out.println("\tnum recursive function calls: " + lNumCalls);
                        System.out.println("\taverage function call time (ns): " + (lTimeEnd - lTimeStart) / lNumCalls);
                    }
                    else {
                        System.out.println("Calculating the Fibonacci number recursively for this input would take WAY too much time, so not doing it!");
                    }

                    System.out.println("Fibonacci (iterative) for " + nUse + ": " + calcFibIterative(nUse) + "\n");

                }
                catch(NumberFormatException ex) {
                    bQuit = true;
                }
            }

        } while(!bQuit);
    }

    static long calcFibRecursive(long lInput) {

        lNumCalls++;

        if( lInput < 1 ) { // error input
            return 0;
        }
        else if( (lInput == 1) || (lInput == 2) ) {
            return 1;
        }
        else {
            return calcFibRecursive(lInput - 1) + calcFibRecursive(lInput - 2);
        }
    }

    static long calcFibIterative(long lInput) {

        if( lInput < 1 ) { // error input
            return 0;
        }
        else if( (lInput == 1) || (lInput == 2) ) {
            return 1;
        }
        else {
            long lPrev = 1;
            long lCur = 1;

            for (int nCount = 2; nCount < lInput; nCount++) {
                long lTemp = lCur;
                lCur = lCur + lPrev;
                lPrev = lTemp;
            }

            return lCur;
        }
    }

}