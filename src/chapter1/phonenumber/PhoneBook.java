package chapter1.phonenumber;

import java.util.HashSet;
import java.util.Set;

public class PhoneBook {

    // PhoneBook 클래스는 단순히 여러 사람을 담는 용도이므로 여러 개의 Person 객체를 가지고 있는다.
    // 따라서 Person 객체를 List로 관리해준다. -> 그러나, 같은 객체를 여러 번 추가하면 모두 등록된다.
    // 이를 해결하기 위해 같은 객체는 여러 번 등록하지 못하게 중복을 제거해야 한다. 따라서 List<Person>을 Set<Person>으로 변경한다.
    private final Set<Person> people;

    public PhoneBook() {
        this.people = new HashSet<>();
    }

    // person을 추가하는 메서드이다.
    public void addPerson(Person person) {
        people.add(person);
    }

    // phoneNumber를 이용해서 person을 찾는 메서드이다.
    // people에 포함된 person 객체 중 hasPhoneNumber() 메서드를 사용하여 전화번호를 포함하고 있는 person 객체를 반환한다.
    public Person search(PhoneNumber phoneNumber) {
        return people.stream()                                  // Set<Person>을 Stream<Person>으로 변환한다.
                .filter(p -> p.hasPhoneNumber(phoneNumber))     // phoneNumber를 가지는 person을 찾는다.
                .findFirst()                                    // phoneNumber를 가지는 person 객체가 있는지 검사한다.
                .orElse(null);                                  // 만약 없다면, null을 반환한다.
    }

    // test를 위해 toString() 메서드를 추가한다.
    @Override
    public String toString() {
        return "PhoneBook{" +
                "people=" + people +
                '}';
    }
}
