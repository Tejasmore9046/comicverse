package com.tejas.comicverse.service;

import com.tejas.comicverse.dto.RegisterRequest;
import com.tejas.comicverse.entity.User;

public interface UserService {
    User register(RegisterRequest request);
}
