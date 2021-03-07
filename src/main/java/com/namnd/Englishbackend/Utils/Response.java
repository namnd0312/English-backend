package com.namnd.Englishbackend.Utils;

import com.namnd.Englishbackend.enums.MessageEnum;
import com.namnd.Englishbackend.payloads.responses.ResponseBody;

import static com.namnd.Englishbackend.Utils.Constant.*;

/**
 * @author nam.nd
 * @created 07/03/2021 - 11:13 AM
 */
public class Response {

    public static ResponseBody<?> ok(Object data){
        return new ResponseBody<>("00", OK, SUCCESS, data);
    }

    public static ResponseBody<?> ok(){
        return new ResponseBody<>("00", OK, SUCCESS, null);
    }

    public static ResponseBody<?> error(MessageEnum messageEnum, Object data){
        return new ResponseBody<>(messageEnum.getCode(), FAIL, messageEnum.getMessage(), data);
    }

    public static ResponseBody<?> error(MessageEnum messageEnum){
        return new ResponseBody<>(messageEnum.getCode(), FAIL, messageEnum.getMessage(), null);
    }
}
