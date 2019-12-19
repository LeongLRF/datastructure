package struct;

@SuppressWarnings("all")
public class Node<T> {
    public T date;
    public Node<T> next;

    public Node(T date) {
        this.date = date;
    }

    public Node<T> reverse() {
        Node<T> now = this;
        Node<T> pre = null;
        while (now!= null) {
            Node next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }

    public Node<T> reverse(Node<T> node,Node<T> prev){
        if (node.next == null) {
            node.next = prev;
            return node;
        } else {
            Node re = reverse(node.next, node);
            node.next = prev;
            return re;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node<T> curr =this;
        while (curr != null) {
            str.append(curr.date);
            curr = curr.next;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        n1.next = n2;
        n2.next = n3;
        System.out.println(n1.toString());
        System.out.println(n1.reverse(n1,null).toString());

    }
}
