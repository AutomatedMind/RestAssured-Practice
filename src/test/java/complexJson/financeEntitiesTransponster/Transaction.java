package complexJson.financeEntitiesTransponster;

import lombok.Getter;
import lombok.Setter;

//Lombok Annotations:
//@Getter and @Setter are used for automatic generation of getter and setter methods to reduce boilerplate code.

@Getter
@Setter
public class Transaction {
    private long transactionId;
    private String date;
    private double amount;
    private String description;
}
