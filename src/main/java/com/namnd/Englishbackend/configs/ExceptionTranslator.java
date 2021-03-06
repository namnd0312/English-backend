//package com.namnd.Englishbackend.configs;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.seabank.seapay.enums.MessageEnum;
//import com.seabank.seapay.exception.LogicException;
//import com.seabank.seapay.service.dto.requestDTO.HeaderRequest;
//import com.seabank.seapay.service.dto.requestDTO.ReqDTO;
//import com.seabank.seapay.service.dto.responseDTO.BaseApiResponse;
//import com.seabank.seapay.service.dto.responseDTO.BodyBaseTransactionResponse;
//import com.seabank.seapay.service.dto.responseDTO.ErrorResponseDTO;
//import com.seabank.seapay.utils.BuildError;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.MethodParameter;
//import org.springframework.http.HttpInputMessage;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import java.lang.reflect.Type;
//
//import static com.seabank.seapay.common.Constants.ERROR;
//
//
//@ControllerAdvice
//public class ExceptionTranslator extends RequestBodyAdviceAdapter {
//    private final Logger log = LoggerFactory.getLogger(ExceptionTranslator.class);
//    private HttpServletRequest request;
//    private ReqDTO<?> bodyRq;
//
//    public ExceptionTranslator(HttpServletRequest request) {
//        this.request = request;
//    }
//
//    @Override
//    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
//        return true;
//    }
//
//    @Override
//    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter,
//                                Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
//        if (!request.getRequestURI().contains("medias")) {
//            try {
//                ObjectMapper mapper = new ObjectMapper();
//                log.info("[URI: {}][REQUEST_BODY]: {}",
//                        this.request.getRequestURI(), mapper.writeValueAsString(body));
//                this.bodyRq = (ReqDTO<?>) body;
//            } catch (Exception e) {
//                log.error(e.getMessage(), e);
//            }
//        }
//
//        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
//    }
//
//    /**
//     Handle common exception all system;
//     */
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> processRuntimeException(Exception ex) {
//
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            log.info("[URI: {}][NG][EXCEPTION]: {}",
//                    this.request.getRequestURI(), mapper.writeValueAsString(ex.getMessage()));
//        }catch (Exception e) {
//            log.error(e.getMessage(), e);
//        }
//
//        BodyBaseTransactionResponse bodyErr = new BodyBaseTransactionResponse(ERROR);
//        ErrorResponseDTO error = BuildError.setErrorMessage(MessageEnum.INTERNAL_API_ERROR);
//        HeaderRequest headerRequest = this.bodyRq.getSeabReq().getHeader();
//        return new ResponseEntity<>(new BaseApiResponse<>(headerRequest, bodyErr, error), HttpStatus.OK);
//    }
//
//    /**
//        Handle exception for validate input data field and custom validation;
//    */
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
//        BodyBaseTransactionResponse body1 = new BodyBaseTransactionResponse(ERROR);
//        ErrorResponseDTO error = BuildError.setError(MessageEnum.FIELD_INVALID.getCode(),
//                ex.getBindingResult().getFieldError().getField()
//                        + " " + ex.getBindingResult().getFieldError().getDefaultMessage());
//        HeaderRequest headerRequest = this.bodyRq.getSeabReq().getHeader();
//        return new ResponseEntity<>(new BaseApiResponse<>(headerRequest, body1, error), HttpStatus.OK);
//    }
//
//    @ExceptionHandler(LogicException.class)
//    public ResponseEntity<?> logicException(LogicException ex) {
//        BodyBaseTransactionResponse body = new BodyBaseTransactionResponse(ERROR);
//        ErrorResponseDTO error = BuildError.setError(ex.getMessageEnum().getCode(),
//                ex.getMessageEnum().getMessage());
//        HeaderRequest headerRequest = this.bodyRq.getSeabReq().getHeader();
//        return new ResponseEntity<>(new BaseApiResponse<>(headerRequest, body, error), HttpStatus.OK);
//    }
//
//    /**
//     Handle error response from core T24 system;
//     */
//    @ExceptionHandler(T24CoreException.class)
//    public ResponseEntity<?> coreT24Exception(T24CoreException ex) {
//        HeaderRequest headerRequest = this.bodyRq.getSeabReq().getHeader();
//        BodyBaseTransactionResponse body = new BodyBaseTransactionResponse(ERROR);
//        String code = ex.getCode() != null ? ex.getCode() : "";
//        String message = ex.getMessage()!= null ? ex.getMessage() : "";
//        ErrorResponseDTO error = BuildError.setError(code, message);
//        return new ResponseEntity<>(new BaseApiResponse<>(headerRequest, body, error), HttpStatus.OK);
//    }
//}
