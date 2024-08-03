package net.mooctest;
import static org.junit.Assert.assertEquals;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.junit.Test;
public class GTree19_Test {
@Test
public void test_39() throws Exception {
PathTreeBuilder<Integer, HashMap<Object, Integer>> pathTreeBuilder0 = new PathTreeBuilder<>(pathTreeBuilder_Funnel0);
HashMap<Integer, Object> hashMap0 = new HashMap<Integer, Object>();
Set<Integer> set0 = hashMap0.keySet();
Forest<Integer> forest0 = pathTreeBuilder0.build(set0);
assertEquals(0, forest0.size());
}
}