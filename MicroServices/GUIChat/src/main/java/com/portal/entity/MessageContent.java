package com.portal.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Artem Karnov @date 01.02.2017.
 *         artem.karnov@t-systems.com
 */

public class MessageContent implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
