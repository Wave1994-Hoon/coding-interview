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
        - 이유
            - 구조적 관점
                - Stack is a class, Deque is an interface.
                - Only one class can be extended, whereas any number of interfaces can be implemented by a single class in Java (multiple inheritance of type).
                - Using the Deque interface `removes the dependency` on the concrete Stack class
            - 기능적 관점
                - Stack extends the Vector class, `which allows you to access element by index`.
              
            - 성능적 관점
                - The Vector class that Stack extends is basically the `"thread-safe"` version of an ArrayList.
                - `The synchronizations` can potentially cause a significant performance hit to your application

            - 관련 url = https://stackoverflow.com/questions/12524826/why-should-i-use-deque-over-stack
            
    

        

