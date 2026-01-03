package resource_server.lesson;

import java.time.LocalDateTime;

 // Class that contains protected resources (Lessons)
public record Lesson(
        String title,
        String description,
        String instructor,
        LocalDateTime schedule) {
}
