package com.jianke.demo.utils;

import com.jianke.demo.exception.ValidateException;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.validation.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: mall-share
 * @description: ${description}
 * @author: chenguiquan
 * @create: 2019-08-12 21:45
 **/
public class ValidatorUtil {
    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    public static <T> List<String> validate(T t) throws ValidateException {
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(t);
        List<String> messages = violations.stream().map(v -> v.getMessage()).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(messages)) {
            throw new ValidateException(String.join(",",messages));
        }
        return messages;
    }


}

