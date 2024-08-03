package net.mooctest;
import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
public class GTree4_Test {
@Test
public void test_24() throws Exception {
Forest<Object> forest0 = new Forest<Object>((List<Tree<Object>>) null);
try {
      forest0.map((Function<Object, Object>) null);
      fail("Expecting exception: NullPointerException");

    } catch(NullPointerException e) {

    }
}
}