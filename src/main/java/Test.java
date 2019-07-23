import com.lowagie.text.*;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class Test {
    public static void main(String[] args) throws IOException, DocumentException {

        Scanner input = new Scanner(System.in);
        String Name;
        String sName;
        String fName;
        String wayf;
        String wayfoto;
        int month;
        int Data;
        int ygod;
        int ngod =2019;

        System.out.print("укажите путь создания фаила: ");
        wayf =input.nextLine();
        System.out.print("укажите путь к вашей фотографии: ");
        wayfoto =input.nextLine();
        System.out.print("Ваше имя: ");
        Name = input.nextLine();
        System.out.print("Ваше отчество: ");
        sName = input.nextLine();
        System.out.print("Ваша Фамилия: ");
        fName = input.nextLine();
        System.out.print("Дата рождания: ");
        Data = input.nextInt();
        System.out.print("Месяц рождения: ");
        month = input.nextInt();
        System.out.print("Год рождения: ");
        ygod = input.nextInt();


// наследование формата шрифта (подключение русского языка).
        BaseFont TNfont;
        TNfont = (BaseFont) BaseFont.createFont("C:\\Windows\\Fonts\\times.ttf", "cp1251", BaseFont.EMBEDDED);
//  создание документа А4.
        Document document = new Document(PageSize.A4, 50, 50 ,50 ,50);
//Путь записи созданного документа.
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(""+wayf+"TextRu.pdf"));
// Открытие документа для записи.
        document.open();
// Запись заголовка по центру в документе. 28 размер шрифта, жирный.
        Paragraph title = new Paragraph("Данные о гражданине.", new Font(TNfont, 28, Font.BOLD));
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
//Создаём название таблицы.
        Paragraph tabl1 = new Paragraph("Таблица 1. ИОФ", new Font(TNfont, 14));
        tabl1.setAlignment(Element.ALIGN_RIGHT);
        document.add(tabl1);
// Создаём таблиц ИОФ.
        PdfPTable t = new PdfPTable(2);
        t.setSpacingBefore(25);
        t.setSpacingAfter(35);
        PdfPCell c1 = new PdfPCell(new Phrase("Имя", new Font(TNfont, 12)));
        t.addCell(c1);
        PdfPCell c2 = new PdfPCell(new Phrase(""+Name+"", new Font(TNfont, 12)));
        t.addCell(c2);
        PdfPCell c3 = new PdfPCell(new Phrase("Отчество", new Font(TNfont, 12)));
        t.addCell(c3);
        PdfPCell c4 = new PdfPCell(new Phrase(""+sName+"", new Font(TNfont, 12)));
        t.addCell(c4);
        PdfPCell c5 = new PdfPCell(new Phrase("Фамилия", new Font(TNfont, 12)));
        t.addCell(c5);
        PdfPCell c6 = new PdfPCell(new Phrase(""+fName+"", new Font(TNfont, 12)));
        t.addCell(c6);
        document.add(t);
 //создаёи название таблицы 2.
        Paragraph tabl2 = new Paragraph("Таблица 2. Возраст", new Font(TNfont, 14));
        tabl2.setAlignment(Element.ALIGN_RIGHT);
        document.add(tabl2);
//Создаём таблицу возраст.
        PdfPTable t1 = new PdfPTable(4);
        t1.setSpacingBefore(10);
        t1.setSpacingAfter(10);
        PdfPCell s1 = new PdfPCell(new Phrase("Дата", new Font(TNfont, 12)));
        t1.addCell(s1);
        PdfPCell s2 = new PdfPCell(new Phrase("Месяц", new Font(TNfont, 12)));
        t1.addCell(s2);
        PdfPCell s3 = new PdfPCell(new Phrase("год", new Font(TNfont, 12)));
        t1.addCell(s3);
        PdfPCell s4 = new PdfPCell(new Phrase("Ваш возраст", new Font(TNfont, 12)));
        t1.addCell(s4);
        t1.addCell( ""+Data+"");
        t1.addCell(""+month+"");
        t1.addCell(""+ygod+"");
        t1.addCell(""+(ngod-ygod)+"");
        document.add(t1);

        Image image1 = Image.getInstance(""+wayfoto+"");
        image1.scaleAbsolute(250f,300f);
        image1.setAlignment(Element.ALIGN_CENTER);
        document.add(image1);


        document.close();


    }
}
