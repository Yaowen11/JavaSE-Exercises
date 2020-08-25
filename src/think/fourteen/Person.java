package think.fourteen;

import java.util.Objects;

/**
 * @author zyw
 */
public class Person {
    public final String first;
    public final String last;
    public final String address;

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }
    @Override
    public String toString() {
        return "Person: " + first + " " + last + " " + address;
    }

    public static class NullPerson extends Person implements Null {
        private NullPerson() { super("None", "None", "None");}

        @Override
        public String toString() {
            return "NullPerson";
        }
    }
    public static final Person NULL = new NullPerson();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(first, person.first) &&
                Objects.equals(last, person.last) &&
                Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last, address);
    }
}
