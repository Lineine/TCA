package net.mooctest;
import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
public class GTree11_Test {
@Test
public void test_31() throws Exception {
LinkedList<Tree<Integer>> linkedList0 = new LinkedList<Tree<Integer>>();
Integer integer0 = new Integer(489);
Tree<Integer> tree0 = new Tree<Integer>(integer0);
linkedList0.add(tree0);
Forest<Integer> forest0 = new Forest<Integer>(linkedList0);
boolean boolean0 = forest0.isEmpty();
assertFalse(boolean0);
}
}