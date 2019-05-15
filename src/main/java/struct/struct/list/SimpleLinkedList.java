package struct.struct.list;

import struct.struct.common.Node;

import java.util.concurrent.locks.ReentrantLock;

public class SimpleLinkedList {
    private Node head;

    private final ReentrantLock lock = new ReentrantLock();

    public SimpleLinkedList() {
        this.head = new Node();
    }

    /**
     * @return List에 저장된 내역
     */
    public int count() {
        int count = 0;

        lock.lock();

        try {
            Node target = head;

            while( target.getNext() != null ) {
                count++;
                target = target.getNext();
            }
        } finally {
            lock.unlock();
        }

        return count;
    }

    /**
     * 처음에는 head의 next 그 이후로는 가장 마지막에 계속해서 달림
     * @param newNode 가장 마지막에 달리는 Node
     */
    public void insertNode(Node newNode) {
        lock.lock();

        try {
            if( head.getNext() == null ) {
                head.setNext(newNode);
            } else {
                this.getNode(count()).setNext(newNode);
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * 가장 마지막에 삽입함
     * Head의 Next가 null일 경우 별 상관없음, 만약 있다면 새로운 노드의 Next를 head의 Next로
     */
    public void insertNodeFirst(Node newNode) {
        if( head.getNext() == null ) {
            
        } else {
            newNode.setNext(head.getNext());
        }

        head.setNext(newNode);
    }

    /**
     * @param idx idx번째 Node(0 : head, 1부터 시작)
     * @return idx번째 Node 반환
     */
    public Node getNode(int idx) {
        lock.lock();

        try {
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
        } finally {
            lock.unlock();
        }
    }


    /**
     * Head의 Next부터 제거함
     */
    public void deleteFirst() {
        if( this.count() > 0 ) {
            lock.lock();

            try {
                Node nextHeadnext = head.getNext().getNext();

                if(nextHeadnext != null) {
                    head.setNext(nextHeadnext);
                }

            } finally {
                lock.unlock();
            }

        } 
    }

    /**
     * 가장 마지막에서부터 삭제
     */
    public void deleteLast() {
        int count = this.count();
        if( count > 0) {
            Node target = null;
            try {
                target = getNode(count - 1);
            } catch(Exception e) {
                target = head;
            }

            target.setNext(null);
        }
    }

    public void deleteIdx(int idx) {
        int count = this.count();

        if( count > 0) { 
            if( idx == 0 ) {
                System.out.println("삭제 인덱스는 1번부터 시작입니다.");
            } else {
                Node delNode = getNode(idx);
                if( delNode != null ) {
                    // 0이나 -일 경우 head를 가지고옴
                    Node preNode = getNode(idx - 1);

                    // 이전 노드의 다음 노드 조정(null로 설정할 수도 있음)
                    preNode.setNext(delNode.getNext());
                }
            }
        }
    }

}