## Stack in Java 분석
- 구조
  
    <img width="656" src="https://user-images.githubusercontent.com/60383031/111065453-29ee2f80-84fd-11eb-929e-2a8bc5cda28d.png">
    
    - 자바에서 스택은 Vector 클래스를 상속 받음
    - Vector ?
        - 자바에서 제공하는 리스트 자료구조
        - 한순간에 오직 한 쓰레드에서만 접근 가능
        - 관련 자료
            - https://hyeonstorage.tistory.com/208
            - https://smujihoon.tistory.com/158
    
    
- Description

    <img width="656" src="https://user-images.githubusercontent.com/60383031/111065881-67ec5300-84ff-11eb-8fe3-8cc82524ac4a.png">

    - Vector를 확장한 클래스
        - It extends class Vector with five operations that allow a vector to be treated as a stack
    - Deque 사용 권장
        - A more complete and consistent set of LIFO stack operations is provided by the Deque interface and its implementations
    

        

