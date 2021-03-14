## LinkedList in Java 분석
- 구조


  <img width="656" src="https://user-images.githubusercontent.com/60383031/111062488-73824e80-84ec-11eb-804b-abc638542953.png">
  

- Description
  
    <img width="656" src="https://user-images.githubusercontent.com/60383031/111062615-4b471f80-84ed-11eb-9c25-19950a8a3655.png">

    - 자바의 링크드 리스트는 더블 링크드 리스트임
        - List / Deque 인터페이스 상속 받음
        - 동기화 보장 x
            - 관련 자료
                - https://madplay.github.io/post/java-collection-synchronize
    

- 주요 변수

    <img width="656" src="https://user-images.githubusercontent.com/60383031/111062939-6450d000-84ef-11eb-8bbe-f6f1388a492c.png">

    - Size, First Node, Last Node 변수가 선언되어 있움
    

- 주요 메서드
    - Link First
      
        <img width="656" src="https://user-images.githubusercontent.com/60383031/111063012-babe0e80-84ef-11eb-869b-f6e52ebd1711.png">

        - 삽인된 element 를 첫번째 노드로 선택
        - linkLast() 메서드도 동일한 로직이지만 마지막 노드로 선택하는 것만 차이
    
    - Link before
      
        <img width="656" src="https://user-images.githubusercontent.com/60383031/111063079-256f4a00-84f0-11eb-90d3-0f97913566c7.png">
        
        - succ 변수 노드(not null) 뒤에 새로운 노드 삽입
    
    - Unlink First
      
        <img width="656" src="https://user-images.githubusercontent.com/60383031/111063278-f907fd80-84f0-11eb-8393-e1a1ceb9d87a.png">
        
        - 해당 노드 링크 끊음 
    
    - Get First
      
        <img width="656" src="https://user-images.githubusercontent.com/60383031/111063549-a0d1fb00-84f2-11eb-89c3-a064c9e14b4f.png">
        
        - 첫 번째 노드를 리턴함 
        - 만약 첫 번째 노드가 없으면 `throw new NoSuchElementException()` 
        
    - Remove First
        
        <img width="656" src="https://user-images.githubusercontent.com/60383031/111063641-2e154f80-84f3-11eb-8137-b067eb126c4d.png">
    
        - 첫 번째 노드 링크를 제거
        - 이미 구현된 `unlinkFirst()` 메서드 사용
    
    - IndexOf
      
        <img width="656" src="https://user-images.githubusercontent.com/60383031/111063796-007cd600-84f4-11eb-8902-0e2b347a771d.png">
    
        - input elemenet에 대한 인덱스 값을 리턴, 없다면 -1 리턴
    
    - Contains
      
        <img width="656" src="https://user-images.githubusercontent.com/60383031/111063935-acbebc80-84f4-11eb-9daa-d12b8d62bd52.png">
      
        - Object가 링크트 리스트에 있는지 없는지 체크 
        - `indexOf()` 메서드 사용





