package io.github.synchronousx.hyplay.utils;

import io.github.synchronousx.hyplay.HyplayMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

public enum Game {
    ARCADE_GAMES("Arcade Games", false, new String[][] {
            {"arcade_mini_walls", "Mini Walls"},
            {"arcade_soccer", "Football"}
    }),
    ARENA_BRAWL("Arena Brawl", false, new String[][] {
            {"arena_1v1", "Arena 1v1 Mode"},
            {"arena_2v2", "Arena 2v2 Mode"},
            {"arena_4v4", "Arena 4v4 Mode"}
    }),
    BATTLE_ROYALE("Battle Royale", true, new String[][] {
            {"prototype_royale:solo", "Solo"},
            {"prototype_royale:doubles", "Doubles"},
            {"prototype_royale:squad", "Squad"}
    }),
    BEDWARS("BedWars", false, new String[][] {
            {"bedwars_eight_one", "Solo Normal Mode"},
            {"bedwars_eight_two", "Doubles Normal Mode"},
            {"bedwars_four_three", "3v3v3v3 Normal Mode"},
            {"bedwars_four_four", "4v4v4v4 Normal Mode"},
            {"bedwars_capture_party", "Party Capture Mode"},
            {"bedwars_capture_solo", "Solo Capture Mode"}
    }),
    BLITZ_SURVIVAL_GAMES("Blitz Survival Games", false, new String[][] {
            {"blitz_solo_normal", "Solo"},
            {"blitz_teams_normal", "Teams"},
            {"blitz_solo_nokits", "No Kits"}
    }),
    BUILD_BATTLE("Build Battle", false, new String[][] {
            {"build_battle_solo_normal", "Solo Mode"},
            {"build_battle_teams_normal", "Teams Mode"},
            {"build_battle_solo_pro", "Pro Mode"},
            {"build_battle_guess_the_build", "Guess the Build"}
    }),
    CRAZY_WALLS("Crazy Walls", false, new String[][] {
            {"crazy_walls_solo", "Solo Normal"},
            {"crazy_walls_team", "Teams Normal"},
            {"crazy_walls_solo_chaos", "Solo Lucky"},
            {"crazy_walls_team_chaos", "Teams Lucky"}
    }),
    DUELS("Duels", false, new String[][] {
            {"duels_classic_duel", "Solo Classic"},
            {"duels_sw_duel", "Solo Skywars"},
            {"duels_sw_doubles", "Doubles Skywars"},
            {"duels_bow_duel", "Solo Bow"},
            {"duels_uhc_duel", "Solo UHC"},
            {"duels_uhc_doubles", "Doubles UHC"},
            {"duels_uhc_four", "Teams UHC"},
            {"duels_potion_duel", "Solo NoDebuffs"},
            {"duels_combo_duel", "Solo Combo"},
            {"duels_potion_duel", "Solo Potion"},
            {"duels_op_duel", "Solo OP"},
            {"duels_op_doubles", "Doubles OP"},
            {"duels_mw_duel", "Solo Mega Walls"},
            {"duels_mw_doubles", "Doubles Mega Walls"},
            {"duels_mw_four", "Teams Mega Walls"},
            {"duels_blitz_duel", "Solo Blitz"},
            {"duels_bowspleef_duel", "Solo Bow Spleef"},
            {"duels_uhc_tournament", "UHC Tournament"},
            {"duels_sw_tournament", "SW Tournament"}
    }),
    HIDE_AND_SEEK("Hide and Seek", true, new String[][] {
            {"prototype_hide_and_seek_party_pooper", "Party Pooper"},
            {"prototype_hide_and_seek_prop_hunt", "Prop Hunt"}
    }),
    HYPIXEL_ZOMBIES("Hypixel Zombies", true, new String[][] {
            {"prototype_zombies_story_normal", "Story Mode Normal"},
            {"prototype_zombies_story_hard", "Story Mode Hard"},
            {"prototype_zombies_story_rip", "Story Mode RIP"},
            {"prototype_zombies_endless_normal", "Endless Normal"},
            {"prototype_zombies_endless_hard", "Endless Hard"},
            {"prototype_zombies_endless_rip", "Endless RIP"}
    }),
    MURDER_MYSTERY("Murder Mystery", false, new String[][] {
            {"murder_classic", "Classic"},
            {"murder_assassins", "Assassins"},
            {"murder_showdown", "Showdown"},
            {"murder_infection", "Infection"}
    }),
    PAINTBALL_WARFARE("Paintball Warfare", false, new String[][] {
            {"paintball", "Paintball"}
    }),
    QUAKECRAFT("Quakecraft", false, new String[][] {
            {"quake_solo", "Quakecraft Solo Mode"},
            {"quake_teams", "Quakecraft Teams Mode"}
    }),
    SKYCLASH("SkyClash", false, new String[][] {
            {"skyclash_team_war", "Team War"},
            {"skyclash_solo", "Solo"},
            {"skyclash_doubles", "Doubles"}
    }),
    SKYWARS("SkyWars", false, new String[][] {
            {"ranked_normal", "Ranked"},
            {"solo_normal", "Solo Normal"},
            {"solo_insane", "Solo Insane"},
            {"teams_normal", "Teams Normal"},
            {"teams_insane", "Teams Insane"},
            {"mega_normal", "Mega"},
            {"solo_insane_tnt_madness", "Solo TNT Madness"},
            {"teams_insane_tnt_madness", "Teams TNT Madness"},
            {"solo_insane_rush", "Solo Rush"},
            {"teams_insane_rush", "Teams Rush"},
            {"solo_insane_slime", "Solo Slime"},
            {"teams_insane_slime", "Teams Slime"},
            {"solo_insane_lucky", "Solo Lucky Blocks"},
            {"teams_insane_lucky", "Teams Lucky Blocks"}
    }),
    SMASH_HEROES("Smash Heroes", false, new String[][] {
            {"super_smash_solo_normal", "Solo 1v1v1v1"},
            {"super_smash_2v2_normal", "Teams 2v2"},
            {"super_smash_teams_normal", "Teams 2v2v2"},
            {"super_smash_1v1_normal", "1v1 Mode"},
            {"super_smash_friends_normal", "Friends 1v1v1v1"}
    }),
    SPEED_UHC("Speed UHC", false, new String[][] {
            {"speed_solo_normal", "Solo Normal"},
            {"speed_solo_insane", "Solo Insane"},
            {"speed_team_normal", "Team Normal"},
            {"speed_team_insane", "Team Insane"}
    }),
    THE_BRIDGE("The Bridge", true, new String[][] {
            {"prototype_bridge_1v1", "1v1 Mode"},
            {"prototype_bridge_2v2", "2v2 Mode"},
            {"prototype_bridge_4v4", "4v4 Mode"}
    }),
    THE_TNT_GAMES("The TNT Games", false, new String[][] {
            {"tnt_tntrun", "TNT Run"},
            {"tnt_pvprun", "PVP Run"},
            {"tnt_bowspleef", "Bowspleef"},
            {"tnt_tntag", "TNT Tag"},
            {"tnt_capture", "TNT Wizards"}
    }),
    THE_WALLS("The Walls", false, new String[][] {
            {"walls_normal", "Walls"}
    }),
    TURBO_KART_RACERS("Turbo Kart Racers", false, new String[][] {
            {"tkr", "Turbo Kart Racers"}
    }),
    VAMPIREZ("VampireZ", false, new String[][] {
            {"vampirez", "VampireZ"}
    });

