package springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class HelloResponseDtoTest {

    @Test
    public void lombok_functional_test() {
        String name = "Mose";
        int amount = 999;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}