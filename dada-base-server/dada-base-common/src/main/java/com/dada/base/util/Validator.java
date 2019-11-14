package com.dada.base.util;


import com.dada.base.enums.ErrorCode;
import com.dada.base.exception.ValidateException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class Validator<T> {

    public void isEmpty(T request) throws ValidateException {
        isEmpty(request, ErrorCode.EMPTY_REQUEST);
    }


    public void isEmpty(T request, ErrorCode errorCode) throws ValidateException {
        if (null == request) {
            throw new ValidateException(errorCode);
        }

        if (request instanceof String && StringUtils.isBlank((String) request)) {
            throw new ValidateException(errorCode);
        }

        if (request instanceof Collection && CollectionUtils.isEmpty((Collection) request)) {
            throw new ValidateException(errorCode);
        }
    }

}
