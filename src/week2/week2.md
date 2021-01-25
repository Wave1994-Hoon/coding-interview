## week2 (2021.01.25 월)
#### StringBuilder 구현 분석
- 구조
  <img width="656" alt="stringBuilderStructure" src="https://user-images.githubusercontent.com/60383031/105724767-8e642800-5f6b-11eb-9661-a82f14995587.png">
  
    - 실질적인 구현은 추상 클래스인 `AbstractStringBuilder`에 되어있다.
    
- 초기 생성
    - 초기 생성 시 길이가 16인 배열을 생성
  
