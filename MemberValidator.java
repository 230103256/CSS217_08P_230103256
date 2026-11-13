package task09;

import java.util.Set;

/** Подсистема: проверка активных студентов. */
public class MemberValidator {
    private final Set<String> activeStudents = Set.of("S001", "S002", "S003");

    public boolean isActive(String studentId) { return activeStudents.contains(studentId); }
}
