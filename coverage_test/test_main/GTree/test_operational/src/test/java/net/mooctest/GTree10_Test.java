package net.mooctest;
import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
public class GTree10_Test {
@Test
public void test_30() throws Exception {
LinkedList<Tree<Object>> linkedList0 = new LinkedList<Tree<Object>>();
Forest<Object> forest0 = new Forest<Object>(linkedList0);
boolean boolean0 = forest0.isEmpty();
assertTrue(boolean0);
}
}