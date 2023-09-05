package domain.model;

import org.junit.jupiter.api.Test;
import org.usermanagement.domain.model.TaxPayerNumber;

import static org.junit.jupiter.api.Assertions.*;

class TaxPayerNumberTest {

    @Test
    void ensureTaxPayerNumberIsNotNull() {
        assertThrows(IllegalArgumentException.class, () -> TaxPayerNumber.of(null));
    }

    @Test
    void ensureTaxPayerNumberIsNotEmpty() {
        assertThrows(IllegalArgumentException.class, () -> TaxPayerNumber.of(""));
    }

    @Test
    void ensureTaxPayerNumberHasNineDigits() {
        assertThrows(IllegalArgumentException.class, () -> TaxPayerNumber.of("12345678"));
        assertThrows(IllegalArgumentException.class, () -> TaxPayerNumber.of("1234567890"));
    }

    @Test
    void ensureTaxPayerNumberHasNoCharacters() {
        assertThrows(IllegalArgumentException.class, () -> TaxPayerNumber.of("12345678a"));
        assertThrows(IllegalArgumentException.class, () -> TaxPayerNumber.of("a12345678"));
    }

    @Test
    void ensureWeCanCreateTaxPayerNumber() {
        TaxPayerNumber taxPayerNumber = TaxPayerNumber.of("123456789");
        assertEquals("123456789", taxPayerNumber.value());
    }

}