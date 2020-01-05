package com.hsmy.app.exception.handler;

import com.hsmy.app.exception.BusinessException;
import com.hsmy.app.response.DefaultResult;
import com.hsmy.app.response.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理器，统一将异常转换为 {@link Result}.
 *
 * @author devzzm
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Log logger = LogFactory.getLog(GlobalExceptionHandler.class);

    @ExceptionHandler({BusinessException.class, Exception.class})
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
        logger.error("handle exception:", ex);
        return new ResponseEntity<>(DefaultResult.newFailResult(ex), HttpStatus.INTERNAL_SERVER_ERROR);
    }


//    /**
//     * 处理自定义异常
//     */
//    @ExceptionHandler(CustomException.class)
//    public Result handleException(CustomException e) {
//        // 打印异常信息
//        logger.error("### 异常信息:{} ###", e.getMessage());
//        return new ResponseEntity<>(DefaultResult.newFailResult(e), HttpStatus.INTERNAL_SERVER_ERROR);
//    }


//    /**
//     * 参数错误异常
//     */
//    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
//    public Result handleException(Exception e) {
//
//        if (e instanceof MethodArgumentNotValidException) {
//            MethodArgumentNotValidException validException = (MethodArgumentNotValidException) e;
//            BindingResult result = validException.getBindingResult();
//            StringBuffer errorMsg = new StringBuffer();
//            if (result.hasErrors()) {
//                List<ObjectError> errors = result.getAllErrors();
//                errors.forEach(p ->{
//                    FieldError fieldError = (FieldError) p;
//                    errorMsg.append(fieldError.getDefaultMessage()).append(",");
//                    log.error("### 请求参数错误：{"+fieldError.getObjectName()+"},field{"+fieldError.getField()+ "},errorMessage{"+fieldError.getDefaultMessage()+"}"); });
//            }
//        } else if (e instanceof BindException) {
//            BindException bindException = (BindException)e;
//            if (bindException.hasErrors()) {
//                log.error("### 请求参数错误: {}", bindException.getAllErrors());
//            }
//        }
//
//        return new Result(ResultCode.PARAM_IS_INVALID);
//    }
//
//    /**
//     * 处理所有不可知的异常
//     */
//    @ExceptionHandler(Exception.class)
//    public Result handleOtherException(Exception e){
//        //打印异常堆栈信息
//        e.printStackTrace();
//        // 打印异常信息
//        log.error("### 不可知的异常:{} ###", e.getMessage());
//        return new Result(ResultCode.SYSTEM_INNER_ERROR);
//    }

}
