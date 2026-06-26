package com.example.Fake;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.stereotype.Service;

@Service
public class EmailReplyService {
    private final Client client;
    public EmailReplyService(){
        //Automatically picks up GEMINI_API_KEY from Environment variables
        this.client= Client.builder()
                .apiKey(System.getenv("GEMINI_API_KEY"))
                .build();
    }
    public String generateReply(EmailRequest emailRequest){
        //construct an explicit prompt context for gemini
        String prompt = String.format("you are an advanced professional  AI email assistant. Write a clear,,polite, and contextual reply to the following incoming email.\n\n" +
                "Sender: %s\n" +
                "Subject:%s \n" +
                "Email Body:\n\"\"\"\n%s\n\"\"\"\n\n" +
                "provide only the generated reply without any surrounding chat text or commentary.",
                emailRequest.getSender(),
                emailRequest.getSubject(),
                emailRequest.getBody()
                );

        try{
            //Using gemini-2.5-flash for rapid, cost-efficient generation
            GenerateContentResponse response = client.models.generateContent(
                    "gemini-2.5-flash",
                    prompt,null);
            return response.text();
        }
        catch(Exception e){
            throw new RuntimeException("Failed to reach Gemini API:" + e.getMessage(),e);
        }

    }

}
