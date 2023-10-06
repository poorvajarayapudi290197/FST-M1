package Activities;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Activity15 {
    private static String FILE_NAME = "C:\\Users\\003VE7744\\IdeaProjects\\FST_JAVA\\src\\main\\resources\\TestSheet.xlsx";
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
        Object[][] datatypes = {
                {"Datatype", "Type", "Size(in bytes)"},
                {"int", "Primitive", 2},
                {"float", "Primitive", 4},
                {"double", "Primitive", 8},
                {"char", "Primitive", 1},
                {"String", "Non-Primitive", "No fixed size"}
        };
        int rowNum = 0;

        for (Object[] datatype : datatypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");

        readData();
    }
    public static void readData() throws IOException {
        FileInputStream fis=new FileInputStream("C:\\Users\\003VE7744\\IdeaProjects\\FST_JAVA\\src\\main\\resources\\TestSheet.xlsx");
//constructs an XSSFWorkbook object, by buffering the whole stream into the memory
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        //  XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.getSheetAt(0);
        for(Row row: sheet)     //iteration over row using for each loop
        {
            for(Cell cell: row)    //iteration over cell using for each loop
            {
                CellType celltype=cell.getCellType();
                if(celltype.equals(celltype.STRING)) { //field that represents numeric cell type
//getting the value of the cell as a number
                    System.out.print(cell.getStringCellValue() + "\t\t");

                }
                if(celltype.equals(celltype.NUMERIC)) {
                    //field that represents string cell type
//getting the value of the cell as a string
                    System.out.print(cell.getNumericCellValue()+ "\t\t");

                }
            }
            System.out.println();
        }
    }
}
