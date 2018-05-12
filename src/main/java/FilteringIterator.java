import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


 interface IObjectTest{
     boolean test(Object o);
}

public class FilteringIterator<T>{


    Iterator<T> i;
    IObjectTest t;
    boolean hasNext = true;
    T next;


    public FilteringIterator(Iterator<T> myIterator, IObjectTest myTest){
        i = myIterator;
        t = myTest;
        getNext();
    }
    private void getNext(){
       // while( (hasNext = i.hasNext()) && t.test( next = i.next())) {
        while( (hasNext = i.hasNext())) {
            next = i.next();
            if(t.test(next))
                return;
        }
        hasNext=false; next = null;
    }
    // check if there is a valid next in the rest of the list
    public boolean hasNext(){
        return hasNext;
    }
    // get the valid next from rest of the list
    public T next(){
        T k = next;
        getNext();
        return k;
    }

    public static void main(String[] args){
        List<Integer> l = new ArrayList<>();
        l.add(2); l.add(4); l.add(3); l.add(50); l.add(52);
        IObjectTest o = new IObjectTest(){
            public boolean test(Object o){
                return ( (int) o % 2 == 0 )? true : false;
            }
        };
        FilteringIterator<Integer> f = new FilteringIterator<Integer>(l.iterator(), o);
        while (f.hasNext()){
            System.out.println(f.next());
        }
    }
}