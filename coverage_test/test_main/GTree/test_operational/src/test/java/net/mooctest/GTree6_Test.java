package net.mooctest;
import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
public class GTree6_Test {
@Test
public void test_26() throws Exception {
Forest<Integer> forest0 = new Forest<Integer>((List<Tree<Integer>>) null);
try {
      forest0.get(42);
      fail("Expecting exception: NullPointerException");

    } catch(NullPointerException e) {

    }
}
}