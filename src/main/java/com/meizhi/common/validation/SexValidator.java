package com.meizhi.common.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;

public class SexValidator implements ConstraintValidator<SexValidation, Integer> {
    private SexValidation sexValidation;

    @Override
    public void initialize(SexValidation sexValidation) {
        this.sexValidation = sexValidation;
    }

    @Override
    public boolean isValid(Integer sex, ConstraintValidatorContext constraintValidatorContext) {

        if(sex == null){
            return true;
        }

//        System.err.println(sex);
//        System.err.println(sexValidation.range());

        boolean contains = sexValidation.range().contains(sex.toString());

        return contains;
    }


}
