package mainDomainModel.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Karnov @date 01.02.2017.
 *         artem.karnov@t-systems.com
 */
public class Group implements Serializable {
    private Long id;
    private String title;
    private List<User> users;

    public String getTitle() {
        return title;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * @author Artem Karnov @date 01.02.2017.
     *         artem.karnov@t-systems.com
     */
    public static class Message implements Serializable {
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

    /**
     * @author Artem Karnov @date 01.02.2017.
     *         artem.karnov@t-systems.com
     */
    public static class MessageContent implements Serializable {
        private Long id;
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    /**
     * @author Artem Karnov @date 01.02.2017.
     *         artem.karnov@t-systems.com
     */
    public static class Room implements Serializable {
        private String title;
        private int maxMembers;
        private List<Group> groups = new ArrayList();

        public String getTitle() {
            return title;
        }

        public int getMaxMembers() {
            return maxMembers;
        }

        public List<Group> getGroups() {
            return groups;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setMaxMembers(int maxMembers) {
            this.maxMembers = maxMembers;
        }

        public void setGroups(List<Group> groups) {
            this.groups = groups;
        }
    }

    /**
     * @author Artem Karnov @date 01.02.2017.
     *         artem.karnov@t-systems.com
     */
    public static class User  implements Serializable{
        private static final long serialVersionUID = 1L;
        private Long id;
        private String name;
        private String secondName;
        private String email;
        private List<Group> groups;

        public List<Group> getGroups() {
            return groups;
        }

        public void setGroups(List<Group> groups) {
            this.groups = groups;
        }

        public String getName() {
            return name;
        }

        public String getSecondName() {
            return secondName;
        }

        public String getEmail() {
            return email;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSecondName(String secondName) {
            this.secondName = secondName;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
