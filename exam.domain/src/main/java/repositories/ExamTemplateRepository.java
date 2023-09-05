package repositories;

import eapli.framework.domain.repositories.DomainRepository;
import org.domain.model.Course;
import org.domain.model.examtemplate.domain.ExamTemplate;
import org.domain.model.examtemplate.domain.ExamTitle;
import org.usermanagement.domain.model.User;

import java.util.Optional;

public interface ExamTemplateRepository extends DomainRepository<ExamTitle, ExamTemplate> {

    ExamTemplate save(ExamTemplate exam);

    Optional<ExamTemplate> ofIdentity(ExamTitle id);

    Iterable<ExamTemplate> findAll();

    Iterable<ExamTemplate> findExamsThatIHadCreated(User teacher);

    Iterable<ExamTemplate> findByCourse(Course course);

    Iterable<ExamTemplate> findFutureExams(Course course);

    Optional<ExamTemplate> findByTitle(ExamTitle title);
}
