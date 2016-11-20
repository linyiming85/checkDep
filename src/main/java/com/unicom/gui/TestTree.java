package com.unicom.gui;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Created by linym on 2016/11/20.
 */
public class TestTree extends JTree{
    private JTree tree;
    public TestTree(){
        setTree();
        this.add(tree);
        this.setSize(500,300);
    }
    public void setTree(){
        DefaultMutableTreeNode lx=new DefaultMutableTreeNode("联系人");
        DefaultMutableTreeNode qr=new DefaultMutableTreeNode("亲人");
        DefaultMutableTreeNode ba=new DefaultMutableTreeNode("爸爸");
        DefaultMutableTreeNode jj=new DefaultMutableTreeNode("姐姐");
        DefaultMutableTreeNode tx=new DefaultMutableTreeNode("同学");
        DefaultMutableTreeNode cy=new DefaultMutableTreeNode("程远");
        DefaultMutableTreeNode py=new DefaultMutableTreeNode("朋友");
        DefaultMutableTreeNode wz=new DefaultMutableTreeNode("武总");

        lx.add(qr);
        qr.add(ba);
        qr.add(jj);

        lx.add(tx);
        tx.add(cy);

        lx.add(py);
        py.add(wz);

        tree=new JTree(lx);
        tree.addTreeSelectionListener(new TreeSelectionListener() {

            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node=(DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
                if(node==null) return;
                if(node.isLeaf()){
                    leaf(node);
                }else{
                    branch(node);
                }

            }
        });
    }
    private void leaf(DefaultMutableTreeNode node){
        System.out.println("叶节点：" + node.getUserObject());
    }


    private void branch(DefaultMutableTreeNode node) {
        System.out.println("枝节点：" + node.getUserObject());
    }


    public static void main(String[] args) {
        TestTree frame = new TestTree();
        frame.setVisible(true);
    }
}
