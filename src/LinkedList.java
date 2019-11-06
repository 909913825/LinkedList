public class LinkedList<E> {
    private class Node<E>{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node (E e) {
            this(e,null);
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    private int size;

//    public LinkedList(){
//        head = null;
//        size = 0;
//    }
    private Node dummyhead;
    public LinkedList(){
        dummyhead = new Node(null,null);
        size = 0;
    }
    //获取链表中的元素个数
    public int getSize(){
        return size;
    }
    //返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }
    //在链表添加新的元素e
    public void addFirst(E e){
        addIndexPlus(0,e);
//        Node node = new Node(e);
//        node.next = dummyhead;
//        dummyhead = node;
//        size ++;
        //head = new Node(e, head)
    }
    //在链表的index()添加元素e 头节点为0
    public void addIndex(int index,E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed, Illegal index.");
        }
        if (index == 0){
            addFirst(e);
        }else {
            Node prev = dummyhead;
            for (int i = 0; i < index - 1; i ++){
                prev = prev.next;
            }
            Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;
//            prev.next = new Node(e,prev.next);
            size ++;
        }
    }
    public void addIndexPlus(int index,E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed, Illegal index. ");
        }
        Node prev = dummyhead;
        for (int i = 0; i < index; i ++){
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
//        prev.next = new Node(e,prev.next);
        size ++;
    }
    public void addLast(E e){
        addIndex(size, e);
    }
    public E getIndex(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Add failed, Illegal index.");
        }
        //索引为0的元素
        Node cur = dummyhead.next;
        for (int i = 0; i < index; i ++){
            cur = cur.next;
        }
        return (E) cur.e;
    }
    public E getFirst(){
        return getIndex(0);
    }
    public E getLast(){
        return getIndex(size - 1);
    }

    public void set(int index, E e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Add failed, Illegal index.");
        }
        Node cur = dummyhead.next;
        for ( int i = 0; i < index; i ++){
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e){
        Node cur = dummyhead.next;
        while (cur != null){
            if (cur.e.equals(e)){
                return true;
            }else {
                cur = cur.next;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyhead.next;
//        for (Node cur = dummyhead.next; cur != null; cur = cur.next){
//            res.append(cur + "->");
//        }
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
