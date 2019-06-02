package com.jamesdube.hogwarts.subjectservice.feature;

import com.jamesdube.hogwarts.subjectservice.BaseEndpointTest;
import com.jamesdube.hogwarts.subjectservice.TestHelper;
import com.jamesdube.hogwarts.subjectservice.data.domain.Subject;
import com.jamesdube.hogwarts.subjectservice.data.repository.SubjectRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SubjectTest extends BaseEndpointTest {

    @Autowired
    SubjectRepository subjectRepository;

    @Test
    public void itCreatesASubject() throws Exception {

        String content = TestHelper.toJson(
                new Subject(2L, "HCS", "Computer Science"));

//        Subject subject = factory(Subject.class).make();

        this.mockMvc.perform(post("/subjects")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(content))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("subject.name").value("Computer Science"))
                .andExpect(jsonPath("subject.code").value("HCS"));

        assertEquals(1,subjectRepository.findAll().size());


    }

    @Test
    public void itListsAllSubjects() throws Exception {

        subjectRepository.deleteAll();
        subjectRepository.saveAll(
                Arrays.asList(
                        new Subject("HCS", "Computer Science"),
                        new Subject( "HINFO", "Information Systems")));

        this.mockMvc.perform(get("/subjects")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("subjects").isArray())
                .andExpect(jsonPath("subjects", hasSize(2)))
                .andExpect(jsonPath("subjects[?(@.code==\"HCS\")]").exists())
                .andExpect(jsonPath("subjects[?(@.code==\"HINFO\")]").exists())
                .andExpect(jsonPath("subjects", hasSize(2)));

        assertEquals(2,subjectRepository.findAll().size());

    }
}
