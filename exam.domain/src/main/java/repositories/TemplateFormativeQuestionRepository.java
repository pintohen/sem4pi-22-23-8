package repositories;

import eapli.framework.domain.repositories.DomainRepository;
import org.domain.model.template.formative.question.TemplateFormativeQuestion;

import java.util.Optional;

public interface TemplateFormativeQuestionRepository extends DomainRepository<Long, TemplateFormativeQuestion>{
    @Override
    <S extends TemplateFormativeQuestion> S save(S entity);

    @Override
    Iterable<TemplateFormativeQuestion> findAll();

    @Override
    Optional<TemplateFormativeQuestion> ofIdentity(Long id);

    @Override
    default boolean containsOfIdentity(Long id) {
        return DomainRepository.super.containsOfIdentity(id);
    }

    @Override
    default boolean contains(TemplateFormativeQuestion entity) {
        return DomainRepository.super.contains(entity);
    }

    @Override
    void delete(TemplateFormativeQuestion entity);

    @Override
    void deleteOfIdentity(Long entityId);

    @Override
    long count();

    @Override
    default long size() {
        return DomainRepository.super.size();
    }

    @Override
    default void remove(TemplateFormativeQuestion entity) {
        DomainRepository.super.remove(entity);
    }

    @Override
    default void removeOfIdentity(Long entityId) {
        DomainRepository.super.removeOfIdentity(entityId);
    }
}
