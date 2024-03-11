package zadatak2;

public class Test {

    public static void main(String[] args) {
        Student s1 = new Student("marko", "markovic", "mm22002", 9.6);
        StudentSaV s2 = new StudentSaV("ana", "nikolic", "mv21021", 9.7, 10);
        StudentSaM s3 = new StudentSaM("milos", "markovic", "mm22212", 7, 6);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
    
}
