package com.leex1825.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BNode<T extends Comparable> implements Comparable {

    public BNode(T content) {
        this.content = content;
    }

    private T content;

    private BNode leftNode;;

    private BNode rightNode;

    @Override
    public int compareTo(Object o) {

        if (!(o instanceof  BNode)) {
            return -1;
        }

        BNode bNode = (BNode) o;

        return this.getContent().compareTo(bNode.getContent());
    }
}
