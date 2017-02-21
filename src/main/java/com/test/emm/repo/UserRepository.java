package com.test.emm.repo;

import com.test.emm.model.User;

import java.util.List;

public interface UserRepository {

    User add(User user);

    User remove(long id);

    User get(long id);

    List<User> getAll(int offset, int limit);

}
