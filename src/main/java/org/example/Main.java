/*
 * Copyright © 2023 BoritoPalito. All Rights Reserved.
 *
 * This source code and its associated files are the exclusive property of BoritoPalito and may not be reproduced,
 * distributed, modified, or used in any manner without the express written permission of the copyright owner.
 */
package org.example;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.example.listeners.AttachmentListener;

public class Main {

    public static String destinationDir;

    public static void main(String[] args) {
        String discordToken = args[0];
        destinationDir = args[1];

        JDA jda = JDABuilder.createDefault(
                        discordToken
                )
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();

        jda.addEventListener(new AttachmentListener());
    }
}