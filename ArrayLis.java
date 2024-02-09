import java.util.*;
public class ArrayLis {
    public static void main(String args[]){
        ArrayList<Integer> al= new ArrayList<>();
        al.add(0);
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.set(3,50);
        al.remove(2);
        System.out.println(al);
        System.out.println(al.get(3));
        System.out.println(al.size());
        al.remove((Integer)(2));
        for(int i:al){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i=0;i<al.size();i++){
            System.out.print(al.get(i)+" ");
        }


    }
}
