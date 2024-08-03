package net.mooctest;
import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
public class GTree14_Test {
@Test
public void test_34() throws Exception {
LinkedList<Tree<Tree<Object>>> linkedList0 = new LinkedList<Tree<Tree<Object>>>();
Forest<Tree<Object>> forest0 = new Forest<Tree<Object>>(linkedList0);
Forest<Tree<Object>> forest1 = forest0.mapTrees((Function<Tree<Tree<Object>>, Tree<Object>>) null);
assertFalse(forest1.equals((Object)forest0));
}
}