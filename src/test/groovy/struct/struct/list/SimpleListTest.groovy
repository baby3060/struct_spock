package struct.struct.list

import struct.struct.common.Node
import struct.struct.list.SimpleLinkedList

import spock.lang.Specification
import org.junit.experimental.categories.Category
import spock.lang.Unroll 

@Category
class SimpleListTest extends Specification { 
    def "단일 연결 리스트 크기 확인_처음 크기는 0"() {
        given : SimpleLinkedList list = new SimpleLinkedList()

        when : def count = list.count();

        then : count == 0
    }

    def "단일 연결 리스트 Insert 테스트"() {
        given : SimpleLinkedList list = new SimpleLinkedList()

        when : def count = list.count()

        then : count == 0

        Node newNode = new Node(1)   
        list.insertNode(newNode)

        when : count = list.count()
        then : count == 1

        Node newNode2 = new Node(2) 
        list.insertNode(newNode2)

        when : count = list.count();
        then : count == 2
    }
    
    @Unroll
    def "단일 연결 리스트 Insert 테스트_where 절 사용[#idx번째 데이터 #value 비교]"() {
        given : SimpleLinkedList list = new SimpleLinkedList()

        Node newNode = new Node(1)   
        list.insertNode(newNode)
        newNode = new Node(2)   
        list.insertNode(newNode)
        newNode = new Node(3)   
        list.insertNode(newNode)

        expect : list.getNode(idx).getValue().equals(value);

        where : 
        idx | value
        1 | 1
        2 | 2
        3 | 3
    }

    def "단일 연결 리스트 Exception 테스트"() {
        given : SimpleLinkedList list = new SimpleLinkedList()

        when : Node overNode = list.getNode(3);

        then : thrown RuntimeException

        Node newNode = new Node(1)   
        list.insertNode(newNode)

        // 0 이하의 Node는 Head Node 
        when : Node minusNode = list.getNode(-1);

        then : minusNode.getNext().equals(newNode);
    }

    def "삭제 테스트"() {
        given : SimpleLinkedList list = new SimpleLinkedList()

        Node newNode = new Node(1)
        Node newNode2 = new Node(2)
        Node newNode3 = new Node(3)
        Node newNode4 = new Node(4)
        Node newNode5 = new Node(5)

        list.insertNode(newNode)
        list.insertNode(newNode2)
        list.insertNode(newNode3)
        list.insertNode(newNode4)
        list.insertNode(newNode5)

        when : def count = list.count()

        then : (count == 5)

        when : def getNode = list.getNode(3)

        then : getNode.getValue() == 3

        
    }
}