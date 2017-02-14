package mainDomainModel;

import java.io.Serializable;

/**
 * @author Artem Karnov @date 01.02.2017.
 *         artem.karnov@t-systems.com
 */
public class Message implements Serializable {
    private Long id;
    User userFrom;
    User userTo;
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
