package Homeworks.HWL4;

import java.util.LinkedList;

/* Реализуйте очередь с помощью LinkedList со следующими методами:
*enqueue() - помещает элемент в конец очереди,
*dequeue() - возвращает первый элемент из очереди и удаляет его,
*first() - возвращает первый элемент из очереди, не удаляя.
*/
public class task2 {

    public static void main(String[] args) {
        OwnLinkedList myLinkedList = new OwnLinkedList();
        myLinkedList.enqueue(10);
        myLinkedList.enqueue(20);
        myLinkedList.enqueue(30);
        myLinkedList.enqueue(40);
        System.out.print("Очередь: ");
        System.out.println(myLinkedList);
        int firstElement = myLinkedList.dequeue();
        System.out.printf("Первый удаленный элемент %d. Получена очередь: ", firstElement);
        System.out.println(myLinkedList);
        firstElement = myLinkedList.first();
        System.out.printf("Первый элемент %d из очереди: ", firstElement);
        System.out.println(myLinkedList);

    }

    static class OwnLinkedList extends LinkedList<Integer> {
        public void enqueue(int element){
            super.addLast(element);
        }

        public Integer dequeue(){
            int firstElement = super.getFirst();
            super.removeFirst();
            return firstElement;
        }

        public Integer first(){
            return super.getFirst();
        }
    }
}
