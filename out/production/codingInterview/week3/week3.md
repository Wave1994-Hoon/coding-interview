## Week1 (21.02.09 월)
#### 해쉬 테이블
- 해시함수를 사용하여 변환한 값을 index로 삼아 key와 value를 저장하는 자료구조, 기본연산으로는 탐색, 삽입, 삭제가 있다.
- channing
    - 충돌이 발생했을 때 이를 동일한 버킷(Bucket)에 저장하는데 이를 연결리스트 형태로 저장하는 방법을 말한다
    - 뒤에 연결함으로써 충돌을 처리
    
- Open Addressing
    - 동일한 주소에 다른 데이터가 있을 경우 다른 주소도 이용할 수 있게 하는 기법이다.
    
    
#### Garbage Collector
- JVM (Java Virtual Machine)
    - 운영체제의 메모리 영역에 접근하여 메모리를 관리하는 프로그램, 메모리 관리, Garbage Collector 수행
    
- Garbage Collector
    - 동적으로 할당한 메모리 영역 중 사용하지 않은 여역을 탐지하여 해제하는 기능
    - Stack
        - 정적으로 할당한 메모리 영역
        - 원시 타입의 데이터가 값과 함께 할당, Heap영역에 생성된 Object 타입의 데이터의 참조 값 할당
    - Heap
        - 동적으로 할당한 메모리 영역
        - 모든 object 타입의 데이터가 할당, Heap 영역의 Object를 가리키는 참조 변수가 stack에 할당 
    - 과정
        -  1 GC가 Stack의 모든 변수를 스캔하면서 각각 어떤 객체를 참조하고 있는지 찾아서 마킹 - Mark
        -  2 Reachable Object가 참조하고 있는 객체도 찾아가서 마킹 - Mark
        -  3 마킹되지 않은 객체를 Heap에서 제거 - Sweep
    - 언제 ?
        - Heap 의 구조
            - New Generation
                - Eden: 새로운 객체가 생성되면 해당 영역에 할당, Eden 영역이 모두 할당 되면 Minor GC 발생 
                - Servival 0: Eden 영역의 Reachable 객체는 Servival 0로 옮겨짐, Eden 영역의 Unreachable 객체는 메모리에서 해제 
                - Servival 1: Servival 0에서 살아남은 객체들은 Servival 1로 이동, 이동한 객체는 Age 값 증가 
                    - Servival 0, 1 둘 중 하나는 항상 비어있는 상태
                    - Eden 영역의 Reachable 객체는 Survival 1으로 옮겨짐 
                    - Servival 1 이 모두 차면 mark and sweap 과정이 발생 하고 다시 살아남은 객체들은 0으로 이동 그리고 Age 증가
            - Old Generation
                - 특정 Age 값이 되면 해당 영역으로 이동 - Promotion 
                - Old Generation 이 모두 차면 역시 mark and sweep 과정 발생 - Major GC
    - 종류
        - Serial GC
            - GC를 처리하는 스레드는 1개이다.
            - CPU 코어가 1개만 있을 때 사용하는 방식
            - Mark-Compact collection 알고리즘 사용 
        - Parallel GC
            - GC를 처리하는 스레드가 여러 개 이다.
            - Serial GC보다 빠르게 객체를 처리할 수 있다.
            - Parallel GC는 메모리가 충분하고 코어의 개수가 많을 때 사용하면 좋다. 
        - Concurrent Mark Sweep GC
            - Stop-The-World ??
                - GC를 실행하기 위해 JVM이 애플리케이션 실행을 멈추는 것, GC를 실행하는 스레드를 제외한 나머지 스레느는 모두 작업은 멈춤
                - GC 작업을 완료한 이후에 중단한 작업을 다시 시작 
            - stop-the-world 시간이 짧다, 애플리케이션의 응답 시간이 빨라야 할 떄 CMS GC 사용
            - 다른 GC 방식보다 메모리와 CPU 더 많이 사용, Compaction 단계 제공 x
        - G1 GC
            - 각 영역을 Region 영역(바둑판과 같은)으로 나눈다
            - GC가 일어날 때, 전체 영역을 탐색하지 않는다.
      
#### Array 와 가변 크기 배열
- 배열형 리스트
    - Vector
        - 한순간에 오직 한 쓰레드에서만 접근 가능
    - ArrayList
        - 개념적인 크기가 조절하는 배열과 가장 가까움, 인덱스 가짐
        - 가장 효율적인 리스트
        - Vector 보다 성능에서 상대적 우위
            - 동기화에 필요한 작업을 할 필요가 없으니
        - 시간복잡도
            - 추가 및 삭제: O(1), 최악의 경우 O(n)
                - 평상시에는 여유롭게 공간을 가져가지만 그게 아닐 경우 elemenet를 추가 후 나머지 값을 붙여서 메모리에 재 할당 함, 혹은 중간에 추가할 경우
            - 조회: O(1) -> Index로 조회하는 경우, O(n) -> contains로 조회하는 경우
- 노드형 리스트
    - LinkedList
        - 시간복잡도
            - 추가 및 삭제: O(1), 만약 리스트 중간에 추가(삭제)를 할 경우 O(n), 실질적으로는 어떤 노드가 어떤 값을 가지고 있는지 찾아야되니 O(n)
            - 조회: O(N)