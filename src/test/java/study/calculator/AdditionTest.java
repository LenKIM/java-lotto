package study.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.calculator.domain.Addition;
import study.calculator.domain.Operand;

import static org.assertj.core.api.Assertions.assertThat;

public class AdditionTest {
    @DisplayName("숫자를 더하여 원하는 값이 나온다.")
    @ParameterizedTest
    @CsvSource({"1,2,3", "0,3,3"})
    void sum(int leftSide, int rightSide, int result) {
        assertThat(Addition.sum(Operand.getInstance(leftSide),
                Operand.getInstance(rightSide))).isEqualTo(result);
    }
}