package com.portal.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * @author Artem Karnov @date 01.02.2017.
 *         artem.karnov@t-systems.com
 */

public class Message implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    User userFrom;
    @Column
    User userTo;
    @OneToOne
    MessageContent messageContent;

    public User getUserFrom() {
        return userFrom;
    }

    public User getUserTo() {
        return userTo;
    }

    public MessageContent getMessageContent() {
        return messageContent;
    }
}
