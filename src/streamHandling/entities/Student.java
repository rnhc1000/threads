package streamHandling.entities;

public record Student(int id,
                      String firstName,
                      String lastName,
                      int age,
                      String gender,

                      String department,
                      int joinedYear,
                      String city,
                      int rank
) {
}
