package com.proteinduo.global.exception;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    // IllegalArgumentException 발생 시 에러 페이지 반환
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException ex, Model model) {
        model.addAttribute("message", "Invalid input: " + ex.getMessage());  // 에러 메시지 전달
        return "errorPage";  // 에러 페이지 뷰 이름
    }

    // 모든 예외 처리
    @ExceptionHandler(Exception.class)
    public String handleGeneralException(Exception ex, Model model) {
        model.addAttribute("message", "Something went wrong: " + ex.getMessage());  // 에러 메시지 전달
        return "errorPage";  // 에러 페이지 뷰 이름
    }
}