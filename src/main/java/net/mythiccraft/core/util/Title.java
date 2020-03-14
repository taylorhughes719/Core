package net.mythiccraft.core.util;

import org.bukkit.entity.Player;

/**
 * A title class.
 */
public class Title {

    private String title, subtitle;
    private int fadeIn, stay, fadeOut;

    /**
     * Create a new title with the specified parameters.
     *
     * @param title The title
     * @param subtitle The subtitle
     * @param fadeIn Time to fade in
     * @param stay Time to stay
     * @param fadeOut Time to fade out
     */
    public Title(String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        this.title = Text.colorize(title);
        this.subtitle = Text.colorize(subtitle);
        this.fadeIn = fadeIn;
        this.stay = stay;
        this.fadeOut = fadeOut;
    }

    /**
     * Get how long the title will stay on the screen.
     *
     * @return The stay time
     */
    public int getStay() {
        return stay;
    }

    /**
     * Set how long the title will stay on the screen.
     *
     * @param stay The new stay time
     */
    public void setStay(int stay) {
        this.stay = stay;
    }

    /**
     * Gets fade out.
     *
     * @return the fade out
     */
    public int getFadeOut() {
        return fadeOut;
    }

    /**
     * Sets fade out.
     *
     * @param fadeOut the fade out
     */
    public void setFadeOut(int fadeOut) {
        this.fadeOut = fadeOut;
    }

    /**
     * Gets the subtitle.
     *
     * @return The subtitle
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * Set the subtitle of the Title.
     *
     * @param subtitle The new subtitle.
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = Text.colorize(subtitle);
    }

    /**
     * Gets the actual title of the Title object.
     *
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the actual title of the Title object
     *
     * @param title The new title
     */
    public void setTitle(String title) {
        this.title = Text.colorize(title);
    }

    /**
     * Gets the time the title will take to fade in.
     *
     * @return The fade in time
     */
    public int getFadeIn() {
        return fadeIn;
    }

    /**
     * Sets the time the title will fade in.
     *
     * @param time The fade in time
     */
    public void setFadeIn(int time) {
        this.fadeIn = time;
    }

    /**
     * Send the title to the specified player.
     *
     * @param player The player
     */
    public void send(Player player) {
        Titles.sendTitle(player, this.fadeIn, this.stay, this.fadeOut, this.title, this.subtitle);
    }

}
