package pull_up.api.member.dto;

import java.io.Serializable;
import java.util.List;

import pull_up.api.exam.dto.ExamInformationDto;
import pull_up.api.member.entity.MemberAnswer;
import pull_up.api.problem.dto.ProblemDto;

/**
 * DTO for {@link MemberAnswer}
 */
public record MemberAnswerDto(Long id, MemberDto member, ProblemDto problem,
                              ExamInformationDto examInformation, String chosenAnswer,
                              Boolean isCorrect) implements Serializable {

    public static MemberAnswerDto of(Long id, MemberDto member, ProblemDto problem,
        ExamInformationDto examInformation, String chosenAnswer, Boolean isCorrect) {
        return new MemberAnswerDto(id, member, problem, examInformation, chosenAnswer, isCorrect);
    }

    public static MemberAnswerDto from(MemberAnswer entity) {
        List<ProblemDto> problemDtos = List.of();
        return new MemberAnswerDto(entity.getId(), MemberDto.from(entity.getMember()),
            ProblemDto.from(entity.getProblem()),
            ExamInformationDto.from(entity.getExamInformation()), entity.getChosenAnswer(),
            entity.getIsCorrect());
    }

    public static MemberAnswer toEntity(MemberAnswerDto dto) {
        return MemberAnswer.of(MemberDto.toEntity(dto.member()), ProblemDto.toEntity(dto.problem()),
            ExamInformationDto.toEntity(dto.examInformation()), dto.chosenAnswer(),
            dto.isCorrect());
    }
}