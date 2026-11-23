package org.dbrinker.notes.controller;

import org.dbrinker.notes.model.Note;
import org.dbrinker.notes.repository.NoteRepository;
import org.dbrinker.notes.service.NoteService;
import org.dbrinker.notes.service.NoteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class NoteControllerTest {
    private static final String TEST_SUBJECT = "aTestSubject";
    private static final String TEST_TEXT = "someText";
    private static final Instant TEST_LAST_UPDATED = Instant.now();
    private static final Integer TEST_USER_ID = 123;

    @Mock
    private NoteRepository mockRepository;
    @InjectMocks
    private NoteServiceImpl service;

    private Note validNote;

    @BeforeEach
    void setup() {
        validNote = new Note(null, TEST_SUBJECT, TEST_TEXT, TEST_LAST_UPDATED, TEST_USER_ID);
    }

    @Test
    void createValid() {
        assertEquals(validNote, service.create(validNote));
    }

    @Test
    void createNull() {
    }

    @Test
    void createWithId() {

    }

    @Test
    void getAll() {
    }

    @Test
    void getNote() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}