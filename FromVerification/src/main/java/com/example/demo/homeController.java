package com.example.demo;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException; // Correct import for javax.mail
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
public class homeController {

    @Autowired
    public Verification verifi;

    @Autowired
    private JavaMailSender javasend;

    @RequestMapping("")
    public String home() {
        System.out.println("Compiled Successfully!...");
        return "home";
    }

    @RequestMapping("/addDetails")
    public String addDetails(VerifyDetails details) throws MessagingException, jakarta.mail.MessagingException {
        verifi.save(details);
        sendFormSubmissionEmail(details);
        generatePDF(details); // Generate PDF after saving details
        return "home";
    }

    private void generatePDF(VerifyDetails details) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            float startX = 50;
            float startY = 700;
            float leading = 15; // Line spacing

            contentStream.beginText();
            contentStream.newLineAtOffset(startX, startY);
            contentStream.showText("Registration Number: " + details.getRegisterNumber());
            contentStream.newLineAtOffset(0, -leading);

            contentStream.showText("First Name: " + details.getFirstName());
            contentStream.newLineAtOffset(0, -leading);

            contentStream.showText("Last Name: " + details.getLastName());
            contentStream.newLineAtOffset(0, -leading);

            contentStream.showText("Date of Birth: " + details.getDob());
            contentStream.newLineAtOffset(0, -leading);

            contentStream.showText("Gender: " + details.getGender());
            contentStream.newLineAtOffset(0, -leading);

            contentStream.showText("Email ID: " + details.getEmail());
            contentStream.newLineAtOffset(0, -leading);

            contentStream.showText("Phone Number: " + details.getPhoneNumber());
            contentStream.newLineAtOffset(0, -leading);

            contentStream.showText("City: " + details.getCity());
            contentStream.newLineAtOffset(0, -leading);

            contentStream.showText("Department: " + details.getDepartment());
            contentStream.newLineAtOffset(0, -leading);

            contentStream.showText("Address: " + details.getAddress());
            contentStream.newLineAtOffset(0, -leading);

            contentStream.showText("Residential Status: " + details.getResidentialStatus());
            contentStream.newLineAtOffset(0, -leading);

            contentStream.showText("Placement Involvement: " + details.getPlacement());
            contentStream.newLineAtOffset(0, -leading);

            contentStream.endText();
            contentStream.close();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            document.save(baos);
            document.close();

            // Uncomment to save the PDF locally for debugging
            // Files.write(Paths.get("form_details.pdf"), baos.toByteArray());

            try {
				sendEmailWithAttachment(details.getEmail(), "Form Submission", "Form has been submitted successfully", "form_details.pdf", baos.toByteArray());
			} catch (jakarta.mail.MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        } catch (IOException | MessagingException e) {
            e.printStackTrace();
        }
    }




    private void sendFormSubmissionEmail(VerifyDetails details) {
        String subject = "Form Submission";
        String body = "Form has been submitted successfully";
        sendSimpleEmail(details.getEmail(), subject, body);
    }

    private void sendSimpleEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        javasend.send(message);
    }

    private void sendEmailWithAttachment(String to, String subject, String body, String attachmentName, byte[] attachmentData) throws MessagingException, jakarta.mail.MessagingException {
        jakarta.mail.internet.MimeMessage message = javasend.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body);

		InputStreamSource attachmentSource = new ByteArrayResource(attachmentData);
		helper.addAttachment(attachmentName, attachmentSource);

		javasend.send(message);
    }
}