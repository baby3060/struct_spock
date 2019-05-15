# spock을 이용한 알고리즘과 자료구조 테스트

> Document 툴로는 Javadoc와 Javascript 용이긴 하지만 groc를 사용해봄(groc의 경우 Javadoc용 애노테이션을 사용하면 디자인이 좋지 않음)

## 단순 구현이 아닌 spock을 사용하여 구현된 내역 테스트하고 점차 발전 시킴.
## thread-safe 염두에 두고 진행해야 함(Java 8의 concurrent.lock 패키지의 ReentrantLock 클래스 사용).

### 자료구조

#### List

- [ ] 단순 연결 리스트