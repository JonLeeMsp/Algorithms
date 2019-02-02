package com.leex1825.algorithm;

import com.leex1825.store.BNode;
import com.leex1825.store.Edge;
import com.leex1825.store.Graph;
import com.leex1825.store.Node;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

@Slf4j
@Service
public class BinaryTree<T extends Comparable<T>> {

    private BNode parentNode;

    public BNode insert(T content) {
        if (parentNode == null) {
            parentNode = new BNode(content);
        } else {
            parentNode = insert(parentNode, content);
        }

        return parentNode;
    }

    public BNode insert(BNode node, T content) {

        if (node == null) {
            return new BNode(content);
        }

        if (node.getContent().compareTo(content) < 0) {
            node.setRightNode(insert(node.getRightNode(), content));
        } else if (node.getContent().compareTo(content) > 0) {
            node.setLeftNode(insert(node.getLeftNode(), content));
        } else {
            node.setContent(content);
        }

        return node;
    }

    @Override
    public String toString() {

        String string = null;

        Queue q = new LinkedBlockingDeque<>();
        q.add(parentNode);

        while (!q.isEmpty()) {
            BNode node = (BNode) q.poll();

            string += node.getContent() + " ";
            if (node.getLeftNode() != null) {
                q.add(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                q.add(node.getRightNode());
            }
        }

        return string;
    }
}