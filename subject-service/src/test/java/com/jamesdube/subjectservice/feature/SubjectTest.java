package com.jamesdube.subjectservice.feature;

import com.jamesdube.subjectservice.BaseEndpointTest;
import com.jamesdube.subjectservice.data.domain.Subject;
import com.jamesdube.subjectservice.data.repository.SubjectRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static com.jamesdube.subjectservice.TestHelper.toJson;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SubjectTest extends BaseEndpointTest {

    @Autowired
    SubjectRepository subjectRepository;

    @Test
    public void itCreatesASubject() throws Exception {

        String content = toJson(
                new Subject(2L, "HCS", "Computer Science"));

//        Subject subject = factory(Subject.class).make();

        this.mockMvc.perform(post("/subjects")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(content))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Computer Science"))
                .andExpect(jsonPath("$.code").value("HCS"));

        assertEquals(1,subjectRepository.findAll().size());


    }
}
