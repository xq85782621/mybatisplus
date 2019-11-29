package com.meizhi.common.code;

public enum DepartmentCode implements  ResultCode {

    DEPT_NOT_EXIST(false,20001,"部门已不存在,刷新后重试"),
    DEPT_EXIST(false,20001,"部门已存在"),
    DEPT_EXIST_CHILDREN(false,20001,"存在子部门"),

    ;
    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    DepartmentCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean success() {
        return success;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

    }
