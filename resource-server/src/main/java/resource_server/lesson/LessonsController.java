package resource_server.lesson;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class LessonsController {

    @GetMapping("/lessons")
    public List<Lesson> getLessons() {
        return Arrays.asList(
                new Lesson(
                        "Beginner Golf Basics",
                        "An Intro to fundamentals of golf",
                        "John Doe",
                        LocalDateTime.of(2024, 11, 5, 10, 0)
                ),
                new Lesson(
                        "Advanced Golf Swings",
                        "Improving swing with strength",
                        "Jane Smith",
                        LocalDateTime.of(2024, 11, 6, 14, 0)
                )
        );
    }
}
