package world.maryt.wheelchair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = Wheelchair.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue SHOULD_NOTIFY_PLAYERS = BUILDER.comment("If true, Everytime WheelChair notify the player it is activated.").define("shouldNotifyPlayers", true);

    private static final ForgeConfigSpec.IntValue MOB_SHOULD_DIE_WITHIN_THIS_ATTACKS = BUILDER.comment("Mob should be killed in this time of attacks.\nToo large value make battles very hard, now you have benn warned.").defineInRange("mobShouldDieWithinThisAttacks", 10, 0, 20);

    public static final ForgeConfigSpec.DoubleValue PROTECT_PLAYERS_AT_THIS_HP = BUILDER.comment("If the player's HP is lower than this value, protect player from losing face.").defineInRange("protectPlayersAtThisHP", 1.0, 0.0, Double.MAX_VALUE);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean shouldNotifyPlayers;
    public static int mobShouldDieWithinThisAttacks;
    public static float protectPlayersAtThisHP;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        shouldNotifyPlayers = SHOULD_NOTIFY_PLAYERS.get();
        mobShouldDieWithinThisAttacks = MOB_SHOULD_DIE_WITHIN_THIS_ATTACKS.get();
        protectPlayersAtThisHP = PROTECT_PLAYERS_AT_THIS_HP.get().floatValue();
    }
}
