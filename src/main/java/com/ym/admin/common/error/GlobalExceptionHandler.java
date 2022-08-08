package com.ym.admin.common.error;

import com.alibaba.fastjson.JSONObject;
import com.ym.admin.common.exception.SassException;
import com.ym.admin.common.res.ResCode;
import com.ym.admin.common.res.ResResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ValidationException;
import java.util.List;

/**
 *@Author fengzhilong
 *@Date 2021/2/24 11:32
 *@Desc
 **/
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * @Author fengzhilong
     * @Desc 所有异常报错处理
     * @Date 2021/2/24 11:37
     * @param exception
     * @return com.alibaba.fastjson.JSONObject
     **/
    @ExceptionHandler(value = RuntimeException.class)
    public JSONObject allExceptionHandler(RuntimeException exception) {
        JSONObject json = new JSONObject();
        json.put("code", -1);
        json.put("msg", "服务器异常!");
        json.put("exception", exception.getMessage());
        log.error("服务异常" + exception.getMessage());
        return json;
    }


    @ExceptionHandler(value = {MethodArgumentNotValidException.class, ValidationException.class, BindException.class})
    public ResResult<Exception> bindExceptionHandler(Exception e) {
        ResResult<Exception> resResult = null;
        if (e instanceof MethodArgumentNotValidException) {
            List<FieldError> errorList = ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors();
            resResult = ResResult.of(ResCode.PARAM_VERIFY_FAILED.getCode(), null, errorList.get(0).getDefaultMessage());
        } else if (e instanceof BindException) {
            List<FieldError> errorList = ((BindException) e).getBindingResult().getFieldErrors();
            resResult = ResResult.of(ResCode.PARAM_VERIFY_FAILED.getCode(), null, errorList.get(0).getDefaultMessage());
        } else if (e instanceof ValidationException) {
            resResult = ResResult.of(ResCode.PARAM_VERIFY_FAILED.getCode(), null, e.getMessage());
        }
        log.warn("[参数校验异常] ##  response -> {}", JSONObject.toJSONString(resResult));
        return resResult;
    }


    @ExceptionHandler(value = {SassException.class})
    public ResResult<SassException> saasExceptionHandler(SassException e) {
        int errCode = e.getCode();
        ResResult<SassException> resResult = ResResult.of(errCode, null, e.getMessage());
        log.warn("[FzlException] ## 业务异常 response -> {}", JSONObject.toJSONString(resResult));
        return resResult;
    }
}
