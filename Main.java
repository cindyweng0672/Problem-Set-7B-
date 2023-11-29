import java.util.*;

/**
 * Problem Set 7B
 *
 * Cindy Weng
 * Nov. 27
 */
public class Main
{
    public static void main(String[] args){
        //sieveOfEratosthenes(100);
        //goldbachConjecture(100);
        ArrayList<Integer> lst1=new ArrayList();
        ArrayList<Integer> lst2=new ArrayList();
        lst1.add(1);
        lst1.add(3);
        lst2.add(6);
        lst2.add(7);
        lst2.add(7);

        addingBigInts(lst1, lst2);
    }

    public static ArrayList<Integer> sieveOfEratosthenes(int n){
        ArrayList<Integer> lst=new ArrayList<Integer>();
        for(int i=2; i<n+1; i++){
            lst.add(i);
        }

        for(int i=0; i<lst.size(); i++){
            int key=lst.get(i);
            for(int j=i+1; j<lst.size(); j++){
                if(lst.get(j)%key==0){
                    lst.remove(j);
                    j--;
                }
            }
        }

        System.out.println("Prime Numbers: ");
        for(int i=0; i<lst.size(); i++){
            System.out.println(lst.get(i)+" ");
        }

        return lst;
    }

    public static void goldbachConjecture(int n){
        ArrayList<Integer> lst=sieveOfEratosthenes(n);

        for(int i=0; i<lst.size(); i++){
            for(int j=i+1; j<lst.size(); j++){
                if((n-lst.get(i))==lst.get(j)){
                    System.out.println(n+"="+lst.get(i)+"+"+lst.get(j));
                    return;
                }
            }
        }
    }

    public static void addingBigInts(ArrayList<Integer> bi1, ArrayList<Integer> bi2) {
        Collections.reverse(bi1);
        Collections.reverse(bi2);

        if (bi1.size() < bi2.size()) {
            adding(bi2, bi1);
        } else {
            adding(bi1, bi2);
        }

    }

    public static void adding(ArrayList<Integer> bi1, ArrayList<Integer> bi2) {
        // bi1 is longer and bi2 is shorter
        int min = bi2.size();
        for (int i = 0; i < min; i++) {
            bi1.set(i, bi1.get(i) + bi2.get(i));
        }

        for (int i = 0; i < bi1.size(); i++) {
            if (bi1.get(i) > 9) {
                bi1.set(i + 1, bi1.get(i + 1) + 1);
                bi1.set(i, bi1.get(i) - 10);
            }
        }

        Collections.reverse(bi1);
        for (int i = 0; i < bi1.size(); i++) {
            System.out.print(bi1.get(i) + " ");
        }
    }
}