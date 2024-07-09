package pull_up.api.problem.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import pull_up.api.problem.entity.Problem;

/**
 * DTO for {@link Problem}
 */
public record ProblemDto(Long id, String entry, String category, String type, String question,
                         String explain, String choice1, String choice2, String choice3,
                         String choice4, String choice5, String answer, String answerExplain,
                         Integer totalAttempts, Integer incorrectAttempts, Double incorrectRate,
                         LocalDateTime deletedAt) implements
    Serializable {

    public static ProblemDto of(Long id, String entry, String category, String type, String question, String explain, String choice1, String choice2, String choice3, String choice4, String choice5, String answer, String answerExplain, Integer totalAttempts, Integer incorrectAttempts, Double incorrectRate, LocalDateTime deletedAt) {
        return new ProblemDto(id, entry, category, type, question, explain, choice1, choice2, choice3, choice4, choice5, answer, answerExplain, totalAttempts, incorrectAttempts, incorrectRate, deletedAt);
    }

    public static ProblemDto from(Problem entity) {
        return new ProblemDto(entity.getId(), entity.getEntry(), entity.getCategory(), entity.getType(), entity.getQuestion(), entity.getExplain(), entity.getChoice1(), entity.getChoice2(), entity.getChoice3(), entity.getChoice4(), entity.getChoice5(), entity.getAnswer(), entity.getAnswerExplain(), entity.getTotalAttempts(), entity.getIncorrectAttempts(), entity.getIncorrectRate(), entity.getDeletedAt());
    }

    public static Problem toEntity(ProblemDto dto) {
        return Problem.of(dto.entry(), dto.category(), dto.type(), dto.question(), dto.explain(), dto.choice1(), dto.choice2(), dto.choice3(), dto.choice4(), dto.choice5(), dto.answer(), dto.answerExplain(), dto.totalAttempts(), dto.incorrectAttempts(), dto.incorrectRate());
    }

}