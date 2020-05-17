package think.two;

class Dog {
    String name;
    String says;
    Dog (String name, String says) {
        this.name = name;
        this.says = says;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSays() {
        return says;
    }

    public void setSays(String says) {
        this.says = says;
    }
}
/**
 * @author zyw
 */
public class EqualsMethod {
    public static void main(String[] args) {
        Dog dog = new Dog("spot", "ruff!");
        Dog dog1 = new Dog("scruffy", "wurf");
        System.out.println(dog.says);
        System.out.println(dog1.says);
        Dog dog2 = dog;
        System.out.println(dog == dog2);
        System.out.println(dog.equals(dog2));
    }
}
