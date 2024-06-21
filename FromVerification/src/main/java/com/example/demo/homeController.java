package com.example.demo;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.mail.MessagingException; 
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
        generatePDF(details); // Generate PDF after saving details
        return "home";
    }

    private void generatePDF(VerifyDetails details) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.setFont(PDType1Font.HELVETICA, 12);
            float startX = 50;
            float startY = 700;
            float leading = 25;

            contentStream.beginText();
            contentStream.newLineAtOffset(startX, startY);
            
            contentStream.setFont(PDType1Font.HELVETICA_BOLD,12);
            contentStream.showText("Registration Number:");
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.showText(" "+details.getRegisterNumber());
            contentStream.newLineAtOffset(0, -leading);

            contentStream.setFont(PDType1Font.HELVETICA_BOLD,12);
            contentStream.showText("First Name:");
            contentStream.setFont(PDType1Font.HELVETICA,12);
            contentStream.showText(" " + details.getFirstName());
            contentStream.newLineAtOffset(0, -leading);

            contentStream.setFont(PDType1Font.HELVETICA_BOLD,12);
            contentStream.showText("Last Name:");
            contentStream.setFont(PDType1Font.HELVETICA,12);
            contentStream.showText(" " + details.getLastName());
            contentStream.newLineAtOffset(0, -leading);

            contentStream.setFont(PDType1Font.HELVETICA_BOLD,12);
            contentStream.showText("Date of Birth:");
            contentStream.setFont(PDType1Font.HELVETICA,12);
            contentStream.showText(" " + details.getDob());
            contentStream.newLineAtOffset(0, -leading);

            contentStream.setFont(PDType1Font.HELVETICA_BOLD,12);
            contentStream.showText("Gender:");
            contentStream.setFont(PDType1Font.HELVETICA,12);
            contentStream.showText(" " + details.getGender());
            contentStream.newLineAtOffset(0, -leading);

            contentStream.setFont(PDType1Font.HELVETICA_BOLD,12);
            contentStream.showText("Email ID:");
            contentStream.setFont(PDType1Font.HELVETICA,12);
            contentStream.showText(" " + details.getEmail());
            contentStream.newLineAtOffset(0, -leading);

            contentStream.setFont(PDType1Font.HELVETICA_BOLD,12);
            contentStream.showText("Phone Number:");
            contentStream.setFont(PDType1Font.HELVETICA,12);
            contentStream.showText(" " + details.getPhoneNumber());
            contentStream.newLineAtOffset(0, -leading);

            contentStream.setFont(PDType1Font.HELVETICA_BOLD,12);
            contentStream.showText("City:");
            contentStream.setFont(PDType1Font.HELVETICA,12);
            contentStream.showText(" " + details.getCity());
            contentStream.newLineAtOffset(0, -leading);

            contentStream.setFont(PDType1Font.HELVETICA_BOLD,12);
            contentStream.showText("Department:");
            contentStream.setFont(PDType1Font.HELVETICA,12);
            contentStream.showText(" " + details.getDepartment());
            contentStream.newLineAtOffset(0, -leading);

            contentStream.setFont(PDType1Font.HELVETICA_BOLD,12);
            contentStream.showText("Address:");
            contentStream.setFont(PDType1Font.HELVETICA,12);
            contentStream.showText(" " + details.getAddress());
            contentStream.newLineAtOffset(0, -leading);

            String status=details.getResidentialStatus();
            if(status=="H")
            	status+="osteller";
            else
            	status+="ays Scholar";
            contentStream.setFont(PDType1Font.HELVETICA_BOLD,12);
            contentStream.showText("Residentital Status:");
            contentStream.setFont(PDType1Font.HELVETICA,12);
            contentStream.showText(" " + status);
            contentStream.newLineAtOffset(0, -leading);

            String place=details.getPlacement();
            if(place=="Y")
            	place+="es";
            else
            	place+="o";
            contentStream.setFont(PDType1Font.HELVETICA_BOLD,12);
            contentStream.showText("Placement Involvement:");
            contentStream.setFont(PDType1Font.HELVETICA,12);
            contentStream.showText(" " + place);
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