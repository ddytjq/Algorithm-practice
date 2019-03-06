import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

public class Test {

	public static int a(int j){

		return 1;
	}
	public static void main(String[] args) {
		try{
			System.out.println(a(1));
		}catch (Exception ex){
			ex.getMessage();
		}
	}

}
