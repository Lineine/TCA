package net.mooctest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MyTreeNode_Test {

    @Test
    public void testConstructorWithData() {
        MyTreeNode<String> node = new MyTreeNode<String>("data");
        assertEquals("data", node.getData());
        assertEquals(-10000, node.getAlpha());
        assertEquals(10000, node.getBeta());
        assertEquals(0, node.getValue());
        assertEquals(0, node.getChildren().size());
        assertNull(node.getParent());
    }

    @Test
    public void testConstructorWithAlphaAndBeta() {
        MyTreeNode<String> node = new MyTreeNode<String>(10, 20);
        assertEquals(null, node.getData());
        assertEquals(10, node.getAlpha());
        assertEquals(20, node.getBeta());
        assertEquals(0, node.getValue());
        assertEquals(0, node.getChildren().size());
        assertNull(node.getParent());
    }

    @Test
    public void testConstructorWithValue() {
        MyTreeNode<String> node = new MyTreeNode<String>(30);
        assertEquals(null, node.getData());
        assertEquals(-10000, node.getAlpha());
        assertEquals(10000, node.getBeta());
        assertEquals(30, node.getValue());
        assertEquals(0, node.getChildren().size());
        assertNull(node.getParent());
    }

    @Test
    public void testAddChild() {
        MyTreeNode<String> parent = new MyTreeNode<String>("parent");
        MyTreeNode<String> child = new MyTreeNode<String>("child");
        parent.addChild(child);
        assertEquals(1, parent.getChildren().size());
        assertEquals(parent, child.getParent());
    }

    @Test
    public void testAddChildWithData() {
        MyTreeNode<String> parent = new MyTreeNode<String>("parent");
        parent.addChild("child");
        assertEquals(1, parent.getChildren().size());
        assertEquals("child", parent.getChildren().get(0).getData());
        assertEquals(parent, parent.getChildren().get(0).getParent());
    }

    @Test
    public void testAddChildren() {
        MyTreeNode<String> parent = new MyTreeNode<String>("parent");
        List<MyTreeNode> children = new ArrayList<>();
        children.add(new MyTreeNode<String>("child1"));
        children.add(new MyTreeNode<String>("child2"));
        parent.addChildren(children);
        assertEquals(2, parent.getChildren().size());
        assertEquals(parent, parent.getChildren().get(0).getParent());
        assertEquals(parent, parent.getChildren().get(1).getParent());
    }

    @Test
    public void testDataGetterAndSetter() {
        MyTreeNode<String> node = new MyTreeNode<String>("oldData");
        assertEquals("oldData", node.getData());
        node.setData("newData");
        assertEquals("newData", node.getData());
    }

    @Test
    public void testAlphaGetterAndSetter() {
        MyTreeNode<String> node = new MyTreeNode<String>("data");
        assertEquals(-10000, node.getAlpha());
        node.setAlpha(50);
        assertEquals(50, node.getAlpha());
    }

    @Test
    public void testBetaGetterAndSetter() {
        MyTreeNode<String> node = new MyTreeNode<String>("data");
        assertEquals(10000, node.getBeta());
        node.setBeta(60);
        assertEquals(60, node.getBeta());
    }

    @Test
    public void testValueGetterAndSetter() {
        MyTreeNode<String> node = new MyTreeNode<String>("data");
        assertEquals(0, node.getValue());
        node.setValue(70);
        assertEquals(70, node.getValue());
    }
}
