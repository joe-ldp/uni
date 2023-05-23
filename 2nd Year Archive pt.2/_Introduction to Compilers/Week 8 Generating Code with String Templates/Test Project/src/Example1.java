import org.stringtemplate.v4.*;

public class Example1
{
	public static void main(String[] args) {
		String assign = "<left> = <right>;";
		ST st = new ST(assign);
		st.add("left", "a");
		st.add("right", "12");
		System.out.println(st.render());
	}
}