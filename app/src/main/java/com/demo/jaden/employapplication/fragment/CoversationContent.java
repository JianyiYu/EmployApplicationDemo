package com.demo.jaden.employapplication.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoversationContent {

    public static final List<CoversationContent.ConversationItem> ITEMS = new ArrayList<CoversationContent.ConversationItem>();

    public static final Map<String, CoversationContent.ConversationItem> ITEM_MAP = new HashMap<String, CoversationContent.ConversationItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createJobItem(i));
        }
    }

    private static void addItem(CoversationContent.ConversationItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static CoversationContent.ConversationItem createJobItem(int position) {
        return new CoversationContent.ConversationItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    public static class ConversationItem {

        String name;

        String postion;

        String lastMsg = "last message";

        String id;

        public ConversationItem(String id, String name, String postion){

            this.id = id;
            this.name = name;
            this.postion = postion;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
