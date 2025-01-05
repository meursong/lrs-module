package com.meursong.xapi.util;

import com.meursong.xapi.dto.element.xapiActor.XapiAgent;
import com.meursong.xapi.dto.element.xapiActor.XapiGroup;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
class XapiActorUtilTest {

    @Test
    void createAgentWithMbox_shouldCreateAgent() {
        XapiAgent agent = XapiActorUtil.createAgentWithMbox("mailto:example@example.com");
        assertNotNull(agent);
        assertEquals("Agent", agent.getObjectType());
        assertEquals("mailto:example@example.com", agent.getMbox());
        assertNull(agent.getName());
        assertNull(agent.getAccount());
        assertTrue(agent.isValid());
    }

    @Test
    void createAgentWithAccount_shouldCreateAgent() {
        XapiAgent agent = XapiActorUtil.createAgentWithAccount("JohnDoe", "http://example.com");
        assertNotNull(agent);
        assertEquals("Agent", agent.getObjectType());
        assertNull(agent.getMbox());
        assertNull(agent.getName());
        assertNotNull(agent.getAccount());
        assertEquals("JohnDoe", agent.getAccount().getName());
        assertEquals("http://example.com", agent.getAccount().getHomePage());
        assertTrue(agent.isValid());
    }

    @Test
    void createAgentWithNameAndMbox_shouldCreateAgent() {
        XapiAgent agent = XapiActorUtil.createAgentWithNameAndMbox("John Doe", "mailto:example@example.com");
        assertNotNull(agent);
        assertEquals("Agent", agent.getObjectType());
        assertEquals("John Doe", agent.getName());
        assertEquals("mailto:example@example.com", agent.getMbox());
        assertNull(agent.getAccount());
        assertTrue(agent.isValid());
    }

    @Test
    void createAgentWithNameAndAccount_shouldCreateAgent() {
        XapiAgent agent = XapiActorUtil.createAgentWithNameAndAccount("John Doe", "JohnDoe", "http://example.com");
        assertNotNull(agent);
        assertEquals("Agent", agent.getObjectType());
        assertEquals("John Doe", agent.getName());
        assertNull(agent.getMbox());
        assertNotNull(agent.getAccount());
        assertEquals("JohnDoe", agent.getAccount().getName());
        assertEquals("http://example.com", agent.getAccount().getHomePage());
        assertTrue(agent.isValid());
    }

    @Test
    void createGroupWithName_shouldCreateGroup() {
        XapiGroup group = XapiActorUtil.createGroupWithName("Developers Group");
        assertNotNull(group);
        assertEquals("Group", group.getObjectType());
        assertEquals("Developers Group", group.getName());
        assertNull(group.getMembers());
        assertFalse(group.isValid()); // 멤버가 없으므로 유효성 검사 실패
    }

    @Test
    void createGroupWithMembers_shouldCreateGroup() {
        XapiAgent agent1 = XapiActorUtil.createAgentWithMbox("mailto:member1@example.com");
        XapiAgent agent2 = XapiActorUtil.createAgentWithMbox("mailto:member2@example.com");

        XapiGroup group = XapiActorUtil.createGroupWithMembers(List.of(agent1, agent2));
        assertNotNull(group);
        assertEquals("Group", group.getObjectType());
        assertNull(group.getName());
        assertNotNull(group.getMembers());
        assertEquals(2, group.getMembers().size());
        assertTrue(group.isValid());
    }

    @Test
    void createGroupWithNameAndMembers_shouldCreateGroup() {
        XapiAgent agent1 = XapiActorUtil.createAgentWithMbox("mailto:member1@example.com");
        XapiAgent agent2 = XapiActorUtil.createAgentWithMbox("mailto:member2@example.com");

        XapiGroup group = XapiActorUtil.createGroupWithNameAndMembers("Developers Group", List.of(agent1, agent2));
        assertNotNull(group);
        assertEquals("Group", group.getObjectType());
        assertEquals("Developers Group", group.getName());
        assertNotNull(group.getMembers());
        assertEquals(2, group.getMembers().size());
        assertTrue(group.isValid());
    }

    @Test
    void invalidGroup_shouldFailValidation() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            XapiActorUtil.createGroupWithMembers(null);
        });
        assertEquals("Invalid members: must not be null or empty.", exception.getMessage());
    }

    @Test
    void invalidAgentWithEmptyMbox_shouldFailValidation() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            XapiActorUtil.createAgentWithMbox("");
        });
        assertEquals("Invalid mbox: must not be null or empty.", exception.getMessage());
    }
}
