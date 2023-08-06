public class Pair {
     private String identification;
     private String description;

    public Pair(String identification, String description) {
        this.identification = identification;
        this.description = description;
    }

    public String getIdentification() {
        return identification;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "{" +
                "ident='" + identification + '\'' +
                ", desc='" + description + '\'' +
                '}';
    }
}
