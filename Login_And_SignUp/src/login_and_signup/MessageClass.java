/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login_and_signup;
 import javax.swing.*;
/**
 *
 * @author RC_Student_lab
 */
public class MessageClass {
   
   private String[] allMessages = new String[100]; // capacity of 100 messages
    private int index = 0; // keeps track of total messages stored
   private int messageCount;
    // Store a message in the array
    public void storeMessage(String msg) {
        if (index < allMessages.length) {
            allMessages[index] = msg;
            index++;
        } else {
            // Optional: alert when storage is full
            JOptionPane.showMessageDialog(null, "Message storage is full.");
        }
    }

    // Return the number of stored messages
    public int returnTotalMessage() {
        return index;
    }

    // Print all stored messages using JOptionPane
    public void showAllMessages() {
        String messageList = "";
        for (int i = 0; i < index; i++) {
            messageList += (i + 1) + ". " + allMessages[i] + "\n";
        }

        if (messageList.isEmpty()) {
            messageList = "No messages stored.";
        }

        javax.swing.JOptionPane.showMessageDialog(null, messageList, "All Messages", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
    public void displaySendersAndRecipients() {
    String result = "";
    for (int i = 0; i < allMessages.length; i++) {
        if (allMessages[i] != null) {
            String msg = allMessages[i];
            String sender = msg.split(",")[0].replace("ID: ", "").trim();
            String recipient = msg.split("Recipient: ")[1].split(",")[0].trim();
            result += (i + 1) + ". Sender: " + sender + ", Recipient: " + recipient + "\n";
        }
    }

    if (result.equals("")) {
        result = "No messages sent.";
    }

    JOptionPane.showMessageDialog(null, result);
}
   public String getLongestMessage() {
        if (messageCount == 0) return "No messages have been sent.";

        String longest = allMessages[0];
        for (int i = 1; i < messageCount; i++) {
            if (allMessages[i] != null && allMessages[i].length() > longest.length()) {
                longest = allMessages[i];
            }
        }
        return "Longest message:\n" + longest + "\n(" + longest.length() + " characters)";
    }
    public int getMessageCount() {
        return messageCount;
    }
}




