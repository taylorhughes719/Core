package net.mythiccraft.core.util;

import org.bukkit.ChatColor;
import org.bukkit.Color;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Colors {

    /**
     * Represents black.
     */
    BLACK( '0', "black" ),

    /**
     * Represents dark blue.
     */
    DARK_BLUE( '1', "dark_blue" ),

    /**
     * Represents dark green.
     */
    DARK_GREEN( '2', "dark_green" ),

    /**
     * Represents dark blue (aqua).
     */
    DARK_AQUA( '3', "dark_aqua" ),

    /**
     * Represents dark red.
     */
    DARK_RED( '4', "dark_red" ),

    /**
     * Represents dark purple.
     */
    DARK_PURPLE( '5', "dark_purple" ),

    /**
     * Represents gold.
     */
    GOLD( '6', "gold" ),

    /**
     * Represents gray.
     */
    GRAY( '7', "gray" ),

    /**
     * Represents dark gray.
     */
    DARK_GRAY( '8', "dark_gray" ),

    /**
     * Represents blue.
     */
    BLUE( '9', "blue" ),

    /**
     * Represents green.
     */
    GREEN( 'a', "green" ),

    /**
     * Represents aqua.
     */
    AQUA( 'b', "aqua" ),

    /**
     * Represents red.
     */
    RED( 'c', "red" ),

    /**
     * Represents light purple.
     */
    LIGHT_PURPLE( 'd', "light_purple" ),

    /**
     * Represents yellow.
     */
    YELLOW( 'e', "yellow" ),

    /**
     * Represents white.
     */
    WHITE( 'f', "white" ),

    /**
     * Represents magical characters that change around randomly.
     */
    MAGIC( 'k', "obfuscated" ),

    /**
     * Makes the text bold.
     */
    BOLD( 'l', "bold" ),

    /**
     * Makes a line appear through the text.
     */
    STRIKETHROUGH( 'm', "strikethrough" ),

    /**
     * Makes the text appear underlined.
     */
    UNDERLINE( 'n', "underline" ),

    /**
     * Makes the text italic.
     */
    ITALIC( 'o', "italic" ),

    /**
     * Resets all previous chat colors or formats.
     */
    RESET( 'r', "reset" );

    /**
     * The special character which prefixes all chat colour codes. Use this if
     * you need to dynamically convert colour codes from your custom format.
     */
    public static final char COLOR_CHAR = '\u00A7';
    public static final String ALL_CODES = "0123456789AaBbCcDdEeFfKkLlMmNnOoRr";
    private static final Map<Character, Colors> BY_CHAR = new HashMap<>();
    private final char code;
    private final String toString;
    private final String name;

    Colors(char code, String name) {
        this.code = code;
        this.name = name;
        this.toString = new String(new char[]{'\u00A7', code});
    }

    @Override
    public String toString() {
        return this.toString;
    }

    public static String stripColor(String input) {
        return ChatColor.stripColor(input);
    }

    public static String colorize(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static Colors getByChar(char code) {
        return BY_CHAR.get(code);
    }

    public final String getName() {
        return this.name;
    }

    static {
        Colors[] var0 = values();
        Arrays.stream(var0).forEach(colour -> BY_CHAR.put(colour.code, colour));
    }

    public static Color getColor(int i) {
        Color color;
        switch (i) {
            case 1:
                color = Color.AQUA;
                break;
            case 2:
                color = Color.BLACK;
                break;
            case 3:
                color = Color.BLUE;
                break;
            case 4:
                color = Color.FUCHSIA;
                break;
            case 5:
                color = Color.GRAY;
                break;
            case 6:
                color = Color.GREEN;
                break;
            case 7:
                color = Color.LIME;
                break;
            case 8:
                color = Color.MAROON;
                break;
            case 9:
                color = Color.NAVY;
                break;
            case 10:
                color = Color.OLIVE;
                break;
            case 11:
                color = Color.ORANGE;
                break;
            case 12:
                color = Color.PURPLE;
                break;
            case 13:
                color = Color.RED;
                break;
            case 14:
                color = Color.SILVER;
                break;
            case 15:
                color = Color.TEAL;
                break;
            case 16:
                color = Color.WHITE;
                break;
            case 17:
                color = Color.YELLOW;
                break;
            default:
                color = null;
        }
        return color;
    }
}

