/*
 * Copyright © 2023 BoritoPalito. All Rights Reserved.
 *
 * This source code and its associated files are the exclusive property of BoritoPalito and may not be reproduced,
 * distributed, modified, or used in any manner without the express written permission of the copyright owner.
 */

package org.example.helpers;

import org.example.Main;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DownloadFile {
    public static void download(String url, String saveAs) {
        try(InputStream inputStream = new URL(url).openStream()) {
            Path savePath = Paths.get(Main.destinationDir, saveAs);
            System.out.printf("Saving to dir: %s\n", savePath);
            Files.copy(inputStream, savePath);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
