package org.example.listeners;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.example.helpers.DownloadFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AttachmentListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getAttachments().size() == 1) {
            if (!event.getMessage().getButtonsByLabel("U1", true).isEmpty())
                return;

            Message.Attachment attachment = event.getMessage().getAttachments().get(0);
            String url = attachment.getUrl();
            String name = attachment.getFileName();
            System.out.printf("File: %s\n", name);
            DownloadFile.download(url, name);
        }
    }
}
