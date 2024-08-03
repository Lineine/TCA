package net.mooctest;
import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
public class GTree13_Test {
@Test
public void test_33() throws Exception {
LinkedList<Tree<Tree<Integer>>> linkedList0 = new LinkedList<Tree<Tree<Integer>>>();
Forest<Tree<Integer>> forest0 = new Forest<Tree<Integer>>(linkedList0);
Integer integer0 = new Integer(0);
Tree<Integer> tree0 = new Tree<Integer>(integer0);
Function<Tree<Integer>, Integer> function0 = Tree::getValue;
Forest<Integer> forest1 = forest0.transform(function0);
boolean boolean0 = forest1.add(tree0);
assertTrue(boolean0);
}
}