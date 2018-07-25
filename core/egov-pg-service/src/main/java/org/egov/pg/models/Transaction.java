package org.egov.pg.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;
import org.egov.pg.web.models.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Transaction object representing a transaction
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Transaction {

    @JsonProperty("tenantId")
    @NotNull
    @Size(min = 2, max = 50)
    private String tenantId;

    /**
     * Transaction Amount, preferably rounded off to two decimal places
     */
    @JsonProperty("txnAmount")
    @NotNull
    @Size(min = 1)
    private String txnAmount;

    /**
     * Unique bill ID associated with the transaction
     */
    @JsonProperty("billId")
    @NotNull
    @Size(min = 2)
    private String billId;


    /**
     * Module business code for which the transaction is being initiated
     * ex, PT, WS, PGR etc
     */
    @JsonProperty("module")
    @NotNull
    @Size(min = 2)
    private String module;

    /**
     * Unique identifier in the module for which the transaction is being initiated
     * ex, PT, WS, PGR etc
     */
    @JsonProperty("moduleId")
    @NotNull
    private String moduleId;


    /**
     * Brief description for which the payment is being made
     * ex, Property Tax Payment for FY-YYYY
     */
    @JsonProperty("productInfo")
    @NotNull
    private String productInfo;

    /**
     * Gateway to be used to perform this transaction
     * Should be among the list of valid & active gateways returned by API
     */
    @JsonProperty("gateway")
    @NotNull
    @Size(min = 2)
    private String gateway;

    /**
     * Callback URL to which control has to be redirected to by payment gateway
     *
     */
    @JsonProperty("callbackUrl")
    @NotNull
    @Size(min = 2)
    private String callbackUrl;

    /**
     * Generated by the app, after transaction is initiated
     */
    @JsonProperty("txnId")
    private String txnId;


    @JsonProperty("user")
    private User user;

    /**
     * Represents the current status of a transaction
     */
    @JsonProperty("txnStatus")
    private TxnStatusEnum txnStatus;

    /**
     * Brief status message for the transaction
     */
    @JsonProperty("txnStatusMsg")
    private String txnStatusMsg;

    /**
     * Transaction ID, returned by the payment gateway
     */
    @JsonProperty("gatewayTxnId")
    private String gatewayTxnId;

    /**
     * Mode of payment, as returned by the payment gateway
     */
    @JsonProperty("gatewayPaymentMode")
    private String gatewayPaymentMode;

    /**
     * Payment Gateway Specific RAW status code
     */
    @JsonProperty("gatewayStatusCode")
    private String gatewayStatusCode;

    /**
     * Payment Gateway Specific RAW status message
     */
    @JsonProperty("gatewayStatusMsg")
    private String gatewayStatusMsg;

    /**
     * Receipt code of the receipt generated for this transaction
     */
    @JsonProperty("receipt")
    private String receipt;

    @JsonProperty("auditDetails")
    private AuditDetails auditDetails;

    /**
     * Entire RAW payment gateway response
     */
    @JsonIgnore
    private Object responseJson;


    /**
     * Current status of the transaction
     */
    public enum TxnStatusEnum {
        SUCCESS("SUCCESS"),

        FAILURE("FAILURE"),

        PENDING("PENDING");

        private String value;

        TxnStatusEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static TxnStatusEnum fromValue(String text) {
            for (TxnStatusEnum b : TxnStatusEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }
    }


}
