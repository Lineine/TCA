package net.mooctest;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Builds tree from another tree
 *
 */
public class ChildrenLinkTreeBuilder<T> {

    public static interface Funnel<T> {
        public List<T> getChildren(T nodes);
    }

    private final Funnel<T> funnel;

    public ChildrenLinkTreeBuilder(Funnel<T> funnel) {
        this.funnel = funnel;
    }

    /**
     *
     * @param root root
     * @return built tree
     * @throws IllegalStateException if found no one or more than one root
     */
    public Tree<T> build(T root) {
        Tree<T> current = new Tree<T>(root);
        List<T> children = funnel.getChildren(root);
        if (children != null) {
            for (T child : children) {
                Tree<T> childTree = build(child);
                current.addChild(childTree);
            }
        }
        return current;
    }

    /**
     *
     * @param roots roots of another tree
     * @return list of roots
     * @throws IllegalStateException if no roots found
     */
    public Forest<T> buildForest(Iterable <? extends T> roots) {
        return new Forest<T>(Lists.newArrayList(Iterables.transform(roots, new Function<T, Tree<T>>() {
            @Override
            public Tree<T> apply(T input) {
                return build(input);
            }
        })));
    }


}
