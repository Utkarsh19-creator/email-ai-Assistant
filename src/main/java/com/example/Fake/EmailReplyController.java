package com.example.Fake;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Fake.EmailRequest;

@RestController
@RequestMapping("/api/emails")
@CrossOrigin(origins = "*")    //Allows web browsers to call this api seamlessly
public class EmailReplyController {

    private final EmailReplyService emailReplyService;
    public EmailReplyController(EmailReplyService emailReplyService){
        this.emailReplyService = emailReplyService;

    }

    @PostMapping("/reply")
    public ResponseEntity<EmailResponse> handleIncomingEmail(@RequestBody EmailRequest request){

        String reply = emailReplyService.generateReply(request);
        return ResponseEntity.ok(new EmailResponse(reply));
    }
}
