package chapter1.phonenumber;

public class PhoneNumber {

    public final String phoneNumber;

    public PhoneNumber(String rawPhoneNumber) {
        // 숫자가 아닌 문자들만 제거한다.
        this.phoneNumber = rawPhoneNumber.replaceAll("[^0-9]", "");
    }

    // IntelliJ를 포함한 많은 IDE에서 toString() 메서드를 자동으로 작성해준다.
    // test를 위해 toString() 메서드를 추가한다.
    @Override
    public String toString() {
        // 객체를 구성하는 멤버 변수들을 문자열로 구성하여 반환하는 toString() 메서드를 오버라이드한다.
        return "PhoneNumber{" +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    // 따라서 다음과 같이 PhoneNumber 클래스에 equals() 메서드를 오버라이딩해준다.
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PhoneNumber)) return false;
        return phoneNumber.equals(((PhoneNumber) o).phoneNumber);
    }
}
