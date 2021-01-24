## Week1 (21.01.18 월)
#### String vs StringBuilder vs StringBuffer
- String
    - 불변: 한 번 생성되면 변경 불가능
        - final 형이기 때문
    - 정확히는 문자열이 할당된 메모리 공간 변하지 않음
    - 연산자등을 사용하여 다른 문자열 추가 ??
        - 실제로는 새로운 문자열 추가 x
        - 새로운 문자열을 만들고 그 객체를 참조 
        - 기존 문자열은 참조가 사라져 Unreachable 상태 됨 -> 가비지 컬렉션 대상
- StringBuilder
    - Thread safe x
    - 동기화 x
    - 자바 1.5부터 생김
    - 상대적으로 빠름
- StringBuffer
    - Thread safe o
    - 동기화 o
    - 자바 1.0 부터
    - 상대적으로 느림
    
- 속도 
    - StringBuilder > StringBuffer > String
    
- 참고 
    - https://madplay.github.io/post/difference-between-string-stringbuilder-and-stringbuffer-in-java
#### StringPool
- Java에서는 String을 String pool이라는 영역을 따로 두고 여기에 저장
    - Heap 메모리 영역에 저장 (Java 7 이상)
    
- String 생성 방법
    - new 키워드, 생성자
        - 힙 메모리 영역에 위치
    - 따옴표(") 
        - 힙 메모리 영역에 위치한 String pool에 위치
    - example
        ```java
        String s1 = "Cat";
        String s2 = "Cat";
        String s3 = new String("Cat");
        String s4 = new String("Cat");

        System.out.println(s1 == s2);  // true: String pool안에 같은 메모리를 가리킴
        System.out.println(s1 == s3);  // false: 각자 String pool / 힙 메모리를 가리킴
        System.out.println(s3 == s4);  // false: 각자 본인의 메모리를 별도로 할당 받음 
        ```
    - '==' 연산자는 메모리 주소를 비교, String 값을 비교할 때는 equals() 사용
    - 참고
        - https://readystory.tistory.com/140
    

