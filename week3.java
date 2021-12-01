


class week3 {
    week3 next;
    int data;
}

class Linked {
    
    public week3 mergeTwoSortedLinkedListReverseOrder(week3 node1, week3 node2) {
        if(node1 == null && node2 == null) {
            return null;
        }

        week3 mergedList, next;
        mergedList = null;

        while(node1 != null && node2 != null) {
            if(node1.data < node2.data) {
                next = node1.next;
                node1.next = mergedList;
                mergedList = node1;
                node1 = next;
            } else {
                next = node2.next;
                node2.next = mergedList;
                mergedList = node2;
                node2 = next;
            }
        }

        week3 temp = node1 != null ? node1 : node2;
        while(temp != null) {
            next = temp.next;
            temp.next = mergedList;
            mergedList = temp;
            temp = next;
        }

        return mergedList;
    }

    
    public week3 getNewNode(int key) {
        week3 a = new week3();
        a.next = null;
        a.data = key;
        return a;
    }

   
    public week3 insert(int key,week3 node) {

        if (node == null)
            return getNewNode(key);
        else
            node.next = insert(key, node.next);

        return node;
    }


    public void printList(week3 node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        printList(node.next);
    }
}

class LinkedListApp {
    public static void main(String[] args) {
        Linked a = new Linked();

        week3 head1 = null;

        head1 = a.insert(7, head1);
        head1 = a.insert(1, head1);
        head1 = a.insert(5, head1);
        head1 = a.insert(6, head1);
        head1 = a.insert(3, head1);


        week3 head2 = null;
        head2 = a.insert(2, head2);
        head2 = a.insert(10, head2);
        head2 = a.insert(8, head2);
        head2 = a.insert(4, head2);

        week3 mergedInReverse = a.mergeTwoSortedLinkedListReverseOrder(head1, head2);
        a.printList(mergedInReverse);
    }
}