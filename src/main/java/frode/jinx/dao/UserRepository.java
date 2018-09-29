package frode.jinx.dao;

import frode.jinx.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

/**
 * @Author: frode
 * @Date: 2018/9/15 9:57
 * @Description:
 */

@Qualifier("userRepository")
@Table(name="sys_user")
@Repository
public interface UserRepository extends JpaRepository<User,Long> {


     User findOne(Long id);

//     User save(User u);

    @Query("select t from User t where t.name=:name")//这是标准写法 t是table的意思
    User findUserByName(@Param("name") String name);//@Param代表 :name

}
