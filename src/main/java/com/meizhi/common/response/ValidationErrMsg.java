package com.meizhi.common.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationErrMsg {

    private String field;

    private Object rejectedValue;

    private String errMessage;

}