    public static final int GAME_TEXTURE_SIZE = 16;
    public static final String PLAY_COMMAND_PREFIX = "/play ";
    public static final String GAME_TEXTURES_DIRECTORY = "textures/games/";
    public static final String GAME_TEXTURE_EXTENSION = ".png";
    public static final String PROTOTYPE_FILENAME = "prototype" + Game.GAME_TEXTURE_EXTENSION;

    private final String displayName;
    private final boolean prototype;
    private final String[][] playNamesArray;
    private final ResourceLocation texture;

    Game(final String displayName, final boolean prototype, final String[][] playNamesArray) {
        this.displayName = displayName;
        this.prototype = prototype;
        this.playNamesArray = playNamesArray;
        this.texture = new ResourceLocation(HyplayMod.MODID, Game.GAME_TEXTURES_DIRECTORY + this.getTextureFilename());
    }

    private String getTextureFilename() {
        return this.prototype ? PROTOTYPE_FILENAME : (this.name().toLowerCase().replace('_', '-') + Game.GAME_TEXTURE_EXTENSION);
    }

    public void bindTexture() {
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.texture);
    }

    public void drawTexture(final Gui gui, final int x, final int y) {
        this.bindTexture();
        gui.drawModalRectWithCustomSizedTexture(x, y, 0, 0, Game.GAME_TEXTURE_SIZE, Game.GAME_TEXTURE_SIZE, Game.GAME_TEXTURE_SIZE, Game.GAME_TEXTURE_SIZE);
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public boolean isPrototype() {
        return this.prototype;
    }

    public String[][] getPlayNamesArray() {
        return this.playNamesArray;
    }

    public ResourceLocation getTexture() {
        return this.texture;
    }
}
