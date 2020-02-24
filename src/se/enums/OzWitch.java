package se.enums;

/**
 * @author zhangyaowen
 */
public enum OzWitch {
    /**
     * @apiNote
     */
    WEST("Miss Gulch, the Good Witch of the North"),

    NORTH("Glinda, the Good Witch of the North"),

    EAST("Wicked Witch of the East, wearer of the Ruby Slippers crushed by dorothy's house"),

    SOUTH("Good by inference, but missing");

    private String description;

    OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        String name = name();
        String lower = name.substring(1).toLowerCase();
        return name.charAt(0) + lower;
    }

    public static void main(String[] args) {
        for (OzWitch witch: values()) {
            System.out.println(witch + ": " + witch.toString());
        }
        OzWitch ozWitch = OzWitch.WEST;
    }
}
