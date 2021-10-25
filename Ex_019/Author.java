package w4_23102021.Ex_019;

public class Author {

    private String surname;
    private String nationality;

    public Author(String surname, String nationality) {
        this.surname = surname;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "name: "+this.surname;
    }
}
