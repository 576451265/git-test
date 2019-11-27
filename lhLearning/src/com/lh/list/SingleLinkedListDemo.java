package com.lh.list;

/**
 * @Description: 单链表
 * @author LuoH
 * @date 2019/11/6
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "小武", "smallmartial");
        HeroNode hero2 = new HeroNode(2,"宋江","及时雨");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");
        HeroNode hero5 = new HeroNode(5,"鲁智深","花和尚");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero5);
        //显示
        singleLinkedList.list();

    }
}

//定义SingleLinkedList
class SingleLinkedList{
    //首先初始化一个头节点
    private HeroNode head= new HeroNode(0,"","");
    //添加节点到单项链表
    /**
     *
     * 实现思路，当不考虑编号数据时：
     * 1.找到当前链表的最后节点
     * 2.将最后这个节点的next，指向新的节点
     */

    public void add(HeroNode heroNode){
        //因为head节点不能动，所有需要一个辅助遍历temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true){
            //尾节点next = null, 如果temp == null 则找到
            if (temp.next == null){
                break;
            }
            //如果没有找点将 temp 后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后的节点指向新的节点
        temp.next = heroNode;
    }

    //显示链表
    public void list(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空：");
            return;
        }
        //因为head节点不能动，所有需要一个辅助变量遍历
        HeroNode temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }

    }
}
//定义heroNode，每个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;//指向下一个节点

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
