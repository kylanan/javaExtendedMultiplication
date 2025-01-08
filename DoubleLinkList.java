public class DoubleLinkList {
    private Node head;
    private Node tail;

    //Default Constructor
    public DoubleLinkList() {
        head = null;
        tail = null;
    }

    //Accessors
    public Node getHead() {
        return head;
    }
    public Node getTail() {
        return tail;
    }

    //Basic methods
    public void printList() {
        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.getData());
            tempNode = tempNode.getNext();
        }
        return;
    }

    public void insertAtFront(int x) {
        Node tempNode = new Node(x);
        if (head == null) {
            head = tempNode;
            tail = tempNode;
        }
        else {
            head.setPrev(tempNode);
            tempNode.setNext(head);
            head = tempNode;
        }
        return;
    }

    public void insertAtEnd(int x) {
        Node tempNode = new Node(x);
        if (tail == null) {
            head = tempNode;
            tail = tempNode;
        }
        else {
            tail.setNext(tempNode);
            tempNode.setPrev(tail);
            tail = tempNode;
        }
        return;
    }


    //Add: Add two double linked lists, write the result to the double linked list calling this method
    public void add(DoubleLinkList a, DoubleLinkList b) {
        int res = 0;
        int car = 0;
        Node a1 = a.getTail();
        Node b1 = b.getTail();

        this.head = null;
        this.tail = null;

        while (a1 != null || b1 != null) {
            //For each decimal place, add digits of numbers + carry, mod 10 for result in this place, div 10 for carry result
            //Then, move DLLs backwards 1 to prepare for the next place and loop if digits remain
            if (a1 != null && b1 != null) {
                res = (a1.getData() + b1.getData() + car) % 10;
                car = (a1.getData() + b1.getData() + car) / 10;
                a1 = a1.getPrev();
                b1 = b1.getPrev();
            }
            else if (a1 == null && b1 != null) {        //current digit in a = 0
                res = (b1.getData() + car) % 10;
                car = (b1.getData() + car) / 10;
                b1 = b1.getPrev();
            }
            else if (a1 != null && b1 == null) {        //current digit in b = 0
                res = (a1.getData() + car) % 10;
                car = (a1.getData() + car) / 10;
                a1 = a1.getPrev();
            }
            insertAtFront(res);
        }

        if (car != 0) {         //If final addition has a carry, append that digit to the front
            insertAtFront(car);
        }
    }

    //Multiply: Multiplies two DLLs, writes result to the DLL calling this method
    public void multiply(DoubleLinkList a, DoubleLinkList b) {
        Node a1 = a.getTail();
        Node b1 = b.getTail();
        int res = 0;
        int car = 0;
        int place = 0;
        //Premise: multiply each digit of B by the current digit of A, add all results, then move to the next digit of A until no more remain.
        while (a1 != null) {
            DoubleLinkList temp = new DoubleLinkList();     //temp represents the result of the individual multiplication at this step, reset per loop
            while (b1 != null) {
                //Multiply current digits of a and b and add carry, mod 10 for current digit in result, div 10 for carry into next place
                res = (a1.getData() * b1.getData() + car) % 10;
                car = (a1.getData() * b1.getData() + car) / 10;
                b1 = b1.getPrev();
                temp.insertAtFront(res);
            }
            if (car != 0) {                         //if final digit has a carry, append that digit to the front
                temp.insertAtFront(car);
            }
            for (int i = 0; i < place; i++) {       //Add a zero to the end for each place moved in a; equivalent to multiplying by 10^n
                temp.insertAtEnd(0);
            }
            //temp.printList();
            //this.printList();
            this.add(this, temp);
            temp.head = null;
            temp.tail = null;

            a1 = a1.getPrev();      //move a to the next place value
            b1 = b.getTail();       //reset b to the end for the loop
            res = 0;                //reset result and carry
            car = 0;
            place++;                //increase place value by 1
        }

    }

}
