package net.mooctest;
import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
public class GTree9_Test {
@Test
public void test_29() throws Exception {
Integer integer0 = new Integer((-1));
Tree<Object> tree0 = new Tree<Object>(integer0);
Forest<Object> forest0 = new Forest<Object>((List<Tree<Object>>) null);
try {
      forest0.add(tree0);
      fail("Expecting exception: NullPointerException");

    } catch(NullPointerException e) {
    }
}
}