package course02.lesson01;

import java.util.Objects;

public class Human {
    public String name;
    private String town;
    private int yearOfBirth;
    public String jobTitle;

    public Human(String name, String town, int yearOfBirth, String jobTitle) {
        if (name == null || name.isEmpty()) {
            this.name = "'The information is missing.'";
        } else {
            this.name = name;
        }
        if (town == null || town.isEmpty()) {
            this.town = "'The information is missing.'";
        } else {
            this.town = town;
        }
        if (yearOfBirth < 0) {
            this.yearOfBirth = 0;
        } else {
            this.yearOfBirth = yearOfBirth;
        }
        if (jobTitle == null || jobTitle.isEmpty()) {
            this.jobTitle = "'The information is missing.'";
        } else {
            this.jobTitle = jobTitle;
        }
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        if (town != null && !town.isEmpty()) {
            this.town = town;
        } else {
            this.town = "'The information is missing.'";
        }
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        if (yearOfBirth < 0)  {
            this.yearOfBirth = 0;
        } else {
            this.yearOfBirth = yearOfBirth;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return yearOfBirth == human.yearOfBirth && Objects.equals(name, human.name) && Objects.equals(town, human.town) && Objects.equals(jobTitle, human.jobTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, town, yearOfBirth, jobTitle);
    }

    @Override
    public String toString() {
        return "Hello! My name is " + name + ". " + "I'm from " + town + ". " + "I was born in " + yearOfBirth + ". " +
                "I work for a position: " + jobTitle + ". " + "Nice to meet you!";
    }
}
