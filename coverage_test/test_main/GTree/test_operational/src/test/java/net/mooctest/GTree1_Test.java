package net.mooctest;
import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
public class GTree1_Test {
@Test
public void test_21() throws Exception {
LinkedList<Tree<Integer>> linkedList0 = new LinkedList<Tree<Integer>>();
linkedList0.add((Tree<Integer>) null);
Forest<Integer> forest0 = new Forest<Integer>(linkedList0);
try {
      forest0.transform((Function<Integer, Object>) null);
      fail("Expecting exception: NullPointerException");

    } catch(NullPointerException e) {
    }
}
}