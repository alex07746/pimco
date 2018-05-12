import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class FilteringIteratorTest extends TestCase {
    public void testHasNext() throws Exception {
        List<Integer> l = new ArrayList<>();
        l.add(2); l.add(3); l.add(1); l.add(50);
        IObjectTest o = new IObjectTest(){
            public boolean test(Object o){
                return ( (int) o % 2 == 0 )? true : false;
            }
        };
        FilteringIterator f = new FilteringIterator(l.iterator(), o);
        Integer result = (Integer) f.next();

        assertEquals(2, (int)result);
        result = (Integer) f.next();


        assertEquals(50, (int)result);
    }


}