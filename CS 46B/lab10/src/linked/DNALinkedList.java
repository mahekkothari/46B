package linked;

public class DNALinkedList {

    private static class Node<T> {
        private T data;
        private Node<T> prev; // previous
        private Node<T> next;

        Node(T data) {
            this.data = data;
        }

        // Returns data of prev node, this node, and next node. Uses "<" if prev is
        // null, and ">" if next is null.
        public String toString() {
            String s;
            if (prev == null)
                s = "<";
            else
                s = prev.data.toString();

            s += data;

            if (next == null)
                s += ">";
            else
                s += next.data;

            return s;
        }

    }

    private Node<Character> head; // head.prev is always null
    private Node<Character> tail; // tail.next is always null

    public DNALinkedList(String s) {
        append(s);
    }

    // Used by extraction methods. Not for public use.
    private DNALinkedList(Node<Character> head, Node<Character> tail) {
        this.head = head;
        head.prev = null;
        this.tail = tail;
        tail.next = null;
    }

    // Converts arg to nodes which are appended to end of this list.
    public void append(String s) {
        for (int i = 0; i < s.length(); i++)
            append(s.charAt(i));
    }

    // Creates a node for ch and appends it to the linked list.
    // "Append" always means "at the end".
    public void append(char ch) {
        append(new Node<Character>(ch));
    }

    public String toString() {
        String s = "DNALinkedList: ";
        if (head == null)
            s += "Empty";
        else {
            Node<Character> n = head;
            while (n != null) {
                s += n.data;
                n = n.next;
            }
        }
        return s;
    }

    // Appends n to tail of this list.
    public void append(Node<Character> n) {
        // Corner case: empty list.
        if (tail == null) {
            n.prev = null;
            n.next = null;
            head = n;
            tail = n;
        }
        
        // General case.
        else {
            // fill this in
            tail.next = n;
            n.prev = tail;
            n.next = null;
            tail = n;
        }
    }

    // Returns true if the nodes starting at startNode match the target string. For
    // example,
    // if the linked list looks like this:
    // (A) —> (B) -> (C) -> (D) -> (E) -> (F)
    // and if startNode is the 2nd node (“B”), then matches(startNode, “BCDE”)
    // should return true.
    private boolean matches(Node<Character> startNode, String target) {
        Node<Character> current = startNode;
        for (int i = 0; i < target.length(); i++) {
            if (current == null || current.data != target.charAt(i)) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    public Node<Character> find(String target) {
        Node<Character> current = head;
        while (current != null) {
            if (matches(current, target)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Extract and return the nodes starting at firstExtractedNode and ending at
    // lastExtractedNode.
    // The returned nodes should be a DNALinkedList. Don’t worry about any corner
    // cases: assume
    // firstExtractedNode and lastExtractedNode are both in the list and are not
    // near the head or tail.
    public DNALinkedList extract(Node<Character> firstExtractedNode, Node<Character> lastExtractedNode) {
        // Find nodes just before and just after the chain to be extracted. Assume these
        // aren't null.
        Node<Character> beforeFirst = firstExtractedNode.prev;
        Node<Character> afterLast = lastExtractedNode.next;
        
        // Connect beforeFirst to afterLast.
        beforeFirst.next = afterLast;
        afterLast.prev  = beforeFirst;
        
        // Return a DNALinkedList containing the extracted chain.
        return new DNALinkedList(firstExtractedNode, lastExtractedNode);
    }

    // Inserts insertMe into this list, at the node before insertionPoint.
    public void insert(DNALinkedList insertMe, Node<Character> insertionPoint) {
    // Find the node immediately before the insertion point.
    Node<Character> beforeInsertionPoint = insertionPoint.prev;
    
    // Connect node immediately before the insertion point to the head of insertMe.
    if (beforeInsertionPoint != null) {
    beforeInsertionPoint.next = insertMe.head;
    insertMe.head.prev = beforeInsertionPoint;
} else {
    head = insertMe.head;
}
    
    // Connect the tail of insertMe to the insertionPoint node.
    insertMe.tail.next = insertionPoint;
    insertionPoint.prev = insertMe.tail;
}


    // Reverses the order of the nodes.
    public void reverse() {
        // Swap next and prev of every node. Caution: in your loop, you won't be able
        // to advance n by setting n = n.next(). Why? How should you advance n?
        Node<Character> n = head;
        Node<Character> temp = null;
        while (n != null) {
            // fill this in
            temp = n.next;
            n.next = n.prev;
            n.prev = temp;
            n = n.prev; 
        }

        // Swap head and tail.
        // fill this in
        temp = head;
        head = tail;
        tail = temp;
    }

    // Removes sequence matching transposon, reverses it, and inserts it back into
    // this list immediately before target. Throws IllegalArgumentException if
    // can't find transposon or target. Use the methods you just wrote.
    public void transpose(String transposon, String target) {
        // Find starting node of transposon.
        Node<Character> firstNodeOfTransposon = find(transposon);
        if (firstNodeOfTransposon == null)
            throw new IllegalArgumentException("Transposon not found.");
            
            // Find last node of transposon. You'll need several lines. Set a variable to the first node
            // of the transposon, then do a loop where for every char in the transposon, you set the variable
            // to its "next".
            Node<Character> lastNodeOfTransposon = firstNodeOfTransposon;
            for (int i = 1; i < transposon.length(); i++) {
                lastNodeOfTransposon = lastNodeOfTransposon.next;
            }
            
            // Extract the transposon.
            DNALinkedList transposonList = extract(firstNodeOfTransposon, lastNodeOfTransposon);
            
            // Reverse the transposon.
            transposonList.reverse();
        
        // Find starting node of target.
        Node<Character> firstNodeOfTarget = find(target);
        if (firstNodeOfTarget == null)
        throw new IllegalArgumentException("Target not found.");
    }
            
            // Insert immediately before target.
            insert(transposonList, firstNodeOfTarget);
    }

    public static void main(String[] args) {
        String chromosome = "AGTCGATA";
        DNALinkedList list = new DNALinkedList(chromosome);
        System.out.println("original  : " + list);
        String transposon = "TCG";
        String target = "TA";
        list.transpose(transposon, target);
        System.out.println("transposed: " + list);
    }


