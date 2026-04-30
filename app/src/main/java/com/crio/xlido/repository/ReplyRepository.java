package com.crio.xlido.repository;

import java.util.*;
import com.crio.xlido.model.Reply;

public class ReplyRepository {
    private Map<Integer, Reply> replies = new HashMap<>();

    public void save(Reply r) {
        replies.put(r.hashCode(), r);
    }
}