## Queue in Java 분석
- 구조

    <img width="656" src="https://user-images.githubusercontent.com/60383031/111064481-8c443180-84f7-11eb-9063-6e23241ce37a.png">

    - Collection 인터페이스를 상속 받음
    
    
- Description
  
    <img width="656" src="https://user-images.githubusercontent.com/60383031/111064739-1345d980-84f9-11eb-87ac-c9164b3530bb.png">
    
    - 두 종류의 연산이 있음
        - Throw Exception
            - Insert: add()
            - Remove: remove()
            - Examine: element()
        - Return value
            - Insert: offer() -> return true false
            - Remove: poll()  -> return null
            - Examine: peek() -> return null
    
    
- 주요 메서드 In Linked List Class
  
     <img width="656" src="https://user-images.githubusercontent.com/60383031/111065098-47ba9500-84fb-11eb-8712-9e48bfb2df09.png">
    
    - 자바에서 큐는 링크드리스트 클래스에 구현되어 있음
    - peek()은 위에서 언급되었지만, 실패 시 `return null`을 함    




