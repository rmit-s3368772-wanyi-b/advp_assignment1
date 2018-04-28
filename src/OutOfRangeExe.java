
public class OutOfRangeExe extends Exception {

	public OutOfRangeExe(String msg) {
		super(msg);
		System.out.println("Input is not an valid option");
	}
}
