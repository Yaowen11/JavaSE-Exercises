package lam;

import java.util.Optional;

/**
 * @author zyw
 * @date 2020/10/18 23:06
 */
public class OptionalDemo {


    public static void main(String[] args) {
        Optional<Address> address = Optional.of(new Address(Optional.empty(), Optional.of("New York")));
        Optional<Office> office = Optional.of(new Office("OF", address));
        Optional<Company> company = Optional.of(new Company("Door Never Close", office));
        company.flatMap(Company::getOffice)
                .flatMap(Office::getAddress)
                .flatMap(Address::getCity)
                .ifPresent(System.out::println);
    }
}
class Company {
    private String name;
    private Optional<Office> office;
    public Company(String name, Optional<Office> office) {
        this.name = name;
        this.office = office;
    }

    public String getName() {
        return name;
    }

    public Optional<Office> getOffice() {
        return office;
    }
}

class Office {
    private String id;
    private Optional<Address> address;
    public Office(String id, Optional<Address> address) {
        this.id = id;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public Optional<Address> getAddress() {
        return address;
    }
}

class Address {
    private Optional<String> street;
    private Optional<String> city;
    public Address(Optional<String> street, Optional<String> city) {
        this.street = street;
        this.city = city;
    }

    public Optional<String> getCity() {
        return city;
    }

    public Optional<String> getStreet() {
        return street;
    }
}