package think.fourteen;

public class Position {

    private String title;

    private Person person;

    public Position(String jobTitle) {
        title = jobTitle;
        person = Person.NULL;
    }

    public Position(String jobTitle, Person employee) {
        title = jobTitle;
        person = employee == null ? Person.NULL : employee;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person == null ? Person.NULL : person;
    }

    @Override
    public String toString() {
        return "Position{" +
                "title='" + title + '\'' +
                ", person=" + person +
                '}';
    }
}
