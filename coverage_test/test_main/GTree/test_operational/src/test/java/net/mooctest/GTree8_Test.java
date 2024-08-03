package net.mooctest;
import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
public class GTree8_Test {
@Test
public void test_28() throws Exception {
LinkedList<Tree<Integer>> linkedList0 = new LinkedList<Tree<Integer>>();
linkedList0.add((Tree<Integer>) null);
Forest<Integer> forest0 = new Forest<Integer>(linkedList0);
StringBuilder stringBuilder0 = new StringBuilder("");
try {
      forest0.appendToString(stringBuilder0, 2147483645);
      fail("Expecting exception: NullPointerException");

    } catch(NullPointerException e) {
    }
}
}