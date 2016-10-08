package us.waw.gaara.dao;

import org.springframework.transaction.annotation.Transactional;
import us.waw.gaara.dao.entity.User;

/**
 * Created by lenn on 16/9/26.
 */
@Transactional
public interface UserDao {
    User getUserByUserId(String userId);

    int saveUser(User user);
}
