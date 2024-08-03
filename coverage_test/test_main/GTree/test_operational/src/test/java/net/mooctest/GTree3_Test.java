package net.mooctest;
import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
public class GTree3_Test {
@Test
public void test_23() throws Exception {
LinkedList<Tree<Tree<Integer>>> linkedList0 = new LinkedList<Tree<Tree<Integer>>>();
linkedList0.add((Tree<Tree<Integer>>) null);
Forest<Tree<Integer>> forest0 = new Forest<Tree<Integer>>(linkedList0);
try {
      forest0.map((Function<Tree<Integer>, Tree<Integer>>) null);
      fail("Expecting exception: NullPointerException");

    } catch(NullPointerException e) {

    }
}
}