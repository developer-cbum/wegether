package com.wegether.app.mapper.main;

import com.wegether.app.domain.dto.MainDTO;
import com.wegether.app.mapper.MainMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class MainMapperTests {

    @Autowired
    private MainMapper mainMapper;

    @Test
    public void ProjectSelectAllTest() {
        assertThat(mainMapper.ProjectSelectAll()).hasSize(1);
    }
}
