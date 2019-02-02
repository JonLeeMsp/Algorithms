package com.leex1825;

import com.leex1825.algorithm.BinaryTree;
import com.leex1825.store.Graph;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Slf4j
public class Application {

    @Autowired
    private Graph graph;

    @Autowired
    private BinaryTree binaryTree;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void test() {

        BinaryTree tree = new BinaryTree();

        tree.insert(10);
        tree.insert(5);
        tree.insert(11);
        tree.insert(7);
        tree.insert(9);
        tree.insert(22);
        tree.insert(11);

        System.out.println("Tree:" + tree);
    }
}
