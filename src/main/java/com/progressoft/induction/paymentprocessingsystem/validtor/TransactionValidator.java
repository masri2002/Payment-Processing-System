package com.progressoft.induction.paymentprocessingsystem.validator;

import com.progressoft.induction.paymentprocessingsystem.enums.BeneficiaryType;
import com.progressoft.induction.paymentprocessingsystem.model.Transaction;
import org.apache.commons.validator.routines.checkdigit.IBANCheckDigit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class TransactionValidator {

    private final String IBAN_REGEX = "^JO\\d{2}[A-Z]{4}[A-Z0-9]{22}$";
    private final String PHONE_REGEX = "^009627\\d{8}$";
    private final String ALIAS_REGEX = "^[A-Za-z][A-Za-z0-9]{0,19}$";

    @Value("${MAX_DAYS_IN_THE_FUTURE}")
    private Long maxDaysInTheFuture = 2L;

    public void validateTransferInputs(Transaction transaction) {
        StringBuilder sb = new StringBuilder();

        if (transaction.getDebitAccount().isEmpty()) {
            sb.append("DEBIT Account Required; ");
        }

        if (transaction.getBeneficiary().isEmpty()) {
            sb.append("Beneficiary Required; ");
        }

        if (!isValidBeneficiary(transaction)) {
            sb.append("Invalid Beneficiary or Beneficiary not exist; ");
        }

        if (transaction.getAmount().compareTo(BigDecimal.valueOf(5000)) > 0 || transaction.getAmount().compareTo(BigDecimal.ONE) < 0) {
            sb.append("Invalid Amount: should be between 1 and 5000; ");
        }

        validateDate(transaction, sb);

        transaction.setFailuerDetails(sb.toString());
    }

    private void validateDate(Transaction transaction, StringBuilder sb) {
        if (transaction.getValueDate() == null) {
            transaction.setValueDate(LocalDate.now());
        }

        LocalDate transactionDate = transaction.getValueDate();
        boolean greaterThanMax = transactionDate.isAfter(LocalDate.now().plusDays(maxDaysInTheFuture));
        boolean inPast = transactionDate.isBefore(LocalDate.now());

        if (greaterThanMax || inPast) {
            sb.append("Transaction due date is outside the allowed range; ");
        }
    }

    private boolean isValidBeneficiary(Transaction transaction) {
        if (transaction.getBeneficiary().matches(IBAN_REGEX)) {
            IBANCheckDigit ibanValidator = new IBANCheckDigit();
            transaction.setBeneficiaryType(BeneficiaryType.IBAN.name());
            return ibanValidator.isValid(transaction.getBeneficiary());
        }
        if (transaction.getBeneficiary().matches(PHONE_REGEX)) {
            transaction.setBeneficiaryType(BeneficiaryType.PHONE.name());
            return true;
        }
        if (transaction.getBeneficiary().matches(ALIAS_REGEX)) {
            transaction.setBeneficiaryType(BeneficiaryType.ALIAS.name());
            return true;
        }
        return false;
    }
}
