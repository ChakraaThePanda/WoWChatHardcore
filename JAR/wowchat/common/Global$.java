/*
 * Decompiled with CFR 0.152.
 */
package wowchat.common;

import io.netty.channel.EventLoopGroup;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import scala.Function1;
import scala.None$;
import scala.Option;
import scala.Tuple2;
import scala.collection.mutable.HashMap;
import scala.collection.mutable.MultiMap;
import scala.collection.mutable.Set;
import wowchat.common.DiscordChannelConfig;
import wowchat.common.WowChannelConfig;
import wowchat.common.WowChatConfig;
import wowchat.discord.Discord;
import wowchat.game.GameCommandHandler;

public final class Global$ {
    public static Global$ MODULE$;
    private EventLoopGroup group;
    private WowChatConfig config;
    private Discord discord;
    private Option<GameCommandHandler> game;
    private final HashMap<String, Set<WowChannelConfig>> discordToWow;
    private final HashMap<Tuple2<Object, Option<String>>, Set<Tuple2<TextChannel, DiscordChannelConfig>>> wowToDiscord;
    private final HashMap<String, Set<TextChannel>> guildEventsToDiscord;

    static {
        new Global$();
    }

    public EventLoopGroup group() {
        return this.group;
    }

    public void group_$eq(EventLoopGroup x$1) {
        this.group = x$1;
    }

    public WowChatConfig config() {
        return this.config;
    }

    public void config_$eq(WowChatConfig x$1) {
        this.config = x$1;
    }

    public Discord discord() {
        return this.discord;
    }

    public void discord_$eq(Discord x$1) {
        this.discord = x$1;
    }

    public Option<GameCommandHandler> game() {
        return this.game;
    }

    public void game_$eq(Option<GameCommandHandler> x$1) {
        this.game = x$1;
    }

    public HashMap<String, Set<WowChannelConfig>> discordToWow() {
        return this.discordToWow;
    }

    public HashMap<Tuple2<Object, Option<String>>, Set<Tuple2<TextChannel, DiscordChannelConfig>>> wowToDiscord() {
        return this.wowToDiscord;
    }

    public HashMap<String, Set<TextChannel>> guildEventsToDiscord() {
        return this.guildEventsToDiscord;
    }

    public String getTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    private Global$() {
        MODULE$ = this;
        this.game = None$.MODULE$;
        this.discordToWow = new MultiMap<String, WowChannelConfig>(){

            public Set<WowChannelConfig> makeSet() {
                return MultiMap.makeSet$(this);
            }

            public MultiMap addBinding(Object key, Object value) {
                return MultiMap.addBinding$(this, key, value);
            }

            public MultiMap removeBinding(Object key, Object value) {
                return MultiMap.removeBinding$(this, key, value);
            }

            public boolean entryExists(Object key, Function1 p) {
                return MultiMap.entryExists$(this, key, p);
            }
            {
                MultiMap.$init$(this);
            }
        };
        this.wowToDiscord = new MultiMap<Tuple2<Object, Option<String>>, Tuple2<TextChannel, DiscordChannelConfig>>(){

            public Set<Tuple2<TextChannel, DiscordChannelConfig>> makeSet() {
                return MultiMap.makeSet$(this);
            }

            public MultiMap addBinding(Object key, Object value) {
                return MultiMap.addBinding$(this, key, value);
            }

            public MultiMap removeBinding(Object key, Object value) {
                return MultiMap.removeBinding$(this, key, value);
            }

            public boolean entryExists(Object key, Function1 p) {
                return MultiMap.entryExists$(this, key, p);
            }
            {
                MultiMap.$init$(this);
            }
        };
        this.guildEventsToDiscord = new MultiMap<String, TextChannel>(){

            public Set<TextChannel> makeSet() {
                return MultiMap.makeSet$(this);
            }

            public MultiMap addBinding(Object key, Object value) {
                return MultiMap.addBinding$(this, key, value);
            }

            public MultiMap removeBinding(Object key, Object value) {
                return MultiMap.removeBinding$(this, key, value);
            }

            public boolean entryExists(Object key, Function1 p) {
                return MultiMap.entryExists$(this, key, p);
            }
            {
                MultiMap.$init$(this);
            }
        };
    }
}

