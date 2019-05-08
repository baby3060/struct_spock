package struct.struct.list;

import struct.struct.common.Node;

public class SimpleLinkedList {
    private Node head;

    public SimpleLinkedList() {
        this.head = new Node();
    }

    /**
     * @return List에 저장된 내역
     */
    public int count() {
        int count = 0;

        Node target = head;

        while( target.getNext() != null ) {
            count++;
            target = target.getNext();
        }

        return count;
    }

    /**
     * 처음에는 head의 next 그 이후로는 가장 마지막에 계속해서 달림
     * @param newNode 가장 마지막에 달리는 Node
     */
    public void insertNode(Node newNode) {
        if( head.getNext() == null ) {
            head.setNext(newNode);
        } else {
            this.getNode(count()).setNext(newNode);
        }
    }

    /**
     * @param idx idx번째 Node(0 : head, 1부터 시작)
     * @return idx번째 Node 반환
     */
    public Node getNode(int idx) {
        if( idx <= 0 ) {
            return head;
        } else {
            int listCnt = count();
            if( listCnt < idx ) {
                throw new RuntimeException("List의 크기(" + listCnt + ")보다 더 큰 Index(" + idx + ")를 요구하였습니다.");
            } else {
                int hitCnt = 0;
                Node target = head;

                while( target.getNext() != null ) {
                    if( hitCnt == idx ) {
                        break;
                    } else {
                        hitCnt++;
                        target = target.getNext();
                    }
                }

                return target;
            }
        }
    }
}