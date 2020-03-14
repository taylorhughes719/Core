package net.mythiccraft.core.util;

import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Text {

    /**
     * The special character which prefixes all chat colour codes. Use this if
     * you need to dynamically convert colour codes from your custom format.
     */
    public static final char COLOR_CHAR = '\u00A7';
    public static final String ALL_CODES = "0123456789AaBbCcDdEeFfKkLlMmNnOoRr";

    /** Pattern to remove all colour codes. */
    public static final Pattern STRIP_COLOR_PATTERN = Pattern.compile( "(?i)" + String.valueOf( COLOR_CHAR ) + "[0-9A-FK-OR]" );


    public static String colorize(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }

    public static List<String> colorize(List<String> input) {
        return input.stream().map(Text::colorize).collect(Collectors.toList());
    }

    public static String[] colorize(String... text) {
        List<String> l = Text.colorize(Arrays.asList(text));
        return l.toArray(new String[0]);
    }

    public static List<Object> toList(Object... objects) {
        return new ArrayList<>(Arrays.asList(objects));
    }

    public static List<String> toList(String... strings) {
        return colorize(Arrays.asList(strings));
    }

    public static List<String> decolorize(List<String> input) {
        return input.stream().map(Text::decolorize).collect(Collectors.toList());
    }

    public static String decolorize(String input) {
        return ChatColor.stripColor(input);
    }

}

