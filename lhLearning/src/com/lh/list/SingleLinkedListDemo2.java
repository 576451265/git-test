package com.lh.list;

/**
 * @Description:
 * @author LuoH
 * @date 2019/11/6
 */
public class SingleLinkedListDemo2 {
    //头结点
    static Node head;

    static class Node {
        //数据域
        public int data;

        //指针域，指向下一个节点
        public Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    /**
     * 项链表添加数据
     * @param value 要添加的数据
     */
    public void addData(int value) {
        //初始化要加入的节点
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        //临时节点
        Node temp = head;

        //找到尾节点
        while (temp.next != null) {
            temp = temp.next;
        }

        //已经包括了头节点，next为null的情况
        temp.next = newNode;
    }

    public void traverse(Node head) {
        //临时节点，从首节点开始
        Node temp = head.next;

        while (temp != null) {
            System.out.println("节点：" + temp.data);
            //继续下一个
            temp = temp.next;
        }
    }

    public void traverse() {
        traverse(head);
    }

    /**
     * 获取链表的长度
     */
    public int linkListLength() {
        int length = 0;

        //临时节点 从首节点开始
        Node temp = head;

        //找到尾节点
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 插入节点
     * @param index 要插入的位置
     * @param dataue 要插入的值
     */
    public void insertNode(int index,int dataue){

        //首先需要判断指定位置是否合法
        if (index < 1 || index >linkListLength() + 1){
            System.out.println("插入位置不合法");
            return;
        }

        //临时节点，从头节点开始
        Node temp = head;

        //记录遍历的当前位置
        int currentPos = 1;

        //初始化要插入的节点
        Node insertNode = new Node(dataue);

        while (temp.next != null){
            //找到上一个节点的位置
            if ((index - 1) == currentPos){
                //temp表示的是上一个节点
                //将原本又上一个节点的指向交由插入的节点指向
                insertNode.next = temp.next;

                //将上一个节点的指针域指向要插入的节点
                temp.next = insertNode;

                return;
            }
            currentPos++;
            temp = temp.next;
        }
    }

    /**
     * 根据位置删除节点
     * @param index 要删除的位置
     */
    public void deleteNode(int index){
        //首先判断指定位置是否合法
        if (index < 1 || index > linkListLength() + 1){
            System.out.println("删除位置不合法");
            return;
        }

        //临时节点 从头节点开始
        Node temp = head;

        //记录遍历的当前位置
        int currentPos = 1;

        while (temp.next != null){
            //找到上一个节点的位置了8
            if ((index-1) == currentPos){
                //temp表示的是上一个节点
                //temp.next表示的是想要删除的节点
                //将想要删除的节点存储一下
                Node deleteNode = temp.next;

                //想要删除节点的下一个节点交由上一个节点来控制
                temp.next = deleteNode.next;
                return;
            }
            currentPos++;
            temp = temp.next;
        }
    }

    //冒泡排序
    public void bubbleSort(){
        if(head == null || head.next == null)  //链表为空或者仅有单个结点
            return ;

        Node cur = null, tail = null;

        cur = head;
        //1->2->3, 第一轮tail为null，循环完是cur是3节点，第二轮循环到3节点退出，此时cur是2节点
        while(cur.next != tail){
            while(cur.next != tail){
                if(cur.data > cur.next.data){
                    int tmp = cur.data;
                    cur.data = cur.next.data;
                    cur.next.data = tmp;
                }
                cur = cur.next;
            }

            tail = cur;  //下一次遍历的尾结点是当前结点(仔细琢磨一下里面的道道)
            cur = head;     //遍历起始结点重置为头结点
        }

        return ;
    }

    /**
     * 找到链表中倒数第k个节点(设置两个指针p1、p2，让p2比p1快k个节点，同时向后遍历，当p2为空，则p1为倒数第k个节点
     *
     * @param k    倒数第k个节点
     */
    public Node findKNode( int k) {

        if (k < 1 || k > linkListLength())
            return null;
        Node p1 = head;
        Node p2 = head;

        // p2比怕p1快k个节点
        for (int i = 0; i < k - 1; i++)
            p2 = p2.next;


        // 只要p2为null，那么p1就是倒数第k个节点了
        while (p2.next != null) {

            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;


    }

    /**
     * 删除链表重复数据(跟冒泡差不多，等于删除就是了)
     *
     */
    public void deleteDuplecate() {

        if(head == null || head.next == null)  //链表为空或者仅有单个结点
            return ;

        Node cur = null, tail = null;

        cur = head;
        //1->2->3, 第一轮tail为null，循环完是cur是3节点，第二轮循环到3节点退出，此时cur是2节点
        while(cur.next != tail){
            while(cur.next != tail){
                if(cur.data == cur.next.data){
                    cur.next = cur.next.next;
                }
                cur = cur.next;
            }

            tail = cur;  //下一次遍历的尾结点是当前结点(仔细琢磨一下里面的道道)
            cur = head;     //遍历起始结点重置为头结点
        }

        return ;
    }

    /**
     * 查询单链表的中间节点
     */

    public Node searchMid() {

        Node p1 = head;
        Node p2 = head;


        // 一个走一步，一个走两步，直到为null，走一步的到达的就是中间节点
        while (p2 != null && p2.next != null && p2.next.next != null) {

            p1 = p1.next;
            p2 = p2.next.next;

        }
        return p1;
    }

    /**
     * 通过递归从尾到头输出单链表
     *
     * @param head 头节点
     */
    public  void printListReversely(Node head) {
        if (head != null) {
            printListReversely(head.next);
            System.out.println("节点："+head.data);
        }
    }

    /**
     * 实现链表的反转
     *
     * @param node 链表的头节点
     */
    public static Node reverseLinkList(Node node) {

        Node prev ;
        if (node == null || node.next == null) {
            prev = node;
        } else {
            Node tmp = reverseLinkList(node.next);
            node.next.next = node;
            node.next = null;
            prev = tmp;
        }
        return prev;

    }

    public static void main(String[] args) {
        SingleLinkedListDemo2 link = new SingleLinkedListDemo2();
        link.addData(4);
        link.addData(7);
        link.addData(3);
        link.addData(2);
        link.addData(6);
        link.addData(4);

        System.out.println("链表长度："+link.linkListLength());
        link.traverse();
        System.out.println("插入节点第四个位置节点5------");
        link.insertNode(4,5);
        link.traverse();
        System.out.println("删除第五个节点------");
        link.deleteNode(5);
        link.traverse();
        System.out.println("冒泡排序------");
        link.bubbleSort();
        link.traverse();
        Node KNode = link.findKNode(2);
        System.out.println("倒数第二个节点："+KNode.data);
        System.out.println("删除重复数据------");
        link.deleteDuplecate();
        link.traverse();
        Node MidNode = link.searchMid();
        System.out.println("中间节点："+MidNode.data);
        System.out.println("通过递归从尾到头输出单链表---");
        link.printListReversely(head);

        System.out.println("反转链表------");
        Node reverseNode = reverseLinkList(head);
        link.traverse(reverseNode);

    }

}
