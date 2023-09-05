package org.persistence;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import org.domain.model.template.formative.question.TemplateFormativeQuestion;
import repositories.TemplateFormativeQuestionRepository;

import java.util.Map;
import java.util.Optional;

public class JpaAutoTxTemplateFormativeQuestionRepository extends JpaAutoTxRepository<TemplateFormativeQuestion, Long, Long>
        implements TemplateFormativeQuestionRepository {
    public JpaAutoTxTemplateFormativeQuestionRepository(String persistenceUnitName, String identityFieldName) {
        super(persistenceUnitName, identityFieldName);
    }

    public JpaAutoTxTemplateFormativeQuestionRepository(String persistenceUnitName, Map properties) {
        super(persistenceUnitName, properties, "id");
    }

    public JpaAutoTxTemplateFormativeQuestionRepository(TransactionalContext tx, String identityFieldName) {
        super(tx, identityFieldName);
    }

    @Override
    public <S extends TemplateFormativeQuestion> S save(S entity) {
        return this.repo.save(entity);
    }

    @Override
    public Iterable<TemplateFormativeQuestion> findAll() {
        return this.repo.findAll();
    }

    @Override
    public Optional<TemplateFormativeQuestion> ofIdentity(Long id) {
        return this.repo.ofIdentity(id);
    }

    @Override
    public void delete(TemplateFormativeQuestion entity) {
        this.repo.delete(entity);
    }

    @Override
    public void deleteOfIdentity(Long entityId) {
        this.repo.deleteOfIdentity(entityId);
    }

    @Override
    public long count() {
        return this.repo.count();
    }
}
