## week2 (2021.01.25 월)
#### StringBuilder 구현 분석
- 구조
    - 실질적인 구현은 추상 클래스인 `AbstractStringBuilder`에 되어있다.
    

![test](https://user-images.githubusercontent.com/60383031/105724767-8e642800-5f6b-11eb-9661-a82f14995587.png)
      
- 초기 생성
    - 초기 생성 시 길이가 16인 배열 생성 (생성자 호출 시 )
    - 구현 코 
    ```java
    /* StringBuilder*/
    public StringBuilder() {
        super(16);
    }
    
    /* AbstractStringBuilder */
    AbstractStringBuilder(int capacity) {
        value = new char[capacity];
    }
    ```
  
- 배열 크기 증가 
    - append, insert 같은 함수 호출 시 배열이 이미 꽉 차있다면 `ensureCapacity` 메서드를 호출 후 조건에 부합하면 `ensureCapacityInternal` 호출
    - minimumCapacity - value.length > 0 조건에 부합하면 newArray(이전 배열 크기 * 2) 생성 후 이전 배열 복사
        - value = Arrays.copyOf(value, newCapacity(minimumCapacity));
        - 구현 코드
            ```java
            public void ensureCapacity(int minimumCapacity) {
                if (minimumCapacity > 0)
                    ensureCapacityInternal(minimumCapacity);
            }
          
            private void ensureCapacityInternal(int minimumCapacity) {
                // overflow-conscious code
                if (minimumCapacity - value.length > 0) {
                    value = Arrays.copyOf(value,
                    newCapacity(minimumCapacity));
                }
            }
            ```
          
    - 맥스 사이즈
        - private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
        - 참고
            - ibm.com/developerworks/java/library/j-codetoheap/index.html
            - https://stackoverflow.com/questions/35756277/why-the-maximum-array-size-of-arraylist-is-integer-max-value-8