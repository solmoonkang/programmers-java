package chapter1.phonenumber;

import java.util.ArrayList;
import java.util.List;

public class Person {

    // 해당 클래스에서 name과 phoneNumbers는 생성자에서 값이 한 번 정해진 이후, 값이 변경되지 않는다.
    // 이런 경우, final을 붙여 이후에 의도치 않게 값이 변경되는 것을 방지할 수 있다.

    // String처럼 값이 불변인 객체는 외부에서 읽기만 할 수 있으므로 public으로 선언한다.
    public final String name;

    // List처럼 외부에서 접근해서 임의롤 값을 바꿀 수 있는 변수들은 private로 선언하여 클래스 내부에서 의도한 대로만 해당 객체를 사용한다.
    private final List<PhoneNumber> phoneNumbers;

    public Person(String name) {
        this.name = name;
        this.phoneNumbers = new ArrayList<>();
    }

    // 전화번호를 PhoneNumber 클래스로 나타내는 대신 String으로 표현했다면, addPhoneNumber() 메서드는 어떤 형식의 문자열이든 가리지 않고 입력받을 것이다.
    // 이를 방지할 수 있는 여러 조건을 다음과 같이 addPhoneNumber() 메서드에 추가하면, 메서드가 전화번호를 추가하는 것뿐만 아니라 전화번호 형식까지 검사한다.
    public void addPhoneNumber(PhoneNumber phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }

    // phoneNumbers에 phoneNumber가 있는지 contain() 메서드로 비교한다. contain() 메서드는 equals() 메서드를 사용하여 객체를 비교한다.
    // 따라서 equals() 메서드는 별도의 오버라이딩이 없으면, 객체가 같을 때만 true를 반환한다.
     public boolean hasPhoneNumber(PhoneNumber phoneNumber) {
         return phoneNumbers.contains(phoneNumber);
     }

    // test를 위해 toString() 메서드를 추가한다.
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
