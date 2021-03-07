package com.namnd.Englishbackend.enums;

public enum MessageEnum {
    SUCCESS("00", "Success"),
    AUTHEN_TYPE_NOT_FOUND("002", "Authen type not found"),
    INTERNAL_API_ERROR("500", "INTERNAL SERVER ERROR"),
    INTERNAL_API_T24_ERROR("006", "INTERNAL SERVER T24 ERROR"),
    CONNECT_T24_ERROR("003", "CONNECT TO CORE T24 ERROR"),
    BAD_REQUEST("400", "BAD REQUEST"),
    REJECTED_IF_STATUS_NOT_PENDING("005", "You only can execute with record's status is pending"),
    RECORD_NOT_EXISTED("004", "Record is not existed"),
    FIELD_INVALID("010", "FIELD_INVALID"),
//    ACTION_T24_INVALID("010", "actionT24 invalid"),
    LIST_EMPTY("011", "EMPTY"),
    REJECT_DELETE_RECORD_CREATED_BY_COMBO("012", "YOU CAN NOT DELETE RECORD CREATED BY COMBO"),
    OK("00", "OK"),
    EMAIL_ALREADY_IN_USE("00", "Email is already in use"),
    PARAMETER_IN_VALID("01", "Parameter is invalid"),
    UN_AUTHORIZE("02", "UN AUTHORIZER"),
    USER_TOKEN_INVALID("02", "USER_TOKEN_INVALID"),
    USER_MISSING_ROLE("02", "USER_MISSING_ROLE"),
    ACCESS_DENIED("02", "Access is denied"),

    //    FOR CARD
    CARD_ID_REQUIRED("301", "CARD ID REQUIRED"),
    CARD_NOT_EXIST("303", "CARD NOT EXIST"),
    REJECTED_IF_STATUS_CARD_NOT_PENDING("304", "You only can execute with card's status is pending"),
    CARD_TRANS_ID_EXISTED("407", "TRANSACTION ID OF CARD IS EXISTED"),
    CARD_ID_NOT_MATCH("408", "CARD ID NOT MATCH"),

    //    FOR COMBO
    COMBO_ID_REQUIRED("401", "COMBO ID REQUIRED"),
    COMBO_NOT_EXIST("403", "COMBO NOT EXIST"),
    REJECT_STATUS_COMBO_NOT_PENDING("405", "You only can execute with combo's status is pending"),
    COMBO_TYPE_NOT_MATCH("406", "COMBO TYPE NOT MATCH WITH COMBO EXISTED"),
    COMBO_TRANS_ID_EXISTED("407", "TRANSACTION ID OF COMBO IS EXISTED"),

    //    EBANK
    EBANK_ID_REQUIRED("450", "EBANK ID REQUIRED"),
    EBANK_NOT_EXIST("451", "EBANK NOT EXIST"),
    REJECTED_IF_STATUS_EBANK_NOT_PENDING("453", "You only can execute with ebank's status is pending"),
    EBANK_TRANS_ID_EXISTED("452", "TRANSACTION ID OF EBANK IS EXISTED"),
    EBANK_ID_NOT_MATCH("453", "EBANK ID NOT MATCH"),


    //    ACCOUNT
    ACCOUNT_NOT_EXIST("502", "ACCOUNT NOT EXIST"),
    REJECTED_IF_STATUS_ACCOUNT_NOT_PENDING("503", "You only can execute with account's status is pending"),
    ACC_TRANS_ID_EXISTED("602", "TRANSACTION ID OF ACCOUNT IS EXISTED"),

    //    SMS
    SMS_ID_REQUIRED("600", "SMS ID REQUIRED"),
    SMS_NOT_EXIST("601", "SMS NOT EXIST"),
    REJECTED_IF_STATUS_SMS_NOT_PENDING("603", "You only can execute with sms's status is pending"),
    SMS_TRANS_ID_EXISTED("602", "TRANSACTION ID OF SMS IS EXISTED"),
    SMS_ID_NOT_MATCH("603", "SMS ID NOT MATCH"),

    //    CUSTOMER
    CUSTOMER_ID_REQUIRED("650", "CUSTOMER ID REQUIRED"),
    CUSTOMER_NOT_EXIST("651", "CUSTOMER NOT EXIST"),
    REJECTED_IF_STATUS_CUSTOMER_NOT_PENDING("653", "You only can execute with customer's status is pending"),
    CUS_TRANS_ID_EXISTED("602", "TRANSACTION ID OF CUSTOMER IS EXISTED"),
    CUSTOMER_REQUIRED("603", "CUSTOMER PARAMETER REQUIRED"),
    CUS_PARAMETER_INVALID("604", "CAN'T EXIST CUSTOMER AND CUSTOMER_ID TOGETHER"),
    COMMON_ERROR("8000", "Common error."),
    DATABASE_ERROR("9000", "A database error has error."),
    DELETE_RECORD_ERROR("9001", "Delete record error"),
    FIELD_REQUIRED("9002", " {0} is required"),
    RECORD_CARD_ACTION_NOT_FOUND("9003", " Card Action with card_id {0} not found "),
    CARD_ACTION_TYPE_NOT_CORRECT("9004", " Card Action type [{0}] is not correct "),

    /**
     * For fields required:::
     */

    ACCOUNT_ID_REQUIRED("700", "ACCOUNT ID REQUIRED"),
    ;

    private final String code;
    private final String message;

    MessageEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
