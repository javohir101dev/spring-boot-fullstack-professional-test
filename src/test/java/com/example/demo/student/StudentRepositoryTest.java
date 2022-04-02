package com.example.demo.student;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest // any time we test our repository
class StudentRepositoryTest {

    @Autowired
    private  StudentRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckStudentEmailExists() {
        // given

        String email = "jamila@gmail.com";
        Student student = new Student("Jamila",
                email,
                Gender.FEMALE);
        underTest.save(student);

        // when
        boolean existsExpected = underTest.selectExistsEmail(email);

        // then
        assertThat(existsExpected).isTrue();
    }

    @Test
    void itShouldCheckStudentEmailDoesNotExists() {

        // given
        String email = "jamila@gmail.com";

        // when
        boolean existsExpected = underTest.selectExistsEmail(email);

        // then
        assertThat(existsExpected).isFalse();
    }

}