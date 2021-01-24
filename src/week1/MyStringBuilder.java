package week1;

/*
* 참고
* https://www.youtube.com/watch?v=gc7bo5_bxdA
*/
public class MyStringBuilder {
    private char[] value;
    private int size;
    private int index;

    public MyStringBuilder() {
        size = 1; // 초기 사이즈
        value = new char[size]; // size 만큼 배열 크기 생성
        index = 0; // 초기 인덱스
    }

    public void append(String string) {
        if (string == null) string = "null";
        int length = string.length(); // 문자열 길이를 가져옴
        ensureCapacity(length); // 문자열을 담을 수 있는지 확인 -> 사이즈 확인

        /* 문자열을 담고, 인덱스 증가 */
        for (int i = 0; i < string.length(); i++) {
            value[index] = string.charAt(i);
            index ++;
        }
    }

    private void ensureCapacity(int length) {
        if (index + length > size) {
            size = (size + length) * 2; // 현재 배열 크기와 추가되는 문자열 크기 * 2
            char[] newValue = new char[size]; // 크기 만큼 새로운 배열 생성

            for (int i = 0; i < value.length; i++) {
                newValue[i] = value[i]; // 새로운 배열에 기존 배열 복사
            }
            value = newValue;
        }
    }

    public String toString() {
        return new String(value, 0, index); // 0 to index 까지 문자열로 변환해서 반환
    }

    public static void main(String[] args) {
        MyStringBuilder sb = new MyStringBuilder();
        sb.append("Cracking");
        sb.append(" The");
        sb.append(" Coding");
        sb.append(" Interview");
        System.out.println(sb.toString());


    }
}
