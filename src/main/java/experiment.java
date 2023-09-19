import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class experiment {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		/*Date date=new Date();
		SimpleDateFormat sd= new SimpleDateFormat("EEEE");
		String s="Sunday September 17, 2023";
		System.out.println(sd.format(date));*/
		
		
		
		
			
		SimpleDateFormat sd=new SimpleDateFormat("YYYY-MM-dd");
		String fDate=sd.format(new Date());
			
		LocalDate ld=LocalDate.parse(fDate);
		LocalDate ld1=ld.plusWeeks(2);
		System.out.println(ld1);
		SimpleDateFormat sd1=new SimpleDateFormat("M/d/YYYY");
		Date date1 = Date.from(ld1.atStartOfDay(ZoneId.systemDefault()).toInstant());
		System.out.println(sd1.format(date1));
		
	}

}
