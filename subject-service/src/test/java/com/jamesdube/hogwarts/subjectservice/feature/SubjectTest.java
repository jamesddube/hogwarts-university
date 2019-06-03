package com.jamesdube.hogwarts.subjectservice.feature;

import com.jamesdube.hogwarts.subjectservice.BaseEndpointTest;
import com.jamesdube.hogwarts.subjectservice.TestHelper;
import com.jamesdube.hogwarts.subjectservice.data.domain.Subject;
import com.jamesdube.hogwarts.subjectservice.data.repository.SubjectRepository;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@FixMethodOrder(MethodSorters.JVM)
public class SubjectTest extends BaseEndpointTest {

    @Before
    public void setup() throws Exception {
        super.setup();

        subjectRepository.deleteAll();
    }

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

    @Test
    public void itListsASubject() throws Exception {

        subjectRepository.deleteAll();
        subjectRepository.saveAll(
                Arrays.asList(
                        new Subject(1L,"HCS", "Computer Science"),
                        new Subject( 2L,"HINFO", "Information Systems")));

        this.mockMvc.perform(get("/subjects/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("subject.code").value("HCS"))
                .andExpect(jsonPath("subject.name").value("Computer Science"));

        this.mockMvc.perform(get("/subjects/2")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("subject.code").value("HINFO"))
                .andExpect(jsonPath("subject.name").value("Information Systems"));


    }

    @Test
    public void itShowsA404ForASubjectThatDoesNotExist() throws Exception {

        subjectRepository.deleteAll();

        this.mockMvc.perform(get("/subjects/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("status").value(404));


    }

    @Test
    public void itEditsASubject() throws Exception {

        subjectRepository.saveAll(
                Arrays.asList(
                        new Subject(1L,"HCS", "Computer Science"),
                        new Subject( 2L,"HINFO", "Information Systems")));

        String content = TestHelper.toJson(
                new Subject( "HTEL", "Telecommunications"));

        this.mockMvc.perform(patch("/subjects/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(content))
                .andDo(print())
                .andExpect(status().isNoContent());

        this.mockMvc.perform(get("/subjects/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(content))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("subject.name").value("Telecommunications"))
                .andExpect(jsonPath("subject.code@Transactional").value("HTEL"));

    }

    @Test
    public void itDoesNotEditsASubjectThatDoesNotExist() throws Exception {

        subjectRepository.deleteAll();
        String content = TestHelper.toJson(
                new Subject( "HTEL", "Telecommunications"));

        this.mockMvc.perform(patch("/subjects/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(content))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

    }
}
