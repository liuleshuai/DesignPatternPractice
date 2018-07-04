package com.example.liukuo.Algorithm;

/**
 * 链表实现冒泡排序
 * Created by LiuKuo at 2018/7/4
 */

public class NodeListBubbleSort {
    public static class Node {
        Node next = null;
        Node pre = null;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node insert(int value, Node root) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return root;
        }
        Node curNode = root;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = node;
        return root;
    }

    public Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node q = null;   //尾巴
        Node p = head;   //头部
        while (p.next != q) {
            while (p.next != q) {
                if (p.value > p.next.value) {
                    int temp = p.value;
                    p.value = p.next.value;
                    p.next.value = temp;
                }
                p = p.next;
            }
            q = p; //每轮缩减
            p = head;
        }
        return head;
    }

    public void print(Node head) {
        if (head == null || head.next == null) {
            System.out.println("head是null");
        }
        while (head != null) {
            System.out.print(head.value + "  ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NodeListBubbleSort nodeList = new NodeListBubbleSort();
        Node head = null;
        head = nodeList.insert(4, head);
        nodeList.insert(2, head);
        nodeList.insert(3, head);
        nodeList.insert(6, head);
        nodeList.insert(1, head);
        nodeList.insert(0, head);
        nodeList.insert(5, head);
        nodeList.sort(head);
        nodeList.print(head);
    }
}
