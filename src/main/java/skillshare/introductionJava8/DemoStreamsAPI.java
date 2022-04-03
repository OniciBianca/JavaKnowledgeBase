package skillshare.introductionJava8;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class DemoStreamsAPI {

    public static void main(String[] args) {
        List<StudentExamResults> results = getStudentResults();
        System.out.println(results);

        Set<String> result = results.stream()
                .filter(studentExamResults -> studentExamResults.roundedPercentage >= 75)
                .map(StudentExamResults::getName)
                .collect(Collectors.toSet());

        System.out.println("Top students are: ");
        result.forEach(System.out::println);

        List<String> result2 = results.stream()
                .filter(studentExamResults -> studentExamResults.roundedPercentage >= 50)
                .map(StudentExamResults::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Top students are: ");
        result2.forEach(System.out::println);
    }

    private static List<StudentExamResults> getStudentResults() {
        Exam javaCertif = new Exam("Java 8 Certification");
        Exam mavenCertif = new Exam("Maven Certification");
        Exam apacheCertif = new Exam("Apache Certification");

        List<StudentExamResults> results = new LinkedList<>();
        results.add(new StudentExamResults(56, "Alin", javaCertif));
        results.add(new StudentExamResults(72, "Alin", mavenCertif));

        results.add(new StudentExamResults(56, "Bianca", javaCertif));

        results.add(new StudentExamResults(72, "Oana", mavenCertif));
        results.add(new StudentExamResults(88, "Oana", javaCertif));
        results.add(new StudentExamResults(99, "Oana", apacheCertif));
        return results;
    }

    static class StudentExamResults {
        int roundedPercentage;
        String name;
        Exam exam;

        public StudentExamResults(int roundedPercentage, String name, Exam exam) {
            this.roundedPercentage = roundedPercentage;
            this.name = name;
            this.exam = exam;
        }

        public int getRoundedPercentage() {
            return roundedPercentage;
        }

        public String getName() {
            return name;
        }

        public Exam getExam() {
            return exam;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StudentExamResults that = (StudentExamResults) o;
            return roundedPercentage == that.roundedPercentage && Objects.equals(name, that.name) && Objects.equals(exam, that.exam);
        }

        @Override
        public int hashCode() {
            return Objects.hash(roundedPercentage, name, exam);
        }

        @Override
        public String toString() {
            return "StudentExamResults{" +
                    "roundedPercentage=" + roundedPercentage +
                    ", name='" + name + '\'' +
                    ", exam=" + exam +
                    '}';
        }
    }

    static class Exam {
        String name;

        public Exam(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Exam exam = (Exam) o;
            return Objects.equals(name, exam.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Exam{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
