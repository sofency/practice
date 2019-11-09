/**
 * @auther sofency
 * @date 2019/11/2 10:14
 * @package PACKAGE_NAME
 */

class Node{
    public int  data;
    public Node next;

    public Node(int data){
        this.data = data;
    }
}

public class ListNode{

    public  Node head; //头结点

    public void addNode(int data){//尾插法
        Node node = new Node(data);
        node.next =null;//新的结点后继结点为空
        Node p = this.head;//指向头结点
        if(this.head==null){
            this.head=node;//将第一个结点指向head
        }else{

            while(p.next!=null){
                p=p.next;
            }
            p.next = node;
        }
    }

    //创建两个链表相交
    public void addCut(Node headA,Node headB){
       headA.next.next= headB.next.next.next;
    }

    //获取两个链表的交点
    public Node  getIntersectionNode
            (Node headA,Node headB){
        if(headA == null || headB == null) {
            return null;
        }
        //永远指向最长的单链表
        Node pL = headA;
        //永远指向最短的单链表
        Node pS = headB;
        int lenA = 0;
        int lenB = 0;
        //分别求长度
        Node pA = headA;
        while(pA!=null){
            pA = pA.next;
            lenA++;
        }
        Node pB = headB;
        while(pB!=null){
            pB = pB.next;
            lenB++;
        }

        //求长度的差值
        int len = lenA-lenB;
        //如果是负数-》pL = headB;  pS = headA
        if(len>0){
            pL=headA;
            pS = headB;
        }else{
            pL=headB;
            pS = headA;
        }
        //只需要让pL走len步就好了
        while(len>0){
            pL=pL.next;
            len--;
        }
        //走完len步之后  两个同时开始走
        while(pL!=null&&pS!=null){
            if(pL==pS){
                return pL;
            }
            pL = pL.next;
            pS = pS.next;
        }
        //一直走 走到next值相同时 就是交点
        return null;
    }

    //将单链表分割成两半
//    public Node Partion(int x){
//        Node cur = this.head;
//        Node beforeStart = null;
//        Node beforeEnd =null;
//        Node afterStart = null;
//        Node afterEnd =null;
//        return null;
//
//    }
//

    //显示链表的值
    public void show(Node head){
        Node node = head;
        while(node!=null){
            System.out.print(node.data+"  ");
            node=node.next;
        }
    }

    //找出链表环的入口结点  思路是先使用快慢指针进行运动，当快慢指针的地址一样时 说明有死环，然后让其中一个指针指向开始的结点 一起运动 再次相遇就是入口结点
    public Node IsCycle(){
        Node fast = this.head;
        Node slow = this.head;
        boolean flag = false;//有无死环的标志
        while(fast!=null&&fast.next!=null){
            fast= fast.next.next;
            slow = slow.next;
            if(slow==fast){
                flag = true;
                break;
            }
        }
        if(flag){
            fast = this.head;
            while(fast!=slow){
                fast=fast.next;
                slow = slow.next;
            }
            return fast;
        }else{
            return null;//无死环
        }
    }

    //获取倒插第k个结点  再不知道链表的长度前提下 进项查找  使用快慢指针
    public  Node getNumber(int k){
        Node fast= this.head;
        Node slow = this.head;

        //快指针先走k步
        while(k>1){
            fast = fast.next;
            k--;
        }
        //快慢指针一起行走
        while(fast!=null&&slow!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //单链表的反转
    public void reverseList(){
        Node cur = this.head;//指向链表的开始
        Node pHead = null;
        Node pre = null;
        while(cur!=null){
            Node curNext = cur.next;//先记录当前的结点
            if(curNext==null){
                pHead = pre;
            }
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
    }

    //删除链表给定值的所有结点
    public void deleteAllNode(int key){
        Node cur = this.head;

        while(cur.next!=null){
            if(cur.next.data==key){
                cur.next= cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        //删除头结点
        if(this.head.data==key){
            this.head = this.head.next;
        }
    }

    //删除顺序链表中重复的值
    public  void deleteRepeatValue(){
        Node cur = this.head;//指向头结点
        while(cur.next!=null){
            if(cur.data==cur.next.data){
                cur = cur.next;//删除相同的结点
            }else{
                cur = cur.next;
            }
        }
    }

    // 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public Node seperate(int key){
        Node cur = this.head;//指向头结点
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;

        while(cur!=null){
            if(cur.data<key){
                if(beforeStart==null){
                    beforeStart = cur;
                    beforeEnd  = beforeStart;
                }else{
                    beforeEnd.next = cur;
                    beforeEnd = beforeEnd.next;
                }
            }else{
                if(afterStart==null){
                    afterStart = cur;
                    afterEnd = afterStart;
                }else{
                    afterEnd.next = cur;
                    afterEnd = afterEnd.next;
                }
            }
            cur= cur.next;
        }

        //可能的情况就是 beforeStart为空
        if(beforeEnd!=null){//beforeStart 不为空
            beforeEnd.next = afterStart;
            return beforeStart;
        }else if(afterStart!=null){//beforeStart 为空的情况下设置afterEnd
            afterEnd.next =null;
            return afterStart;
        }
        return null;
    }

    //单链表的回文判断  做法就是   将链表的一半进行逆转

    public  boolean  isPalindromic(){
        //快慢指着进行移动
        Node fast = this.head;
        Node head = this.head;
        Node slow = this.head;
        //快慢指针进行移动
        while(fast!=null&&fast.next !=null){
            fast =fast.next.next;
            slow = slow.next;
        }

        //精slow之后的链表进行逆转

        Node pHead = null;
        Node p= slow.next;
        Node pre = null;
        while(p!=null){
            Node curNext = p.next;

            if(curNext==null){
                pHead = p;
            }
            p.next = pre;
            pre = p;
            p= curNext;
        }

        while(head!=null&&pHead!=null){
            if(head.data!=pHead.data&&head!=pHead){
                return false;
            }
            head=head.next;
            pHead = pHead.next;
        }
        return true;
    }



    public Node mergeTwoListNode(ListNode list1,ListNode list2){

//        有序的单链表
        Node list = new Node(0);//头结点
        Node newHead = list;

        Node head1 = list1.head;
        Node head2 = list2.head;

        //假设两个单链表非空
        while(head1!=null&&head2!=null){
            if(head1.data>head2.data){
                list.next = head2;
                head2= head2.next;
            }else{
                list.next = head1;
                head1 =head1.next;
            }
            list = list.next;//指向下一 个结点
        }

        if(head1==null&&head2!=null){
            list.next = head2;
        }else if(head1!=null&head2==null){
            list.next = head1;
        }
        return newHead.next;
    }

    //单链表的反转
    public Node  reverseList(ListNode list){

        Node pre = null;
        Node  newHead = null;
        Node cur = list.head;
        while(cur!=null){
            Node curNext = cur.next;
            if(curNext==null){
                newHead = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return newHead;
    }


    public static void main(String[] args){
        ListNode list1 = new ListNode();
        list1.addNode(1);
        list1.addNode(3);
        list1.addNode(5);
        list1.addNode(7);
        ListNode list2 = new ListNode();
        list2.addNode(1);
        list2.addNode(2);
        list2.addNode(3);

        System.out.println();

        ListNode list3 = new ListNode();
        list3.head = list3.mergeTwoListNode(list1,list2);
        list3.show(list3.head);
//       System.out.println(list.isPalindromic());
//       list.deleteAllNode(10);
//       list.show(list.head);

//       Node test = list.seperate(10);
//       list.show(test);
//       Node node= list.partion(7);
//       list.show(node);



    }

}

