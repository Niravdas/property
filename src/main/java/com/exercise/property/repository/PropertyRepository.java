package com.exercise.property.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exercise.property.entity.PropertyEntity;

/**
 * @author Niravdas
 *
 */
@Repository
public interface PropertyRepository extends CrudRepository<PropertyEntity, Long>, JpaSpecificationExecutor<PropertyEntity> {
	@Transactional
	@Modifying
	@Query("UPDATE PropertyEntity SET approved=true WHERE id=:id")
	void approve(@Param("id") Long id);
	
	public default List<PropertyEntity> findByCriteria(PropertyEntity propertyEntity) {
        return findAll(new Specification<PropertyEntity>() {
			@Override
			public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList();
				if(propertyEntity.getName()!=null) {
                    predicates.add(criteriaBuilder.or(criteriaBuilder.like(root.get("name"), "%" + propertyEntity.getName() + "%")));
                }
				if(propertyEntity.getAddress()!=null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("address"), "%" + propertyEntity.getAddress() + "%")));
				}
				if(propertyEntity.getCity()!=null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("city"),"%" + propertyEntity.getCity() + "%")));
				}
				if(propertyEntity.getOwnerName()!=null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("ownerName"),"%" + propertyEntity.getOwnerName() + "%")));
				}
				if(propertyEntity.isApproved()!=null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("approved"), propertyEntity.isApproved())));
				}
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		});
    }
}
