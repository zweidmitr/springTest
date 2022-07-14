package com.zwei.spring.database.repository;

import com.zwei.spring.database.entity.Role;
import com.zwei.spring.database.entity.User;
import com.zwei.spring.database.pool.ConnectionPool;
import com.zwei.spring.dto.PersonalInfo;
import com.zwei.spring.dto.PersonalInfo2;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, FilterUserRepository {

    @Query("select u from User u "
            + "where u.firstname like %:firstname% and u.lastname like %:lastname%")
    List<User> findAllBy(String firstname, String lastname);

    @Query(value = "SELECT u.* FROM users u WHERE u.username = :username",
            nativeQuery = true)
    List<User> findAllByUsername(String username);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update User u "
            + "set u.role = :role "
            + "where u.id in (:ids)")
    int updateRole(Role role, Long... ids);

    Optional<User> findTopByOrderByIdDesc();

    @QueryHints(@QueryHint(name = "org.hibernate.fetchSize", value = "50"))
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<User> findTop3ByBirthDateBefore(LocalDate birthdate, Sort sort);

    // Collection, Stream
    // Streamable, Slice, Page
//    @EntityGraph("User.company")
    @EntityGraph(attributePaths = {"company", "company.locales"})
    @Query(value = "select u from User u",
            countQuery = "select count(distinct u.firstname) from User u")
    Page<User> findAllBy(Pageable pageable);

    //    List<PersonalInfo> findAllByCompanyId(Integer companyId);
    //    <T> List<T> findAllByCompanyId(Integer companyId, Class<T> clazz);
    @Query(value = "SELECT firstname, lastname, birth_date birthDate "
            + "FROM users "
            + "WHERE company_id = :companyId",
            nativeQuery = true)
    List<PersonalInfo2> findAllByCompanyId(Integer companyId);
}
