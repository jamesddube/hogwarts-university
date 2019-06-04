package com.jamesdube.hogwarts.subjectservice.utils;

import com.jamesdube.hogwarts.subjectservice.data.domain.Subject;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SubjectSpecification {

    public static Specification<Subject> filterByWrapper(SubjectWrapper subjectWrapper){

        return (Specification<Subject>) (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if(subjectWrapper.getCode() != null){
                Predicate p = criteriaBuilder.equal(root.get("code"), subjectWrapper.getCode());
                predicates.add(p);
            }

            if(subjectWrapper.getName() != null){
                Predicate p = criteriaBuilder.equal(root.get("name"), subjectWrapper.getName());
                predicates.add(p);
            }

            if(subjectWrapper.getType() != null){
                Predicate p = criteriaBuilder.equal(root.get("type"), subjectWrapper.getType());
                predicates.add(p);
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}