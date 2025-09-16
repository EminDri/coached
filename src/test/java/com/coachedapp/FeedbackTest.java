package com.coachedapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

    class FeedbackTest {

        @Test
        public void testJsonSerialisation() throws Exception {
            Feedback feedback = new Feedback();

            feedback.setId(3);
            feedback.setPlayerName("Haniko");
            feedback.setPlayerLastName("Chan");
            feedback.setPlayerEmail("fas@gmail.com");
            feedback.setMessage("Wow mate");
            feedback.setRating(8.9);

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(feedback);
            System.out.println(json);

            // Check JSON contains the correct values
            assertTrue(json.contains("\"id\":3"));
            assertTrue(json.contains("\"player_name\":\"Haniko\""));
            assertTrue(json.contains("\"player_last_name\":\"Chan\""));
            assertTrue(json.contains("\"player_email\":\"fas@gmail.com\""));
            assertTrue(json.contains("\"message\":\"Wow mate\""));
            assertTrue(json.contains("\"rating\":8.9") || json.contains("\"rating\":8.900000000000002"));
        }
    }
