package my.dev.com.algoritms.search.graph.bfs.search;

import java.util.Objects;

public class Person {

    private String fullName;

    private Hobby hobby;

    public Person(String fullName, Hobby hobby) {
        this.fullName = fullName;
        this.hobby = hobby;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return fullName.equals(person.fullName) &&
                hobby == person.hobby;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, hobby);
    }
}
